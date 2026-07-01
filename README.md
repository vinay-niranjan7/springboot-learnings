# Spring Boot CRUD API

A simple RESTful CRUD API built using **Java**, **Spring Boot**, **Spring Data JPA**, **Hibernate**, and **MySQL**. This project demonstrates the implementation of Create, Read, Update, Delete, and Soft Delete operations on a Student entity.

---

## 🚀 Features

- Create a Student
- Get Student by ID
- Get All Students
- Update Student Details
- Delete Student
- Soft Delete Student
- RESTful API using Spring Boot
- MySQL Database Integration
- Layered Architecture (Controller, Service, Repository)

---

## 🛠 Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Postman

---

## 📂 Project Structure

```
src
├── main
│   ├── java
│   │   └── com.vinay.CRUD
│   │       ├── controller
│   │       ├── entity
│   │       ├── repository
│   │       ├── service
│   │       └── CrudApplication.java
│   └── resources
│       └── application.properties
```

---


## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/create` | Create a new student |
| GET | `/get?id={id}` | Get a student by ID |
| GET | `/getAll` | Get all students |
| PUT | `/update?id={id}` | Update a student |
| DELETE | `/delete?id={id}` | Delete a student |
| PATCH | `/soft-delete?id={id}` | Soft delete a student |

### Sample Request Body 

```json
{
  "name": "Vinay",
  "age": 20,
  "email": "vinay@example.com",
  "roll": 101,
  "subject": "Computer Science"
}
```

### Base URL

```
http://localhost:8080/api/students
```


# Tools Used

- IntelliJ IDEA
- MySQL Workbench
- Postman

---

# Author

**Vinay Niranjan**

GitHub: https://github.com/vinay-niranjan7
