# 18 - Spring Security Database Authentication Demo

A Spring Boot project demonstrating **database-backed authentication with Spring Security** and the internal flow of username-password authentication.

The project covers Spring Security filters, `SecurityFilterChain`, `AuthenticationManager`, `ProviderManager`, `DaoAuthenticationProvider`, `UserDetails`, `UserDetailsService`, BCrypt password hashing, database user loading, roles and authorities, form login, HTTP Basic authentication, and CSRF configuration.

---

# Features

- User Registration
- Database-backed Authentication
- BCrypt Password Hashing
- Custom `UserDetails`
- Custom `UserDetailsService`
- `DaoAuthenticationProvider`
- `AuthenticationManager`
- `ProviderManager`
- `SecurityFilterChain`
- HTTP Basic Authentication
- Form Login
- Role-based Authorities
- User-Role Many-to-Many Mapping
- `EntityGraph` for loading User Roles
- CSRF Configuration
- MySQL Database
- Spring Data JPA

---

# Tech Stack

- Java 25
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate ORM
- MySQL
- Maven
- Lombok

---

# Project Structure

```text
src
├── config
│   └── SecurityConfig
│
├── controller
│   ├── RoleController
│   └── UserController
│
├── dto
│   ├── UserRegisterRequestDto
│   └── UserRegisterResponseDto
│
├── entity
│   ├── CustomUserDetails
│   ├── Role
│   └── User
│
├── repository
│   ├── RoleRepository
│   └── UserRepository
│
├── service
│   ├── AuthService
│   ├── CustomUserDetailsService
│   └── RoleService
│
└── SpringSecurityDemoApplication
```

---

# Base URL

```text
http://localhost:8081
```

---

# API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/users/hello` | Test API |
| POST | `/api/users/register` | Register a new user |
| POST | `/api/roles` | Create a role |

---

# API Requests

## 1. Test API

### GET

```text
http://localhost:8081/api/users/hello
```

The endpoint requires authentication.

Use HTTP Basic Authentication:

```text
Username: <registered-username>
Password: <password>
```

### Response

```text
Hello
```

---

# 2. Create Role

A role must exist before registering a user because the registration service assigns:

```text
ROLE_USER
```

to the new user.

### POST

```text
http://localhost:8081/api/roles
```

### Request Body

```json
{
  "name": "ROLE_USER"
}
```

### Response

```text
DONE
```

---

# 3. Register User

The registration endpoint is permitted without authentication.

### POST

```text
http://localhost:8081/api/users/register
```

### Request Body

```json
{
  "username": "vinay",
  "password": "vinay12345"
}
```

### Response

```json
{
  "username": "vinay",
  "message": "User saved Successfully"
}
```

During registration:

```text
Raw Password
     ↓
PasswordEncoder
     ↓
BCrypt
     ↓
Encoded Password
     ↓
UserRepository
     ↓
MySQL
```

The server automatically assigns the default role:

```text
ROLE_USER
```

---

# Authentication

Spring Security performs authentication before the request reaches the controller.

The request passes through security filters before reaching the DispatcherServlet and controller.

```text
HTTP Request
     ↓
Servlet Filters
     ↓
Spring Security Filters
     ↓
DispatcherServlet
     ↓
Controller
```

The purpose is to determine:

- Who is making the request
- Whether the supplied identity is valid
- Which roles or authorities the user has
- Whether the user is allowed to access the requested resource

---

# Security Filter Chain

The simplified security flow is:

```text
Protection
     ↓
Authentication
     ↓
Exception Handling
     ↓
Authorization
```

Authentication must happen before authorization because Spring Security needs to establish the user's identity before checking roles or authorities.

---

# DelegatingFilterProxy

`DelegatingFilterProxy` connects the servlet container with Spring-managed security filters.

```text
Tomcat
   ↓
DelegatingFilterProxy
   ↓
FilterChainProxy
```

It delegates the request from the servlet container to the Spring Security filter infrastructure.

---

# FilterChainProxy

`FilterChainProxy` is the central filter of Spring Security's servlet architecture.

It manages one or more `SecurityFilterChain` objects.

```text
FilterChainProxy
├── SecurityFilterChain for /api/**
├── SecurityFilterChain for /admin/**
└── SecurityFilterChain for other requests
```

For each request, it determines which security filter chain should process the request.

---

# SecurityFilterChain

A `SecurityFilterChain` contains:

- Request matcher
- Ordered list of security filters

The project configures its security chain using `HttpSecurity`.

---

# HttpSecurity

`HttpSecurity` is used to configure and build the application's `SecurityFilterChain`.

The project configures:

- CSRF
- Authentication Provider
- Form Login
- HTTP Basic Authentication
- Authorization Rules

---

# Authentication Filters

Different authentication mechanisms use different filters.

## Form Login

```text
POST /login
```

Form login credentials are handled by:

```text
UsernamePasswordAuthenticationFilter
```

## HTTP Basic

Credentials are sent through:

```text
Authorization: Basic <encoded-credentials>
```

HTTP Basic authentication is handled by:

```text
BasicAuthenticationFilter
```

Both mechanisms eventually use the same underlying authentication engine.

---

# UsernamePasswordAuthenticationToken

Spring Security converts username and password credentials into an authentication token.

Before authentication:

```text
UsernamePasswordAuthenticationToken
├── principal = username
├── credentials = password
├── authorities = []
└── authenticated = false
```

At this stage, the token represents an authentication request and not a verified identity.

---

# AuthenticationManager

`AuthenticationManager` is the entry point into Spring Security's authentication engine.

```text
AuthenticationManager
        ↓
authenticate()
        ↓
Success / Failure
```

It receives an unauthenticated authentication request and returns an authenticated result or throws an authentication exception.

---

# ProviderManager

`ProviderManager` is the commonly used implementation of `AuthenticationManager`.

It coordinates different `AuthenticationProvider` implementations.

```text
AuthenticationManager
        ↓
ProviderManager
        ↓
AuthenticationProvider
```

For username-password database authentication, the relevant provider is:

```text
DaoAuthenticationProvider
```

---

# DaoAuthenticationProvider

`DaoAuthenticationProvider` performs username-password authentication using:

- `UserDetailsService`
- `PasswordEncoder`

```text
DaoAuthenticationProvider
       /              \
      ↓                ↓
UserDetailsService  PasswordEncoder
      ↓                ↓
UserRepository      BCrypt
      ↓
Database
```

Its responsibilities include:

- Loading the user
- Obtaining the stored encoded password
- Checking account status
- Verifying the password
- Creating the authenticated result

---

# UserDetails

`UserDetails` represents Spring Security's view of a user.

The project uses:

```text
CustomUserDetails
```

which implements:

```java
UserDetails
```

It exposes:

- Username
- Password
- Authorities
- Enabled state

The application `User` entity and Spring Security's `UserDetails` are separate concepts.

```text
Application User Entity
          ↓
   CustomUserDetails
          ↓
Spring Security UserDetails
```

---

# CustomUserDetails

The project uses a custom adapter:

```java
public class CustomUserDetails implements UserDetails
```

It converts the application's `User` entity into the representation understood by Spring Security.

Authorities are created from the user's roles:

---

# UserDetailsService

`UserDetailsService` answers:

```text
Given a username, how should Spring Security load that user?
```

The project implements:

```text
CustomUserDetailsService
```

The flow is:

```text
Spring Security
       ↓
CustomUserDetailsService
       ↓
UserRepository
       ↓
Database
       ↓
User
       ↓
CustomUserDetails
```

The user is loaded using:

```java
userRepository.findByUsername(username)
```

If the user does not exist:

```text
UsernameNotFoundException
```

is thrown.

---

# UserRepository

The project uses Spring Data JPA:

```java
public interface UserRepository extends JpaRepository<User, Long>
```

The login lookup is:

```java
Optional<User> findByUsername(String username);
```

The project also uses:

```java
@EntityGraph(attributePaths = "roles")
```

to fetch the user's roles together with the user.

---

# EntityGraph

The repository method uses:

```java
@EntityGraph(attributePaths = "roles")
Optional<User> findByUsername(String username);
```

This ensures the roles are fetched as part of the user-loading operation.

```text
User
 ├── username
 ├── password
 ├── enabled
 └── roles
```

This is particularly useful because the roles are required when Spring Security creates the user's authorities.

---

# Password Security

Passwords should never be stored as plain text.

The project uses:

```java
BCryptPasswordEncoder
```

during registration.

```text
Raw Password
     ↓
BCryptPasswordEncoder
     ↓
Encoded Password
     ↓
Database
```

---

# Password Verification

During authentication, Spring Security does not simply compare the raw password with the stored string.

Instead:

```java
passwordEncoder.matches(
        rawPassword,
        storedEncodedPassword
);
```

The result is:

```text
true
```

or

```text
false
```

The raw password is not stored in the database.

---

# Registration Flow

Registration and login are separate flows.

```text
Client
   ↓
POST /api/users/register
   ↓
AuthService
   ↓
PasswordEncoder.encode()
   ↓
BCrypt Encoded Password
   ↓
Find ROLE_USER
   ↓
Assign Role
   ↓
UserRepository
   ↓
Database
```

---

# Login Flow

The complete database authentication flow is:

```text
HTTP Request
      ↓
Authentication Filter
      ↓
UsernamePasswordAuthenticationToken
      ↓
AuthenticationManager
      ↓
ProviderManager
      ↓
DaoAuthenticationProvider
      ↓
UserDetailsService
      ↓
UserRepository
      ↓
Database
      ↓
CustomUserDetails
      ↓
PasswordEncoder
      ↓
Password Verification
      ↓
Authenticated Authentication
      ↓
SecurityContext
      ↓
SecurityContextHolder
      ↓
Authorization
      ↓
Controller
```

---

# Authentication Success

After successful authentication:

```text
UsernamePasswordAuthenticationToken
        ↓
Authenticated = true
        ↓
SecurityContext
        ↓
SecurityContextHolder
        ↓
Authorization
        ↓
Controller
```

The authenticated object contains information such as:

- Principal
- Authorities
- Authentication status

The controller does not need to verify the password again.

---

# Authentication Failure

Authentication can fail when:

- User does not exist
- Password is incorrect
- Account is disabled
- Account is locked
- Account is expired
- Credentials are expired

If authentication fails, a trusted authenticated object is not placed into the security context.

---

# Roles and Authorities

The project uses roles such as:

```text
ROLE_USER
ROLE_ADMIN
```

Roles are stored in the database and mapped to Spring Security authorities.

```text
User
  ↓
Roles
  ↓
GrantedAuthority
  ↓
Authorization
```

---

# User-Role Relationship

Users and roles have a Many-to-Many relationship.

```text
User
  │
  ├── ROLE_USER
  │
  └── ROLE_ADMIN
```

The relationship uses a join table:

```text
users
   │
   ↓
user_roles
   ↑
   │
roles
```

---

# CSRF

CSRF is disabled in the current classroom API configuration:

```java
.csrf(csrf -> csrf.disable())
```

This allows the REST API requests to be tested directly without sending CSRF tokens.

Disabling CSRF here is a project/demo configuration and should not automatically be treated as a production recommendation.

---

# Database Structure

## User

```text
User
--------------------------------
id
username
password
enabled
roles
```

## Role

```text
Role
--------------------------------
id
name
```

## User Roles

```text
user_roles
--------------------------------
user_id
role_id
```

---

# Concepts Covered

## Spring Security

- Spring Security Architecture
- Servlet Filters
- DelegatingFilterProxy
- FilterChainProxy
- SecurityFilterChain
- RequestMatcher
- HttpSecurity
- Authentication Filters
- UsernamePasswordAuthenticationFilter
- BasicAuthenticationFilter
- Authentication
- Authorization
- Authentication Object
- UsernamePasswordAuthenticationToken
- AuthenticationManager
- ProviderManager
- AuthenticationProvider
- DaoAuthenticationProvider
- UserDetails
- UserDetailsService
- CustomUserDetails
- CustomUserDetailsService
- SecurityContext
- SecurityContextHolder
- Roles
- Authorities
- GrantedAuthority
- Form Login
- HTTP Basic Authentication
- CSRF
- PasswordEncoder
- BCryptPasswordEncoder
- Password Hashing
- Database Authentication

## Spring Data JPA

- JpaRepository
- Derived Query Methods
- UserRepository
- RoleRepository
- EntityGraph
- `@EntityGraph`
- Many-to-Many Mapping
- Join Table

---

# Learning Outcomes

After completing this project, you will understand:

- ✅ How Spring Security works before the controller
- ✅ Servlet Filter based security
- ✅ DelegatingFilterProxy
- ✅ FilterChainProxy
- ✅ SecurityFilterChain
- ✅ HttpSecurity
- ✅ Authentication filters
- ✅ UsernamePasswordAuthenticationToken
- ✅ AuthenticationManager
- ✅ ProviderManager
- ✅ AuthenticationProvider
- ✅ DaoAuthenticationProvider
- ✅ UserDetails
- ✅ UserDetailsService
- ✅ CustomUserDetails
- ✅ CustomUserDetailsService
- ✅ Database-backed authentication
- ✅ BCrypt password verification
- ✅ SecurityContext
- ✅ SecurityContextHolder
- ✅ Roles and authorities
- ✅ Form Login
- ✅ HTTP Basic Authentication
- ✅ EntityGraph
- ✅ User-Role Many-to-Many Mapping
- ✅ Registration vs Login flow
- ✅ Authentication success and failure

---

# Learning Objective

The objective of this project is to understand the **complete internal flow of database-backed authentication in Spring Security**, from receiving credentials through security filters to creating an authenticated `Authentication` object, loading users from the database, verifying passwords with BCrypt, storing authentication in the `SecurityContext`, and finally performing authorization before the request reaches the controller.
