# Interceptor Demo

A Spring Boot project demonstrating the implementation of **Spring MVC Interceptors** for authentication, authorization, request logging, and request lifecycle handling.

## 📖 Overview

This project explores how Spring MVC Interceptors can intercept HTTP requests before and after controller execution. It demonstrates request authentication, authorization, logging, execution order, and URL pattern configuration using custom interceptors.

---

## ✨ Features

- Custom Authentication Interceptor
- Custom Authorization Interceptor
- Custom Logging Interceptor
- Request Authentication
- Request Authorization
- Request & Response Logging
- Request Processing Time Measurement
- Interceptor Ordering
- URL Pattern Mapping
- Include & Exclude Path Configuration
- REST API using Spring Boot

---

## 🛠️ Technologies Used

- Java
- Spring Boot
- Spring MVC
- Maven

---

## 📂 Project Structure

```
src
├── config
│   └── WebConfig
├── controller
│   └── StudentController
├── interceptor
│   ├── AuthenticationInterceptor
│   ├── AuthorizationInterceptor
│   └── LoggingInterceptor
```

---

## 🔄 Interceptor Execution Flow

```
Client Request
      │
      ▼
Authentication Interceptor
      │
      ▼
Authorization Interceptor
      │
      ▼
Logging Interceptor (preHandle)
      │
      ▼
Student Controller
      │
      ▼
Logging Interceptor (postHandle)
      │
      ▼
Logging Interceptor (afterCompletion)
      │
      ▼
Client Response
```

---

## 🔐 Authentication

The protected API expects the following request headers:

| Header | Value |
|---------|-------|
| api-key | api123 |
| role | ADMIN |

If the token or role is missing or invalid, the request is rejected before reaching the controller.

---

## 📌 API Endpoint

### Create Student

**POST**

```
/api/students
```

### Request Body

```json
{
    "name": "Vinay",
    "age": 20
}
```

### Required Headers

```
api-key: api123
role: ADMIN
```

---

## 📚 Concepts Practiced

- Spring MVC Interceptors
- `HandlerInterceptor`
- `preHandle()`
- `postHandle()`
- `afterCompletion()`
- Authentication
- Authorization
- Request Logging
- Execution Order
- URL Pattern Mapping
- Include & Exclude Paths
- REST API Development
- Dependency Injection

---

## 🎯 Learning Outcome

This project helped me understand:

- How Spring MVC Interceptors work.
- The interceptor lifecycle (`preHandle`, `postHandle`, and `afterCompletion`).
- How to authenticate and authorize incoming requests.
- How to log request and response information.
- How to configure interceptor execution order.
- How to apply interceptors to selected URL patterns.
- The differences between Servlet Filters and Spring MVC Interceptors.

---

**Author:** Vinay Niranjan
