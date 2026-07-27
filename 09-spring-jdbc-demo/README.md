# Spring JDBC Demo

A Spring Boot project demonstrating **Spring JDBC** using **JdbcTemplate** to perform CRUD (Create, Read, Update, Delete) operations on a MySQL database. This project follows a layered architecture and shows how Spring simplifies database access without writing boilerplate JDBC code.

---

## 📖 Overview

This project demonstrates how to:

- Configure Spring JDBC
- Connect Spring Boot with MySQL
- Perform CRUD operations using `JdbcTemplate`
- Execute parameterized SQL queries
- Map database records to Java objects
- Use `BeanPropertyRowMapper`
- Create a custom `RowMapper`
- Build REST APIs using Spring Boot

---

## ✨ Features

- Spring JDBC
- JdbcTemplate
- CRUD Operations
- MySQL Integration
- BeanPropertyRowMapper
- Custom RowMapper
- REST API
- Layered Architecture
- Constructor Dependency Injection
- Parameterized SQL Queries

---

## 🛠️ Technologies Used

- Java
- Spring Boot
- Spring JDBC
- JdbcTemplate
- MySQL
- Spring MVC
- Maven

---

## 📂 Project Structure

```text
src
├── main
│   ├── java
│   │   └── com.vinay7.springjdbcdemo
│   │       ├── controller
│   │       │   └── StudentController
│   │       ├── model
│   │       │   └── Student
│   │       ├── repository
│   │       │   ├── StudentRepository
│   │       │   └── StudentRowMapper
│   │       ├── service
│   │       │   └── StudentService
│   │       └── SpringjdbcdemoApplication
│   └── resources
│       └── application.properties
└── README.md
```

---

## 🏗️ Architecture

```
Client
   │
   ▼
StudentController
   │
   ▼
StudentService
   │
   ▼
StudentRepository
   │
   ▼
JdbcTemplate
   │
   ▼
MySQL Database
```

---

## ⚙️ Database Configuration

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/newstudent_db
spring.datasource.username=root
spring.datasource.password=
```

---

## 🗄️ Database Schema

```sql
CREATE TABLE students (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    age INT
)
```

---

## 📌 API Endpoints

### Create Student

**POST**

```
/api/students
```

Request Body

```json
{
    "name": "Vinay",
    "email": "vinay@gmail.com",
    "age": 20
}
```

Response

```
DONE
```

---

### Get All Students

**GET**

```
/api/students
```

Response

```json
[
    {
        "id":1,
        "name":"Vinay",
        "email":"vinay@gmail.com",
        "age":20
    }
]
```

---

### Get Student By ID

**GET**

```
/api/students/{id}
```

Example

```
/api/students/1
```

---

### Update Student

**PUT**

```
/api/students
```

Request Body

```json
{
    "id":1,
    "name":"Vinay Niranjan",
    "email":"vinay@gmail.com",
    "age":21
}
```

Response

```
DONE
```

---

### Delete Student

**DELETE**

```
/api/students/{id}
```

Example

```
/api/students/1
```

Response

```
DONE
```

---

## 📚 JdbcTemplate Methods Used

| Method | Purpose |
|---------|---------|
| `update()` | INSERT, UPDATE and DELETE operations |
| `query()` | Retrieve multiple records |
| `queryForObject()` | Retrieve a single record |

---

## 🗺️ Row Mapping

This project demonstrates two approaches for converting database rows into Java objects.

### BeanPropertyRowMapper

Automatically maps database columns to Java object fields.

```java
new BeanPropertyRowMapper<>(Student.class)
```

Used in this project.

---

### Custom RowMapper

A custom implementation is also included.

```java
public class StudentRowMapper implements RowMapper<Student>
```

Useful when custom mapping logic is required.

---

## 📚 SQL Operations

### Insert

```sql
INSERT INTO students(name, email, age)
VALUES (?, ?, ?)
```

### Select All

```sql
SELECT id, name, email, age
FROM students
```

### Select By ID

```sql
SELECT id, name, email, age
FROM students
WHERE id = ?
```

### Update

```sql
UPDATE students
SET name = ?, email = ?, age = ?
WHERE id = ?
```

### Delete

```sql
DELETE FROM students
WHERE id = ?
```

---

## 📚 Concepts Practiced

- Spring JDBC
- JdbcTemplate
- CRUD Operations
- MySQL Integration
- REST API Development
- Repository Pattern
- Layered Architecture
- Dependency Injection
- Constructor Injection
- SQL Queries
- Parameterized Queries
- BeanPropertyRowMapper
- Custom RowMapper
- HTTP Methods
- Request Body
- Path Variables
- ResponseEntity

---

## 🎯 Learning Outcome

This project helped me understand:

- How Spring Boot connects to a MySQL database.
- How `JdbcTemplate` simplifies JDBC programming.
- How to perform CRUD operations using Spring JDBC.
- How parameterized SQL queries prevent SQL injection.
- How `BeanPropertyRowMapper` maps database rows to Java objects.
- When to use a custom `RowMapper`.
- How to structure a Spring Boot application using Controller, Service, and Repository layers.
- How to expose database operations through REST APIs.

---


## ⭐ If You Found This Project Helpful

If this project helped you learn Spring JDBC and `JdbcTemplate`, consider giving the repository a ⭐ on GitHub.

---

**Author:** Vinay Niranjan
