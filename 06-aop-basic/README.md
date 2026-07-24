# AOP Basic

A Spring Boot project demonstrating **Aspect-Oriented Programming (AOP) concepts** using the **Decorator Design Pattern**. This project shows how cross-cutting concerns such as logging and execution time measurement can be added to business logic without modifying the core service implementation.

> **Note:** This project implements AOP concepts manually using the Decorator Pattern. It does **not** use Spring AOP annotations like `@Aspect`, `@Before`, or `@Around`.

---

## 📖 Overview

This project demonstrates how decorators can wrap a service to provide additional functionality such as request logging and execution time calculation while keeping the business logic clean and reusable.

---

## ✨ Features

- Decorator Design Pattern
- Logging Decorator
- Execution Time Decorator
- Service Decoration
- Cross-Cutting Concerns
- Dependency Injection
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
├── repository
│   └── StudentRepository
├── service
│   ├── StudentService
│   ├── StudentServiceImpl
│   ├── LoggingDecorator
│   └── ExecutionTimeService

```

---

## 🔄 Request Flow

```
Client Request
      │
      ▼
StudentController
      │
      ▼
ExecutionTimeService
      │
      ▼
LoggingDecorator
      │
      ▼
StudentServiceImpl
      │
      ▼
StudentRepository
      │
      ▼
Client Response
```

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
    "age": 20,
    "rollNo": 101,
    "message": "Hello Spring Boot"
}
```

### Response

```
DONE
```

---

## 📚 Concepts Practiced

- Aspect-Oriented Programming (AOP) Concepts
- Decorator Design Pattern
- Cross-Cutting Concerns
- Logging
- Execution Time Measurement
- Service Wrapping
- Dependency Injection
- Spring Beans
- REST API Development

---

## 🎯 Learning Outcome

This project helped me understand:

- The purpose of Aspect-Oriented Programming.
- How cross-cutting concerns can be separated from business logic.
- How the Decorator Pattern can implement AOP concepts.
- How multiple decorators can wrap a service.
- How to measure method execution time.
- How to implement logging without modifying the original service.
- The relationship between the Decorator Pattern and Spring AOP.

---


**Author:** Vinay Niranjan
