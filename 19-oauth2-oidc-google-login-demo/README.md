# 19 - OAuth 2.0, OpenID Connect & Google Login Demo

A Spring Boot project demonstrating **OAuth 2.0, OpenID Connect (OIDC), Google Login, Authorization Code Flow, and integration of Google-authenticated users with an internal MySQL database** using Spring Security.

---

# Features

- Google Login
- OAuth 2.0
- OpenID Connect (OIDC)
- Authorization Code Flow
- OAuth 2.0 Client
- Google as Authorization Server / Identity Provider
- OIDC User Authentication
- Access Token
- ID Token
- Refresh Token Concepts
- OAuth Scopes
- Consent
- Authorization Code
- State Parameter
- PKCE Concepts
- Custom `OidcUserService`
- `OidcUser`
- `SecurityFilterChain`
- Session-Based Authentication
- Internal User Registration / Update
- Provider + Provider Subject Mapping
- Spring Data JPA
- MySQL

---

# Tech Stack

- Java 25
- Spring Boot 4.1.0
- Spring Security
- Spring OAuth2 Client
- OpenID Connect
- Spring Data JPA
- Hibernate ORM
- MySQL
- Maven
- Lombok

---

# Project Structure

```text
OAuthDemo
│
├── pom.xml
│
└── src
    └── main
        ├── java
        │   └── com.vinay7.OAuthDemo
        │       ├── config
        │       │   └── SecurityConfig.java
        │       │
        │       ├── controller
        │       │   └── UserController.java
        │       │
        │       ├── entity
        │       │   └── User.java
        │       │
        │       ├── repository
        │       │   └── UserRepository.java
        │       │
        │       ├── service
        │       │   ├── UserService.java
        │       │   └── CustomOidcUserService.java
        │       │
        │       └── OAuthDemoApplication.java
        │
        └── resources
            └── application.properties
```

---

# Configuration

```properties
spring.application.name=OAuthDemo
server.port=8081

# Google OAuth2 / OIDC
spring.security.oauth2.client.registration.google.client-id=${CLIENT_ID}
spring.security.oauth2.client.registration.google.client-secret=${CLIENT_SECRET}
spring.security.oauth2.client.registration.google.scope=openid,profile,email

# Database
spring.datasource.url=jdbc:mysql://localhost:3306/newstudent_db
spring.datasource.username=root
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

### Environment Variables

Do not hardcode the Google client secret.

Set:

```text
CLIENT_ID=your-google-client-id
CLIENT_SECRET=your-google-client-secret
```

---

# Base URL

```text
http://localhost:8081
```

---

# API Endpoints

| Method | Endpoint | Authentication | Description |
|--------|----------|----------------|-------------|
| GET | `/` | Public | Home endpoint |
| GET | `/oauth2/authorization/google` | Public | Start Google Login |
| GET | `/login/oauth2/code/google` | OAuth Callback | Google OAuth2 callback |
| GET | `/profile` | Required | Get authenticated user's profile |

---

# Start Google Login

Open:

```text
http://localhost:8081/oauth2/authorization/google
```

Spring Security uses the `google` registration ID from:

```properties
spring.security.oauth2.client.registration.google.*
```

---

# Google OAuth Configuration

In Google Cloud, register the application as a Web Application.

### Authorized Redirect URI

```text
http://localhost:8081/login/oauth2/code/google
```

The redirect URI must exactly match the URI configured in Google.

### Scopes

This project requests:

```text
openid
profile
email
```

- `openid` → enables OpenID Connect
- `profile` → basic profile information
- `email` → user's email information

---

# OAuth 2.0 Flow

```text
User
 ↓
Spring Boot Application
 ↓
/oauth2/authorization/google
 ↓
Google Authorization Server
 ↓
User Authentication
 ↓
User Consent
 ↓
Authorization Code
 ↓
/login/oauth2/code/google
 ↓
Spring Boot exchanges code with Google
 ↓
Access Token + ID Token
 ↓
Spring processes OIDC response
 ↓
OidcUser
 ↓
CustomOidcUserService
 ↓
Save / Update User in MySQL
 ↓
Spring Security Session
 ↓
/profile
```

---

# Authorization Code Flow

The application uses the Authorization Code Flow.

### Authorization Request

Spring sends information such as:

```text
client_id
redirect_uri
scope
response_type=code
state
```

### Callback

Google redirects the browser to:

```text
http://localhost:8081/login/oauth2/code/google
```

with a temporary authorization code and state.

```text
/login/oauth2/code/google?code=...&state=...
```

The authorization code is then exchanged by the backend for tokens.

---

# OAuth 2.0 Roles

| Role | In This Project |
|------|------------------|
| Resource Owner | User |
| Client | OAuthDemo Spring Boot Application |
| Authorization Server | Google |
| Resource Server | Protected resource accessed using an access token |

---

# OAuth Tokens

### Access Token

Used by a client to access a protected resource.

```text
Client → Resource Server
Authorization: Bearer <access-token>
```

### ID Token

Provided by OpenID Connect and contains identity information about the authenticated user.

Typical claims include:

```json
{
  "sub": "google-user-id",
  "iss": "https://accounts.google.com",
  "aud": "google-client-id",
  "name": "Vinay",
  "email": "user@gmail.com"
}
```

### Refresh Token

Can be used to obtain a new access token after an access token expires when one is issued by the authorization server.

---

# OAuth 2.0 vs OpenID Connect

| Technology | Main Purpose |
|------------|--------------|
| OAuth 2.0 | Delegated Authorization |
| OpenID Connect | Authentication & Identity |

OAuth 2.0 answers:

```text
What can this application access?
```

OpenID Connect answers:

```text
Who signed in?
```

---

# User Database

The application maintains its own internal user record after Google authentication.

### User Entity

```text
id
name
email
provider
providerSubject
```

There is **no password field** because Google handles the user's Google credentials.

---

# Provider + Subject

The application identifies the external Google user using:

```text
provider
+
providerSubject
```

For Google:

```text
provider = google
providerSubject = Google user's sub claim
```

The repository provides:

```java
Optional<User> findByProviderAndProviderSubject(
        String provider,
        String providerSubject
);
```

---

# User Registration / Update Flow

```text
Google Authentication
        ↓
OidcUser
        ↓
CustomOidcUserService
        ↓
UserService.registerOrUpdate()
        ↓
Find provider + providerSubject
        ↓
       / \
    Found  Not Found
      ↓        ↓
   Update    Create
      \        /
       ↓      ↓
      MySQL
```

If the user already exists, the latest name and email are updated.

If the user does not exist, a new internal user is created.

---

# Custom OIDC User Service

`CustomOidcUserService` delegates the normal OIDC processing to Spring Security:

```java
OidcUser oidcUser =
        oidcUserService.loadUser(userRequest);
```

Then the application performs its own database logic:

```java
userService.registerOrUpdate(provider, oidcUser);
```

Finally, the `OidcUser` is returned to Spring Security.

---

# Security Configuration

The application allows the home endpoint without authentication:

```java
.requestMatchers("/").permitAll()
.anyRequest().authenticated()
```

OAuth2 Login is enabled using:

```java
.oauth2Login(...)
```

The custom OIDC user service is configured through:

```java
.userInfoEndpoint(userInfo ->
    userInfo.oidcUserService(customOidcUserService)
)
```

After successful login:

```text
/profile
```

---

# Profile API

### GET

```text
http://localhost:8081/profile
```

Requires authentication.

### Example Response

```json
{
  "internalUserId": 1,
  "provider": "google",
  "subject": "google-user-subject",
  "name": "Vinay",
  "email": "user@gmail.com"
}
```

The response combines:

```text
Google / OIDC
├── subject
├── name
└── email

Application Database
└── internalUserId
```

---

# Session-Based Authentication

After successful OAuth2 Login:

```text
Google Authentication
        ↓
Spring Security
        ↓
SecurityContext
        ↓
HTTP Session
        ↓
Session Cookie
        ↓
Authenticated Requests
```

The browser does not send Google's ID token with every `/profile` request.

This project uses the traditional server-side OAuth2 Login flow, where the authenticated state is maintained through the HTTP session.

---

# Front Channel & Back Channel

### Front Channel

Communication through the user's browser.

```text
Authorization Request
Authorization Code
State
```

### Back Channel

Direct communication between the backend and Google's token endpoint.

```text
Authorization Code Exchange
Access Token
ID Token
Refresh Token
```

---

# PKCE Concepts

PKCE stands for:

```text
Proof Key for Code Exchange
```

Conceptually:

```text
code_verifier
      ↓
SHA-256
      ↓
code_challenge
```

The authorization request sends the `code_challenge`, while the client keeps the `code_verifier`.

During token exchange:

```text
authorization_code
+
code_verifier
        ↓
Authorization Server
        ↓
Verify challenge
        ↓
Issue tokens
```

PKCE helps protect the authorization code exchange against stolen authorization codes.

---

# Concepts Covered

## OAuth 2.0

- Delegated Authorization
- OAuth Roles
- Resource Owner
- Client
- Authorization Server
- Resource Server
- Scopes
- Consent
- Access Token
- Authorization Code
- Authorization Code Flow
- State
- Front Channel
- Back Channel
- Refresh Token
- PKCE

## OpenID Connect

- OIDC
- Authentication
- Identity
- ID Token
- OidcUser
- OIDC Claims
- `sub`
- `iss`
- `aud`
- `exp`

## Spring Security

- OAuth2 Client
- `oauth2Login()`
- `SecurityFilterChain`
- `SecurityContext`
- Session-Based Authentication
- `OidcUserService`
- Custom OIDC User Service
- `OidcUser`
- Authentication Principal

## Spring Data JPA

- `JpaRepository`
- Entity Mapping
- Database User Storage
- Derived Query Methods
- Provider + Subject Lookup
- User Registration / Update

## Google Login

- Google OAuth Client
- Google Client ID
- Google Client Secret
- Redirect URI
- Google Scopes
- Google Authentication
- Google Consent
- Google OIDC Login

---

# Learning Objective

This project demonstrates how to move from application-controlled authentication to **delegated authentication using Google OAuth 2.0 and OpenID Connect**, while still maintaining an internal application user record in MySQL.
