# 13 - JPA Cascading Demo

A Spring Boot project demonstrating advanced JPA and Hibernate concepts including **JPA Cascading**, **Lazy Loading**, the **N+1 Query Problem**, and optimizing data fetching using **`@EntityGraph`**.

> This project also demonstrates cascade operations by automatically creating related entities in the service layer for learning purposes.

---

# Features

- JPA Cascading
- Cascade Operations
- Lazy Loading
- FetchType.LAZY
- N+1 Query Problem
- EntityGraph
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
│   ├── DepartmentController
│   └── StudentController
│
├── model
│   ├── Department
│   ├── Student
│   └── Profile
│
├── repository
│   ├── DepartmentRepository
│   ├── StudentRepository
│   ├── StudentJPARepository
│   └── ProfileRepository
│
├── service
│   ├── DepartmentService
│   └── StudentService
│
└── JpaCascadingDemoApplication
```

---

# Base URL

```
http://localhost:8081
```

---

# API Endpoints

## Department APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/api/department` | Create Department (adds two dummy students) |
| DELETE | `/api/department/{deptId}` | Delete Department |

---

## Student APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/api/students` | Create Student (adds dummy Department & Profile) |
| GET | `/api/students/{id}` | Get Student By Id (Lazy Loading Demo) |
| GET | `/api/students` | Get All Students (EntityGraph Demo) |

---

# Sample Requests

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

### What happens?

The service automatically creates two students:

- Vinu
- Vinayyyy

Both students are associated with the created department using **Cascade Persist**.

---

## Delete Department

**DELETE**

```
http://localhost:8081/api/department/1
```

---

## Create Student

**POST**

```
http://localhost:8081/api/students
```

### Request Body

```json
{
  "name": "Vinay"
}
```

### What happens?

The service automatically creates:

**Department**

```text
CSE
```

**Profile**

```text
Java Full Stack Dev
```

The created Student is automatically associated with the generated Department and Profile before being saved.

---

## Get Student By Id

**GET**

```
http://localhost:8081/api/students/1
```

### Demonstrates

- Lazy Loading
- FetchType.LAZY
- Transactional Loading

---

## Get All Students

**GET**

```
http://localhost:8081/api/students
```

### Demonstrates

- N+1 Problem Solution
- EntityGraph Fetching

---

# Concepts Covered

## JPA Cascading

Cascade operations automatically propagate persistence operations from parent entities to related child entities.

Cascade Types

- `CascadeType.PERSIST`
- `CascadeType.MERGE`
- `CascadeType.REMOVE`
- `CascadeType.REFRESH`
- `CascadeType.DETACH`
- `CascadeType.ALL`

---

## Lazy Loading

Related entities are fetched only when they are accessed.

```java
@ManyToOne(fetch = FetchType.LAZY)
```

Benefits

- Improves performance
- Loads only required data
- Reduces unnecessary database access

---

## N+1 Query Problem

Occurs when Hibernate executes:

```
1 Query

+

N Additional Queries
```

Example

```
Students

↓

Department of Student 1

↓

Department of Student 2

↓

Department of Student 3
```

Result

```
1 + N Queries
```

---

## EntityGraph

This project uses `@EntityGraph` in the JPA repository to fetch related entities in a single optimized query.

Example

```java
@EntityGraph(attributePaths = "department")
List<Student> findAll();
```

Benefits

- Eliminates the N+1 Problem
- Reduces database round trips
- Improves performance

---

# Concepts Demonstrated

- JPA Cascading
- Cascade Operations
- Lazy Loading
- FetchType.LAZY
- Transactional Loading
- N+1 Query Problem
- EntityGraph
- Spring Data JPA
- Hibernate ORM

---

# Learning Outcomes

After completing this project, you will understand:

- ✅ JPA Cascading
- ✅ Cascade Operations
- ✅ Lazy Loading
- ✅ FetchType.LAZY
- ✅ Transactional Loading
- ✅ N+1 Query Problem
- ✅ EntityGraph
- ✅ Spring Data JPA
- ✅ Hibernate ORM
- ✅ Query Optimization

---

# Learning Objective

The objective of this project is to understand how Hibernate manages cascading operations, lazy loading, and query execution, and how `@EntityGraph` can be used to optimize fetching strategies and eliminate the N+1 query problem in Spring Boot applications.
