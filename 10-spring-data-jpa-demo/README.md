# Hibernate JPA Demo

A Spring Boot project demonstrating **Hibernate ORM** and **Spring Data JPA** by implementing CRUD operations on a `Student` entity. This project focuses on entity mapping, embedded objects, collections, converters, enums, transactions, and automatic dirty checking.

---

## Features

- Create Student
- Get Student by ID
- Update Student
- Delete Student
- Hibernate Dirty Checking
- Spring Data JPA Repository
- Transaction Management using `@Transactional`
- Embedded Objects
- Collection Mapping
- Enum Mapping
- LOB Mapping
- Attribute Overrides
- Custom Attribute Converter

---

## Technologies Used

- Java 25
- Spring Boot 4
- Spring Data JPA
- Hibernate ORM
- MySQL
- Maven
- REST API
- Postman

---

## Project Structure

```
src
└── main
    ├── java
    │   └── com.vinay7.hibernatedemo
    │       ├── controller
    │       │   └── StudentController.java
    │       │
    │       ├── model
    │       │   ├── Address.java
    │       │   ├── BooleanToStringConverter.java
    │       │   ├── Student.java
    │       │   └── StudentStatus.java
    │       │
    │       ├── repository
    │       │   └── StudentRepository.java
    │       │
    │       ├── service
    │       │   └── StudentService.java
    │       │
    │       └── HibernatedemoApplication.java
    │
    └── resources
        └── application.properties
```

---

## Entity Mapping Concepts

### Entity

- `@Entity`
- `@Table`

### Primary Key

- `@Id`
- `@GeneratedValue`

### Column Mapping

- `@Column`

### Embedded Object

- `@Embedded`

### Attribute Override

- `@AttributeOverrides`
- `@AttributeOverride`

### Collection Mapping

- `@ElementCollection`
- `@CollectionTable`
- `@JoinColumn`

### Enum Mapping

- `@Enumerated(EnumType.STRING)`

### Large Object

- `@Lob`

### Ignore Database Field

- `@Transient`

### Attribute Converter

- `@Convert`

### Transactions

- `@Transactional`

---

# Database Schema

## Students

| Column | Type |
|----------|------|
| id | BIGINT |
| student_name | VARCHAR(50) |
| student_email | VARCHAR(100) |
| age | INT |
| percentage | DECIMAL |
| date_of_birth | DATE |
| current_address | Embedded |
| permanent_address | Embedded |
| status | ENUM |
| profile_description | TEXT |
| created_at | DATETIME |
| is_monitor | CHAR(1) |

## Student Skills

| Column | Type |
|---------|------|
| student_id | BIGINT |
| skills | VARCHAR |

---

# API Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/api/students` | Create Student |
| GET | `/api/students/{id}` | Get Student |
| PUT | `/api/students/{id}` | Update Student |
| DELETE | `/api/students/{id}` | Delete Student |

---

# POST Request Body

```json
{
  "name": "Vinay Niranjan",
  "email": "vinay@gmail.com",
  "age": 21,
  "skills": [
    "Java",
    "Spring Boot",
    "Hibernate"
  ],
  "currentAddress": {
    "houseNo": "A-101",
    "street": "MG Road",
    "city": "Pune",
    "state": "Maharashtra",
    "pincode": "411001"
  },
  "permanentAddress": {
    "houseNo": "12",
    "street": "Shivaji Nagar",
    "city": "Nashik",
    "state": "Maharashtra",
    "pincode": "422001"
  },
  "percentage": 87.45,
  "dateOfBirth": "2006-05-18",
  "status": "ACTIVE",
  "profileDescription": "Spring Boot and Hibernate learner.",
  "monitor": true,
  "createdAt": "2026-07-28T10:30:00"
}
```

---

# PUT Request Body

```json
{
  "name": "Vinay Niranjan",
  "email": "vinay@gmail.com",
  "age": 21,
  "percentage": 87.5,
  "dateOfBirth": "2004-08-15",
  "status": "ACTIVE",
  "currentAddress": {
    "street": "MG Road",
    "city": "Pune",
    "state": "Maharashtra",
    "pincode": "411001"
  },
  "permanentAddress": {
    "street": "Shivaji Nagar",
    "city": "Nashik",
    "state": "Maharashtra",
    "pincode": "422001"
  },
  "skills": [
    "Java",
    "Spring Boot",
    "Hibernate",
    "MySQL"
  ],
  "profileDescription": "Java Full Stack Developer and Spring Boot enthusiast."
}
```

---

# Hibernate Concepts Practiced

- Hibernate ORM
- Entity Mapping
- Primary Keys
- Column Mapping
- Embedded Objects
- Attribute Overrides
- Element Collections
- Enum Mapping
- LOB Mapping
- Transient Fields
- Attribute Converters
- Dirty Checking
- Transaction Management
- CRUD Operations
- Repository Pattern

---

# Learning Outcomes

After completing this project, you will understand:

- Spring Data JPA
- Hibernate ORM Basics
- Entity Relationships using Embedded Objects
- Collection Mapping
- Enum Persistence
- Custom Attribute Converters
- Automatic Update using Dirty Checking
- Transaction Management
- CRUD APIs using JPA Repository

---

## Author

**Vinay Niranjan**

GitHub: https://github.com/vinay-niranjan7
