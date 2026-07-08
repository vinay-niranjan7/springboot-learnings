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

| Method | Endpoint | Path Variable | Request Parameter | Request Body | Description |
|---------|----------|---------------|-------------------|--------------|-------------|
| POST | `/api/students` | — | — | `CreateStudentRequestDto` | Create a new student |
| GET | `/api/students/{id}` | `id` | — | — | Get a student by ID |
| GET | `/api/students` | — | — | — | Get all students |
| PUT | `/api/students?id={id}` | — | `id` | `UpdateStudentRequestDto` | Update an existing student |
| DELETE | `/api/students?id={id}` | — | `id` | — | Permanently delete a student |
| PATCH | `/api/students/soft-delete?id={id}` | — | `id` | — | Soft delete a student |

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
http://localhost:8081/api/students
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
