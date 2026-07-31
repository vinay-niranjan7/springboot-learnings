# 12 - JPA Relations Demo

A Spring Boot project demonstrating the implementation of **JPA/Hibernate Entity Relationships** using Spring Data JPA. This project covers **One-to-One**, **One-to-Many**, **Many-to-One**, and **Many-to-Many** relationships with practical REST APIs.

> This project helps understand how entities are associated in relational databases using JPA annotations, Hibernate ORM, and Spring Data JPA.

---

# Features

- One-to-One Mapping
- One-to-Many Mapping
- Many-to-One Mapping
- Many-to-Many Mapping
- Bidirectional Relationships
- Cascade Operations
- Spring Data JPA
- Hibernate ORM
- REST APIs
- MySQL Database

---

# Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate ORM
- MySQL
- Maven

---

# Project Structure

```text
src
├── controller
│   ├── UserController
│   ├── ProfileController
│   ├── DepartmentController
│   ├── StudentController
│   └── CourseController
│
├── model
│   ├── User
│   ├── Profile
│   ├── Department
│   ├── Student
│   └── Course
│
├── repository
├── service
└── JpaRelationsDemoApplication
```

---

# Base URL

```
http://localhost:8081
```

---

# API Endpoints

## User APIs (One-to-One)

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/api/users` | Create User |
| POST | `/api/users/test?profileId={id}` | Create User with Existing Profile |
| GET | `/api/users/{id}` | Get User by ID |

---

## Profile APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/api/profiles?userId={id}` | Create Profile for User |

---

## Department APIs (One-to-Many)

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/api/department` | Create Department |
| POST | `/api/department/withStudent?studentName={name}` | Create Department with Student |

---

## Student APIs (Many-to-One)

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/api/students?deptId={id}` | Create Student in Existing Department |
| POST | `/api/students/withdept?deptName={name}` | Create Student with New Department |

---

## Course APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/api/courses` | Create Course |

---

## Student-Course APIs (Many-to-Many)

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/api/students2` | Create Student |
| POST | `/api/students2/{studentId}/enroll?courseIds=1&courseIds=2` | Enroll Student in Courses |

---

# Sample Requests

## Create User

**POST**

```
http://localhost:8081/api/users
```

### Request Body

```json
{
  "name": "Vinay"
}
```

---

## Create User with Existing Profile

**POST**

```
http://localhost:8081/api/users/test?profileId=1
```

### Request Body

```json
{
  "name": "Vinay"
}
```

---

## Get User

**GET**

```
http://localhost:8081/api/users/1
```

---

## Create Profile

**POST**

```
http://localhost:8081/api/profiles?userId=1
```

### Request Body

```json
{
  "bio": "Java Full Stack Developer"
}
```

---

## Create Department

**POST**

```
http://localhost:8081/api/department
```

### Request Body

```json
{
  "name": "Computer Science"
}
```

---

## Create Department with Student

**POST**

```
http://localhost:8081/api/department/withStudent?studentName=Vinay
```

### Request Body

```json
{
  "name": "Computer Science"
}
```

---

## Create Student (Existing Department)

**POST**

```
http://localhost:8081/api/students?deptId=1
```

### Request Body

```json
{
  "name": "Vinay"
}
```

---

## Create Student with New Department

**POST**

```
http://localhost:8081/api/students/withdept?deptName=Computer%20Science
```

### Request Body

```json
{
  "name": "Vinay"
}
```

---

## Create Course

**POST**

```
http://localhost:8081/api/courses
```

### Request Body

```json
{
  "name": "Java"
}
```

---

## Create Student (Many-to-Many)

**POST**

```
http://localhost:8081/api/students2
```

### Request Body

```json
{
  "name": "Vinay"
}
```

---

## Enroll Student in Courses

**POST**

```
http://localhost:8081/api/students2/1/enroll?courseIds=1&courseIds=2
```

**Request Body**

No request body required.

---

# JPA Relationships

## One-to-One

```
User
 │
 ▼
Profile
```

**Annotations**

- `@OneToOne`
- `@JoinColumn`

---

## One-to-Many

```
Department
     │
     ├── Student
     ├── Student
     └── Student
```

**Annotations**

- `@OneToMany`
- `mappedBy`
- `CascadeType`

---

## Many-to-One

```
Student
    │
    ▼
Department
```

**Annotations**

- `@ManyToOne`
- `@JoinColumn`

---

## Many-to-Many

```
Student  ←────→  Course
```

A join table is created automatically.

**Annotations**

- `@ManyToMany`
- `@JoinTable`
- `@JoinColumn`
- `inverseJoinColumns`

---

# Concepts Covered

- One-to-One Mapping
- One-to-Many Mapping
- Many-to-One Mapping
- Many-toMany Mapping
- Bidirectional Relationships
- Cascade Operations
- Join Tables
- Foreign Keys
- Spring Data JPA
- Hibernate ORM
- REST APIs

---

# Learning Outcomes

After completing this project, you will understand:

- ✅ One-to-One Mapping
- ✅ One-to-Many Mapping
- ✅ Many-to-One Mapping
- ✅ Many-to-Many Mapping
- ✅ Bidirectional Relationships
- ✅ Cascade Operations
- ✅ Join Tables
- ✅ Foreign Key Relationships
- ✅ Spring Data JPA
- ✅ Hibernate ORM

---

# Learning Objective

The objective of this project is to understand how different entity relationships are implemented in JPA/Hibernate and how Spring Data JPA manages associations between entities in real-world applications.
