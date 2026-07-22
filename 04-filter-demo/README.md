# Filter Demo

A Spring Boot project demonstrating the implementation of **Servlet Filters** for authentication, logging, request/response processing, and filter registration.

## 📖 Overview

This project explores different ways of implementing and configuring Servlet Filters in Spring Boot. It demonstrates how filters can intercept HTTP requests and responses to perform authentication, logging, request/response modification, and URL-based filtering before and after controller execution.

---

## ✨ Features

- Custom Authentication Filter
- Custom Logging Filter
- Request Body Filter
- Response Header Filter
- Response Body Filter
- Filter Registration using `FilterRegistrationBean`
- `OncePerRequestFilter` Implementation
- Filter Ordering using `@Order`
- URL Pattern Mapping
- Token & API Key Validation
- Request & Response Logging
- Request Processing Time Measurement
- REST API using Spring Boot

---

## 🛠️ Technologies Used

- Java
- Spring Boot
- Spring MVC
- Jakarta Servlet API
- Maven

---

## 📂 Project Structure

```
src
├── config
│   └── FilterConfig
├── controller
│   └── StudentController
├── dto
│   ├── Student
│   └── StudentResponseDto
├── filter
│   ├── AuthenticationFilter
│   ├── LoggingFilter
│   ├── RequestFilter
│   ├── ResponseHeaderFilter
│   ├── ResponseBodyFilter
│   ├── DummyFilter
│   └── SpringDemoFilter
├── service
│   └── StudentService
└── resources
    └── application.properties
```

---

## 🔄 Filter Execution Flow

```
Client Request
      │
      ▼
Authentication Filter
      │
      ▼
Logging Filter
      │
      ▼
Request Filter
      │
      ▼
Controller
      │
      ▼
Response Header Filter
      │
      ▼
Response Body Filter
      │
      ▼
Client Response
```

---

## 🔐 Authentication

The protected API expects the following request headers:

| Header | Value |
|---------|-------|
| token | 123 |
| x-api-key | api123 |

If either header is missing or invalid, the request is rejected with **401 Unauthorized**.

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
token: 123
x-api-key: api123
```

---

## 📚 Concepts Practiced

- Servlet Filters
- Filter Chain
- Filter Ordering
- Authentication
- Request Logging
- Request Body Processing
- Response Header Modification
- Response Body Modification
- Filter Registration using `FilterRegistrationBean`
- URL Pattern Mapping
- `OncePerRequestFilter`
- Request & Response Interception
- REST API Development
- Dependency Injection

---

## 🎯 Learning Outcome

This project helped me understand:

- How Servlet Filters intercept requests before reaching the controller.
- How multiple filters are executed in a chain.
- How to authenticate requests using custom headers.
- How to log request and response details.
- How to read and modify request and response data.
- How to register filters programmatically using `FilterRegistrationBean`.
- The difference between the `Filter` interface and `OncePerRequestFilter`.
- How filter ordering and URL pattern mapping work in Spring Boot.

---

**Author:** Vinay Niranjan
