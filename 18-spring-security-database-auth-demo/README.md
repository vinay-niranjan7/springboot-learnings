# 18 - Spring Security Database Authentication Demo

A Spring Boot project demonstrating **database-backed authentication and password security** using Spring Security, Spring Data JPA, MySQL, and BCrypt.

This project covers user registration, login, database authentication, password hashing, roles, `UserDetails`, `UserDetailsService`, and CSRF protection.

---

# Features

- User Registration
- User Login
- Database Authentication
- MySQL User Storage
- BCrypt Password Hashing
- Password Verification
- `UserDetails`
- `UserDetailsService`
- User and Role Entities
- Many-to-Many User-Role Mapping
- CSRF Protection
- CSRF Token
- Spring Security
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
├── controller
│   └── UserController
│
├── dto
│   ├── UserRegisterRequestDto
│   └── UserRegisterResponseDto
│
├── entity
│   ├── User
│   └── Role
│
├── repository
│   ├── UserRepository
│   └── RoleRepository
│
├── service
│   └── AuthService
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
| POST | `/api/users/login` | Login user |
| GET | `/api/users/token` | Get CSRF Token |

---

# API Requests

## 1. Test API

### GET

```text
http://localhost:8081/api/users/hello
```

### Response

```text
Hello
```

---

# 2. Get CSRF Token

Before sending the registration and login requests, first obtain the CSRF token.

### GET

```text
http://localhost:8081/api/users/token
```

### Response

```json
{
  "token": "generated-csrf-token",
  "parameterName": "_csrf",
  "headerName": "X-CSRF-TOKEN"
}
```

Use the returned token in the request header:

```text
X-CSRF-TOKEN: generated-csrf-token
```

---

# 3. Register User

### POST

```text
http://localhost:8081/api/users/register
```

### Headers

```text
Content-Type: application/json
X-CSRF-TOKEN: <csrf-token>
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

The password is encoded using BCrypt before being stored in the database.

```text
Raw Password
     ↓
PasswordEncoder
     ↓
BCrypt
     ↓
Encoded Password
     ↓
MySQL Database
```

---

# 4. Login User

### POST

```text
http://localhost:8081/api/users/login
```

### Headers

```text
Content-Type: application/json
X-CSRF-TOKEN: <csrf-token>
```

### Request Body

```json
{
  "username": "vinay",
  "password": "vinay12345"
}
```

### Successful Response

```json
true
```

### Incorrect Password

```json
false
```

The login process verifies the submitted password against the stored BCrypt password.

```text
Entered Password
       +
Stored BCrypt Password
       ↓
PasswordEncoder.matches()
       ↓
true / false
```

---

# Password Security

## Raw Passwords

Raw passwords should never be stored directly in the database.

```text
vinay12345
```

Instead:

```text
vinay12345
     ↓
BCrypt
     ↓
$2a$10$...
```

Only the encoded password is stored.

---

# BCrypt Password Hashing

The project uses `BCryptPasswordEncoder`.

### Registration

```java
passwordEncoder.encode(password)
```

### Login

```java
passwordEncoder.matches(
    rawPassword,
    encodedPassword
)
```

The original password is never recovered from the stored BCrypt value.

---

# Hashing vs Encryption

## Encryption

```text
Plaintext
   ↓
Encryption + Key
   ↓
Ciphertext
   ↓
Decryption + Key
   ↓
Plaintext
```

Encryption is reversible.

## Password Hashing

```text
Password
   ↓
One-Way Hashing
   ↓
Encoded Representation
```

Password hashing is used because the application does not need to recover the original password.

---

# Authentication

Authentication answers:

```text
Who are you?
```

For username/password authentication:

```text
Username → Identity
Password → Credential
```

The application retrieves trusted user information from the database and verifies the submitted credentials.

---

# Authorization

Authorization answers:

```text
What are you allowed to do?
```

Example roles:

```text
ROLE_USER
ROLE_ADMIN
```

Authentication establishes identity, while authorization determines what an authenticated user can access.

---

# UserDetails

`UserDetails` represents the user information required by Spring Security for username/password authentication.

It contains information related to:

- Username
- Password
- Authorities
- Account Status

The application `User` entity and Spring Security `UserDetails` are separate concepts.

```text
Application User Entity
          ↓
       Adapter
          ↓
Spring Security UserDetails
```

---

# UserDetailsService

`UserDetailsService` acts as the bridge between Spring Security and the application's repository layer.

```text
Spring Security
       ↓
UserDetailsService
       ↓
UserRepository
       ↓
MySQL Database
```

The repository retrieves the user using the login identifier.

```java
Optional<User> findByUsername(String username);
```

---

# CSRF Protection

Spring Security provides CSRF protection for state-changing requests.

This project exposes:

```text
GET /api/users/token
```

to obtain the CSRF token.

The token must be supplied when making POST requests such as:

```text
POST /api/users/register
POST /api/users/login
```

using:

```text
X-CSRF-TOKEN
```

---

# Registration Flow

```text
Client
   ↓
POST /api/users/register
   ↓
UserRegisterRequestDto
   ↓
AuthService
   ↓
Check Username
   ↓
PasswordEncoder
   ↓
BCrypt
   ↓
User Entity
   ↓
UserRepository
   ↓
MySQL Database
```

The raw password is encoded before being saved.

---

# Login Flow

```text
Client
   ↓
POST /api/users/login
   ↓
UserRegisterRequestDto
   ↓
AuthService
   ↓
UserRepository
   ↓
Find User by Username
   ↓
Stored BCrypt Password
   ↓
PasswordEncoder.matches()
   ↓
true / false
```

---

# Concepts Covered

- Spring Security
- Database Authentication
- Authentication
- Authorization
- UserDetails
- UserDetailsService
- Authentication Object
- Principal
- Credentials
- Authorities
- Roles
- User Entity
- Role Entity
- User-Role Mapping
- Many-to-Many Mapping
- Repository Layer
- Password Security
- Password Hashing
- BCrypt
- PasswordEncoder
- `encode()`
- `matches()`
- CSRF Protection
- CSRF Token
- Security Filter Chain
- Spring Security Auto Configuration
- MySQL Authentication

---

# Learning Outcomes

After completing this project, you will understand:

- ✅ Database-backed user authentication
- ✅ User registration
- ✅ User login
- ✅ Password hashing with BCrypt
- ✅ Password verification using `matches()`
- ✅ Why raw passwords must never be stored
- ✅ Difference between hashing and encryption
- ✅ UserDetails
- ✅ UserDetailsService
- ✅ Authentication vs Authorization
- ✅ Roles and Authorities
- ✅ User-Role Many-to-Many Mapping
- ✅ CSRF Protection
- ✅ CSRF Token handling
- ✅ Repository-based user lookup
- ✅ Spring Security database authentication

---

# Learning Objective

The objective of this project is to understand how Spring Security works with application-specific users stored in a database, how passwords are securely hashed using BCrypt, how users and roles are modeled, and how CSRF protection is handled for registration and login requests.
