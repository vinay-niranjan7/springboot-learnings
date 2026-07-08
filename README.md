# Spring Boot CRUD API

A RESTful CRUD API built using **Java**, **Spring Boot**, **Spring Data JPA**, **Hibernate**, and **MySQL**. This project demonstrates best practices for building REST APIs, including DTOs, request validation, global exception handling, and soft delete functionality.

---

## 🚀 Features

- ✅ Create Student
- ✅ Get Student by ID
- ✅ Get All Students
- ✅ Update Student
- ✅ Delete Student (Permanent)
- ✅ Soft Delete Student
- ✅ DTO-based Request & Response
- ✅ Bean Validation (`@Valid`)
- ✅ Global Exception Handling (`@RestControllerAdvice`)
- ✅ Custom Exception Handling
- ✅ Duplicate Resource Validation
- ✅ Resource Not Found Handling
- ✅ Validation Error Response
- ✅ Layered Architecture
- ✅ MySQL Database Integration

---

## 🛠 Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Jakarta Validation
- Postman
- IntelliJ IDEA
- Git & GitHub

---

## 📂 Project Structure

```text
src
├── main
│   ├── java
│   │   └── com.vinay.CRUD
│   │       ├── controller
│   │       ├── dto
│   │       ├── entity
│   │       ├── exception
│   │       ├── repository
│   │       ├── service
│   │       └── CrudApplication.java
│   └── resources
│       └── application.properties
```

---

## 📌 API Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/api/students` | Create Student |
| GET | `/api/students/{id}` | Get Student by ID |
| GET | `/api/students` | Get All Students |
| PUT | `/api/students?id={id}` | Update Student |
| DELETE | `/api/students?id={id}` | Delete Student |
| PATCH | `/api/students/soft-delete?id={id}` | Soft Delete Student |

---

## 📥 Sample Create Request

```json
{
  "name": "Vinay",
  "age": 19,
  "email": "vinayniranjan7@gmail.com",
  "roll": 101,
  "subject": "Computer Science"
}
```

---

## 🌐 Base URL

```
http://localhost:8081
```

Example:

```
POST http://localhost:8081/api/students
```

---

## 📌 Highlights

- Layered Architecture
- DTO Pattern
- Request Validation
- Global Exception Handling
- Clean REST API Design
- Soft Delete Implementation
- Custom Error Responses

---

## 👨‍💻 Author

**Vinay Niranjan**

GitHub: https://github.com/vinay-niranjan7
