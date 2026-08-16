# 18 - Spring Security Database Authentication & JWT Demo

A Spring Boot project demonstrating **database-backed authentication and JWT-based stateless authentication** using Spring Security.

---

# Features

- User Registration
- Database Authentication
- BCrypt Password Hashing
- Custom `UserDetails`
- Custom `UserDetailsService`
- `DaoAuthenticationProvider`
- `AuthenticationManager`
- `ProviderManager`
- `SecurityFilterChain`
- HTTP Basic Authentication
- JWT Authentication
- JWT Generation & Validation
- JWT Bearer Token Authentication
- `JwtEncoder` & `JwtDecoder`
- JWT Claims
- HS256 Signing
- Roles & Authorities
- User-Role Many-to-Many Mapping
- `EntityGraph`
- Stateless Authentication
- CSRF Configuration

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
- OAuth2 Resource Server

---

# Project Structure

```text
src
├── config
│   └── SecurityConfig
│
├── controller
│   ├── AuthController
│   ├── RoleController
│   └── UserController
│
├── dto
│   ├── LoginRequestDto
│   ├── LoginResponseDto
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
│   ├── jwtService
│   └── RoleService
│
└── SpringSecurityDemoApplication
```

---

### JWT Configuration

- `jwt.secret` → Secret key used for signing and validation
- `jwt.issuer` → JWT issuer
- `jwt.expiry` → Token expiry in seconds

---

# Base URL

```text
http://localhost:8081
```

---

# API Endpoints

| Method | Endpoint | Authentication | Description |
|--------|----------|----------------|-------------|
| POST | `/api/roles` | Required | Create role |
| POST | `/api/users/register` | Not Required | Register user |
| POST | `/auth/login` | Not Required | Login & generate JWT |
| GET | `/api/users/hello` | Required | Test protected API |

---

# API Requests

## Create Role

### POST

```text
http://localhost:8081/api/roles
```

### Body

```json
{
  "name": "ROLE_USER"
}
```

---

## Register User

### POST

```text
http://localhost:8081/api/users/register
```

### Body

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

Password flow:

```text
Raw Password
     ↓
BCryptPasswordEncoder
     ↓
Encoded Password
     ↓
MySQL
```

---

## Login

### POST

```text
http://localhost:8081/auth/login
```

### Body

```json
{
  "username": "vinay",
  "password": "vinay12345"
}
```

### Response

```json
{
  "accessToken": "eyJhbGciOiJIUzI1NiJ9..."
}
```

---

## Access Protected API

### GET

```text
http://localhost:8081/api/users/hello
```

### Header

```text
Authorization: Bearer <access-token>
```

### Response

```text
Hello
```

---

# Authentication Flow

```text
Username + Password
        ↓
UsernamePasswordAuthenticationToken
        ↓
AuthenticationManager
        ↓
ProviderManager
        ↓
DaoAuthenticationProvider
        ↓
CustomUserDetailsService
        ↓
UserRepository
        ↓
MySQL
        ↓
Password Verification
        ↓
Authenticated User
        ↓
JWT Generation
        ↓
JwtEncoder
        ↓
JWT
```

---

# JWT Validation Flow

```text
Bearer Token
     ↓
SecurityFilterChain
     ↓
OAuth2 Resource Server
     ↓
JwtDecoder
     ↓
JWT Validation
     ↓
JwtAuthenticationConverter
     ↓
Authorities
     ↓
SecurityContext
     ↓
Authorization
     ↓
Controller
```

---

# JWT

The project uses **HS256** signing.

JWT structure:

```text
Header.Payload.Signature
```

Important claims:

| Claim | Purpose |
|-------|---------|
| `iss` | Issuer |
| `iat` | Issued time |
| `exp` | Expiration |
| `sub` | Username |
| `authorities` | User authorities |

Example:

```json
{
  "iss": "vinay7-api",
  "sub": "vinay",
  "authorities": [
    "ROLE_USER"
  ]
}
```

---

# Stateless Authentication

The project uses:

```java
SessionCreationPolicy.STATELESS
```

Authentication is maintained through the JWT instead of an HTTP session.

```text
Login
  ↓
JWT Generated
  ↓
Client Stores JWT
  ↓
Bearer Token
  ↓
JWT Validation
  ↓
Authenticated Request
```

---

# Spring Security Concepts

- Spring Security Architecture
- Servlet Filters
- `DelegatingFilterProxy`
- `FilterChainProxy`
- `SecurityFilterChain`
- `HttpSecurity`
- Authentication
- Authorization
- `UsernamePasswordAuthenticationToken`
- `AuthenticationManager`
- `ProviderManager`
- `DaoAuthenticationProvider`
- `UserDetails`
- `UserDetailsService`
- `CustomUserDetails`
- `CustomUserDetailsService`
- `SecurityContext`
- `SecurityContextHolder`
- Roles
- Authorities
- `GrantedAuthority`
- HTTP Basic Authentication
- Form Login
- CSRF
- `PasswordEncoder`
- `BCryptPasswordEncoder`
- Database Authentication
- Stateless Authentication

---

# JWT Concepts

- JWT Structure
- Header
- Payload
- Signature
- Claims
- Issuer
- Subject
- Expiration
- HS256
- JWT Secret Key
- JWT Generation
- JWT Validation
- `JwtEncoder`
- `JwtDecoder`
- `JwtClaimsSet`
- `JwtAuthenticationConverter`
- `JwtGrantedAuthoritiesConverter`
- Bearer Token Authentication
- OAuth2 Resource Server

---

# Spring Data JPA

- `JpaRepository`
- Derived Query Methods
- User Repository
- Role Repository
- `EntityGraph`
- Many-to-Many Mapping
- Join Table

---

# Learning Objective

This project demonstrates the complete flow of **database authentication → JWT generation → stateless JWT validation → authorization** using Spring Security.
