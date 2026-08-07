# 17 - Spring Security Basics Demo

A Spring Boot project demonstrating the **fundamentals of Spring Security** using Spring Boot's default security configuration. This project introduces authentication, CSRF protection, HTTP Basic Authentication, and the core security concepts required before implementing advanced security features.

> This project serves as the foundation for learning Spring Security and understanding how requests are authenticated and secured before reaching Spring MVC controllers. The concepts and diagrams are based on the learning notes provided.

---

# Features

- Spring Security Auto Configuration
- HTTP Basic Authentication
- In-Memory User Authentication
- Authentication
- Authorization
- CSRF Protection
- CSRF Token API
- SecurityContext
- SecurityContextHolder
- Stateful Authentication
- Stateless Authentication (Concept)
- Security Filter Chain
- REST APIs

---

# Tech Stack

- Java 21
- Spring Boot
- Spring Security
- Spring MVC
- Maven

---

# Project Structure

```text
src
├── controller
│   └── SecurityTestController
│
├── resources
│   └── application.properties
│
└── SpringSecurityBasicsDemoApplication
```

---

# Database Configuration

No database is used in this project.

---

# application.properties

```properties
spring.application.name=SpringSecurityBasicsDemo

spring.security.user.name=vinay
spring.security.user.password=vinay123
```

---

# Base URL

```
http://localhost:8080
```

---

# Default Credentials

| Username | Password |
|----------|----------|
| vinay | vinay123 |

---

# API Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/api/test` | Test GET API |
| POST | `/api/test` | Test POST API |
| PUT | `/api/test` | Test PUT API |
| DELETE | `/api/test` | Test DELETE API |
| GET | `/api/test/token` | Get CSRF Token |

---

# Sample Requests

## GET Request

```
GET http://localhost:8080/api/test
```

Response

```
getTest Method Executed
```

---

## POST Request

```
POST http://localhost:8080/api/test
```

Response

```
postTest Method Executed
```

---

## PUT Request

```
PUT http://localhost:8080/api/test
```

Response

```
updateTestMethod Executed
```

---

## DELETE Request

```
DELETE http://localhost:8080/api/test
```

Response

```
deleteTest Method Executed
```

---

## Get CSRF Token

```
GET http://localhost:8080/api/test/token
```

Returns the generated CSRF token.

---

# Concepts Covered

## Why Security?

Every request reaching an application may contain malicious intent. Spring Security protects application assets from unauthorized access and common attacks. The notes introduce concepts such as assets, threats, vulnerabilities, attacks, and trust boundaries.

---

## Assets

Assets are resources that need protection.

Examples

- Data Assets
- Operational Assets
- Security Assets
- Infrastructure Assets
- Availability Assets

---

## Threat

Anything capable of exploiting a vulnerability.

---

## Vulnerability

A weakness in an application that can be exploited by an attacker.

---

## Attack

An attempt to exploit a vulnerability to gain unauthorized access.

---

## Trust Boundary

A trust boundary separates different trust levels in an application.

```
Browser

↓

Application

↓

Database
```

---

## Authentication

Authentication verifies the identity of a user.

Spring Security supports multiple authentication factors.

### Something You Know

- Password
- PIN
- Security Answer

### Something You Have

- Smart Card
- Authentication App
- Cryptographic Key

### Something You Are

- Fingerprint
- Face
- Iris

Multi-Factor Authentication (MFA) combines multiple authentication factors.

---

## Authorization

Authorization determines what an authenticated user is allowed to access.

Examples

Roles

- ADMIN
- USER
- MANAGER

Authorities

- COURSE_READ
- USER_DELETE

---

## Authentication Object

Spring Security stores authentication information inside an Authentication object.

It contains

- Principal
- Credentials
- Authorities
- Authentication Status

---

## Principal

Represents the currently authenticated user.

---

## Credentials

Information used to verify identity.

Example

- Username
- Password

---

## Authorities

Fine-grained permissions assigned to a user.

Example

- COURSE_READ
- COURSE_UPDATE

---

## Roles

A collection of related authorities.

Example

- ROLE_USER
- ROLE_ADMIN

---

## SecurityContext

Stores the Authentication object for the current request.

---

## SecurityContextHolder

Provides access to the SecurityContext throughout request processing.

```
SecurityContext context =
SecurityContextHolder.getContext();
```

---

## Stateful Authentication

Authentication is stored in an HTTP Session.

Subsequent requests reuse the session instead of authenticating again.

---

## Stateless Authentication

Every request carries its own authentication information.

Common examples

- JWT
- Bearer Token
- OAuth2 Access Token

---

## HTTP Basic Authentication

This project uses Spring Security's default HTTP Basic Authentication.

The client sends credentials with every request.

```
Authorization: Basic Base64(username:password)
```

---

## CSRF Protection

Spring Security enables CSRF protection by default.

The project exposes a REST endpoint to retrieve the generated CSRF token.

```
GET /api/test/token
```

---

## Security Filter Chain

Every request passes through the Spring Security Filter Chain before reaching the DispatcherServlet and Controller. The notes also explain Spring Security's auto-configuration and the role of `SecurityFilterChain` in request processing.

```
Client

↓

Tomcat

↓

Security Filter Chain

↓

Dispatcher Servlet

↓

Controller
```

---

## Spring Security Auto Configuration

Spring Boot automatically configures

- Spring Security
- Default Login
- Default User
- HTTP Basic Authentication
- Security Filter Chain

---

## InMemoryUserDetailsManager

This project uses Spring Boot's default in-memory user configuration through properties.

```
spring.security.user.name=vinay
spring.security.user.password=vinay123
```

---

# Project Demonstrates

- Spring Security Basics
- Authentication
- Authorization
- HTTP Basic Authentication
- CSRF Protection
- CSRF Token
- SecurityContext
- SecurityContextHolder
- Authentication Object
- Principal
- Credentials
- Authorities
- Roles
- Security Filter Chain
- Spring Security Auto Configuration
- Stateful Authentication
- Stateless Authentication (Concept)
- In-Memory User Authentication

---

# Learning Outcomes

After completing this project, you will understand:

- ✅ Spring Security Fundamentals
- ✅ Authentication
- ✅ Authorization
- ✅ HTTP Basic Authentication
- ✅ CSRF Protection
- ✅ CSRF Tokens
- ✅ SecurityContext
- ✅ SecurityContextHolder
- ✅ Authentication Object
- ✅ Principal
- ✅ Credentials
- ✅ Authorities
- ✅ Roles
- ✅ Security Filter Chain
- ✅ Stateful Authentication
- ✅ Stateless Authentication
- ✅ Spring Security Auto Configuration
- ✅ In-Memory User Authentication

---

# Learning Objective

The objective of this project is to understand the core concepts of Spring Security, how authentication and authorization work, how requests flow through the Security Filter Chain, and how Spring Boot secures REST APIs using its default security configuration before implementing advanced security features.
