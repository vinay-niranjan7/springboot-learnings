# Spring Boot CRUD API

A RESTful CRUD API built using **Java**, **Spring Boot**, **Spring Data JPA**, **Hibernate**, and **MySQL**. This project demonstrates Create, Read, Update, Delete, and Soft Delete operations on a Student entity using a layered architecture with DTOs.

---

## 🚀 Features

- Create a Student
- Get Student by ID
- Get All Students
- Update Student Details
- Delete Student
- Soft Delete Student
- DTO (Data Transfer Object) implementation
- RESTful API using Spring Boot
- MySQL Database Integration
- Layered Architecture (Controller, Service, Repository, DTO)

---

## 🛠 Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Postman
- IntelliJ IDEA

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
| POST | `/create` | Create a new student |
| GET | `/get?id={id}` | Get a student by ID |
| GET | `/getAll` | Get all active students |
| PUT | `/update?id={id}` | Update a student |
| DELETE | `/delete?id={id}` | Delete a student permanently |
| PATCH | `/soft-delete?id={id}` | Soft delete a student |

---

## 📄 Sample Request Body

```json
{
  "name": "Vinay",
  "age": 20,
  "email": "vinay@example.com",
  "roll": 101,
  "subject": "Computer Science"
}
```

---

## 🌐 Base URL

```text
http://localhost:8081/api/students
```

---

## 🛠 Tools Used

- IntelliJ IDEA
- MySQL Workbench
- Postman
- Git
- GitHub

---

## 👨‍💻 Author

**Vinay Niranjan**

GitHub: https://github.com/vinay-niranjan7
