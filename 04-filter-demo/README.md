# Filter Demo

A Spring Boot project demonstrating the implementation of **Servlet Filters** for request authentication and logging.

## 📖 Overview

This project showcases how Servlet Filters can intercept HTTP requests before they reach the controller. It implements authentication, request logging, and execution time measurement using custom filters.

---

## ✨ Features

- Custom Authentication Filter
- Custom Logging Filter
- Filter Ordering using `@Order`
- Token and API Key Validation
- Request & Response Logging
- Request Processing Time Measurement
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
├── controller
│   └── StudentController
├── dto
│   └── Student
├── service
│   └── StudentService
├── filter
│   ├── AuthenticationFilter
│   └── LoggingFilter
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
Student Controller
      │
      ▼
Response
```

---

## 🔐 Authentication

The API expects the following request headers:

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
/students
```

Example Body

```json
{
    "name": "Vinay",
    "age": 20
}
```

Required Headers

```
token: 123
x-api-key: api123
```

---


## 📚 Concepts Practiced

- Servlet Filters
- Request Interception
- Authentication
- Filter Ordering
- Logging
- REST Controller
- Dependency Injection
- Spring Boot Web

---

## 🎯 Learning Outcome

This project helped me understand how Servlet Filters work in Spring Boot, how multiple filters are chained together, and how they can be used for authentication, logging, and request preprocessing before the request reaches the controller.

---

**Author:** Vinay Niranjan
