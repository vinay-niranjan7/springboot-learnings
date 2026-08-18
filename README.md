# 🌱 Spring Boot Learnings

A collection of hands-on Spring Boot microprojects created while learning various Spring Boot concepts. Each project focuses on a specific topic and demonstrates its practical implementation through REST APIs and real-world examples.

---

# 📚 Micro Projects

| No. | Project | Topics Covered | Status |
|-----|---------|----------------|--------|
| 01 | Servlet User CRUD | Java Servlets, JSP, JDBC CRUD Operations | ✅ |
| 02 | CRUD REST API | Spring Boot REST APIs, CRUD Operations | ✅ |
| 03 | Profile Demo | Spring Profiles | ✅ |
| 04 | Filter Demo | Servlet Filters, Authentication, Logging, Filter Ordering | ✅ |
| 05 | Interceptor Demo | Spring MVC Interceptors, Authentication, Authorization, Logging | ✅ |
| 06 | AOP Basic | Spring AOP, Advice Types, Pointcuts | ✅ |
| 07 | AOP Demo | Logging Aspect, Around Advice, Method Arguments & Return Values | ✅ |
| 08 | AOP Custom Annotation | Custom Annotation, Custom Pointcuts, Logging Aspect | ✅ |
| 09 | Spring JDBC Demo | JdbcTemplate, CRUD Operations, RowMapper, SQL Queries | ✅ |
| 10 | Hibernate JPA Demo | Hibernate ORM, Spring Data JPA, Entity Mapping, Embedded Objects, Collections, Transactions | ✅ |
| 11 | Hibernate Internals Demo | Persistence Context, Entity Lifecycle, EntityManager, EntityManagerFactory, First-Level Cache, Dirty Checking, Flush vs Commit, Transactions | ✅ |
| 12 | JPA Relations Demo | One-to-One, One-to-Many, Many-to-One, Many-to-Many, Bidirectional Relationships, Cascade Operations | ✅ |
| 13 | JPA Cascading & Lazy Loading Demo | JPA Cascading, CascadeType, Lazy Loading, FetchType.LAZY, N+1 Problem, EntityGraph | ✅ |
| 14 | Spring Data JPA Demo | Repository Hierarchy, JpaRepository, CRUD Operations, Derived Query Methods, Native Queries, JPQL, Pagination, Sorting | ✅ |
| 15 | Transaction Intro Demo | Database Transactions, ACID Properties, @Transactional, Transaction Boundary, Commit, Rollback, JDBC, JPA & Hibernate Transactions | ✅ |
| 16 | Transaction Propagation & Isolation Demo | Transaction Propagation, Isolation Levels, Concurrency Problems, @Transactional, Propagation, Rollback Rules | ✅ |
| 17 | Spring Security Basics Demo | Spring Security, Authentication, Authorization, HTTP Basic Authentication, CSRF Protection, Security Filter Chain, SecurityContext | ✅ |
| 18 | Spring Security Database Authentication & JWT Demo | Database Authentication, User Registration, User Login, BCrypt, UserDetails, UserDetailsService, AuthenticationManager, DaoAuthenticationProvider, SecurityFilterChain, JWT, JWT Generation & Validation, Stateless Authentication, Roles, Authorities | ✅ |
| 19 | OAuth 2.0, OpenID Connect & Google Login Demo | OAuth 2.0, OpenID Connect, Google Login, Authorization Code Flow, OAuth2 Client, OIDC, Access Token, ID Token, Scopes, Consent, OIDC User Service, Session-Based Authentication | ✅ |

---

# 🛠️ Tech Stack

### Backend

- Java 25
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate ORM
- Spring JDBC
- Spring AOP

### Database

- MySQL

### Build Tool

- Maven

### APIs & Testing

- REST APIs
- Postman

### Java EE

- Java Servlets
- JSP

---

# 📖 Concepts Covered

## Spring Boot

- REST APIs
- Dependency Injection
- Bean Management
- Configuration
- Profiles

## Spring MVC

- Controllers
- Request Mapping
- Path Variables
- Request Parameters
- Request Body
- ResponseEntity

## Servlet

- Servlet API
- Filters
- Authentication Filter
- Logging Filter

## Spring AOP

- Aspect
- Pointcuts
- Before Advice
- After Advice
- Around Advice
- Custom Annotation
- Logging

## Spring JDBC

- JdbcTemplate
- CRUD Operations
- BeanPropertyRowMapper
- Custom RowMapper
- SQL Queries

## Hibernate & JPA

- Entity Mapping
- Table Mapping
- Primary Keys
- Column Mapping
- Embedded Objects
- Collections
- Enum Mapping
- LOB Mapping
- Attribute Converter
- Transient Fields
- Dirty Checking
- Persistence Context
- EntityManager
- EntityManagerFactory
- Session
- SessionFactory
- Entity Lifecycle
- First-Level Cache
- Flush vs Commit
- Transactions
- One-to-One Mapping
- One-to-Many Mapping
- Many-to-One Mapping
- Many-to-Many Mapping
- Bidirectional Relationships
- Cascade Operations
- Lazy Loading
- Eager vs Lazy Fetching
- N+1 Query Problem
- EntityGraph
- Spring Data JPA
- Repository Hierarchy
- CRUD Operations
- Derived Query Methods
- JPQL
- Native SQL Queries
- Pagination
- Sorting
- Database Transactions
- ACID Properties
- @Transactional
- Transaction Propagation
- Isolation Levels
- Dirty Read
- Non-Repeatable Read
- Phantom Read

## Spring Security

- Authentication
- Authorization
- Authentication Object
- Principal
- Credentials
- Authorities
- Roles
- GrantedAuthority
- HTTP Basic Authentication
- Form Login
- In-Memory User Authentication
- Database Authentication
- User Registration
- User Login
- UserDetails
- CustomUserDetails
- UserDetailsService
- CustomUserDetailsService
- AuthenticationManager
- ProviderManager
- AuthenticationProvider
- DaoAuthenticationProvider
- UsernamePasswordAuthenticationToken
- SecurityContext
- SecurityContextHolder
- Security Filter Chain
- SecurityFilterChain
- FilterChainProxy
- DelegatingFilterProxy
- RequestMatcher
- HttpSecurity
- Authentication Filters
- UsernamePasswordAuthenticationFilter
- BasicAuthenticationFilter
- CSRF Protection
- CSRF Token
- Stateful Authentication
- Stateless Authentication
- Spring Security Auto Configuration
- Password Security
- Password Hashing
- BCrypt
- PasswordEncoder
- Password Verification
- User-Role Mapping
- Many-to-Many User-Role Mapping
- EntityGraph
- Authentication Success & Failure

## JWT

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
- JwtEncoder
- JwtDecoder
- JwtClaimsSet
- JwtAuthenticationConverter
- JwtGrantedAuthoritiesConverter
- Bearer Token Authentication
- OAuth2 Resource Server
- Stateless JWT Authentication

## OAuth 2.0 & OpenID Connect

- OAuth 2.0
- OpenID Connect (OIDC)
- Authentication
- Authorization
- OAuth2 Client
- Google Login
- Authorization Code Flow
- Authorization Code
- Access Token
- ID Token
- Refresh Token
- OAuth Scopes
- Consent
- State Parameter
- PKCE
- OIDC Claims
- OidcUser
- OidcUserService
- Custom OIDC User Service
- Provider + Subject Mapping
- Google Identity Provider
- Redirect URI
- Session-Based Authentication

---

# 📁 Repository Structure

```text
springboot-learnings
│
├── 01-servlet-user-crud
├── 02-crud-rest-api
├── 03-profiledemo
├── 04-filter-demo
├── 05-interceptor-demo
├── 06-aop-basic
├── 07-aop-demo
├── 08-aop-custom-annotation
├── 09-spring-jdbc-demo
├── 10-hibernate-jpa-demo
├── 11-hibernateinternalsdemo
├── 12-jpa-relations-demo
├── 13-jpa-cascading-lazyloading-demo
├── 14-spring-data-jpa-demo
├── 15-transaction-intro-demo
├── 16-transaction-propagation-isolation-demo
├── 17-spring-security-basics-demo
├── 18-spring-security-database-auth-jwt-demo
└── 19-oauth2-oidc-google-login-demo
```

---

# 🎯 Purpose

This repository documents my Spring Boot learning journey through small, focused projects. Every project introduces a new concept while reinforcing previous topics with practical implementation.

---

# 👨‍💻 Author

**Vinay Niranjan**

B.Tech CSE Student | Java Full Stack Developer

GitHub: https://github.com/vinay-niranjan7

---

⭐ If you found this repository helpful, consider giving it a **Star**.
