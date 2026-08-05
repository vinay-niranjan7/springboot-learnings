# 14 - Spring Data JPA Demo

A comprehensive Spring Boot project demonstrating **Spring Data JPA**, repository abstractions, CRUD operations, derived query methods, custom queries, pagination, sorting, and repository hierarchy. This project showcases how Spring Data JPA eliminates boilerplate repository code while providing powerful data access capabilities.

---

## 📌 Features

- CRUD Operations using `JpaRepository`
- Constructor Injection
- Spring Data Repository Hierarchy
- `CrudRepository`
- `ListCrudRepository`
- `PagingAndSortingRepository`
- `ListPagingAndSortingRepository`
- `JpaRepository`
- Derived Query Methods
- Custom Native SQL Queries
- `@Query` Annotation
- Pagination using `Page` & `Pageable`
- Sorting using `Sort`
- Safe Optional Handling using `orElseThrow()`
- Update Operations
- Repository Runtime Proxy
- EntityManager & Hibernate Flow
- REST API Endpoints
- Postman Tested APIs

---

## 🛠️ Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate ORM
- MySQL
- Maven
- REST APIs
- Postman

---

## 📚 Concepts Covered

### Spring Data JPA Overview

- Spring Data
- Spring Data JPA
- Spring Data MongoDB
- Repository Abstraction
- Runtime Repository Implementation
- Boilerplate Code Reduction

---

### Repository Hierarchy

```text
Repository
│
├── CrudRepository
│      └── ListCrudRepository
│
├── PagingAndSortingRepository
│      └── ListPagingAndSortingRepository
│
└── JpaRepository
```

---

### CRUD Operations

- save()
- saveAll()
- findById()
- findAll()
- existsById()
- count()
- delete()
- deleteById()
- deleteAll()
- flush()

---

### Derived Query Methods

Examples demonstrated:

```java
findByEmail()

findByEmailLike()

findByNameContainingIgnoreCase()

findByEmailAndAge()

findByEmailOrderByNameAsc()

findTop10ByNameContainingIgnoreCaseAndAgeGreaterThanAndActiveTrue(...)
```

Also covered:

- Like
- Containing
- StartsWith
- EndsWith
- GreaterThan
- LessThan
- Between
- In
- NotIn
- IsNull
- IsNotNull
- Distinct
- Top
- First
- Exists
- Count

---

### Custom Queries

Using `@Query`

```java
@Query(value = """
select * from student
where email = :email
""", nativeQuery = true)
```

Topics covered:

- Native SQL Queries
- Parameter Binding
- `@Param`
- Named Parameters

---

### JPQL (Java Persistence Query Language)

**Native SQL**

```sql
SELECT * FROM student
WHERE email = ?
```

**JPQL**

```jpql
SELECT s
FROM Student s
WHERE s.email = :email
```

---

### Pagination

- Pageable
- PageRequest
- Page
- Slice
- Page Number
- Page Size

Methods explored:

- getContent()
- getNumber()
- getSize()
- getNumberOfElements()
- getTotalElements()
- getTotalPages()
- hasNext()
- hasPrevious()
- isFirst()
- isLast()

---

### Sorting

Sorting using:

```java
Sort.by("name")
```

Multiple field sorting:

```java
Sort.by("name")
        .ascending()
        .and(
            Sort.by("age").descending()
        );
```

---

### Optional Handling

Safe entity retrieval using:

```java
orElseThrow()
```

instead of directly calling:

```java
Optional.get()
```

---

### Update Operations

Updating existing entities using:

- findById()
- Entity Modification
- save()

---

### Spring Data JPA Internals

```text
Service
      │
      ▼
Repository Interface
      │
      ▼
Spring Data JPA Runtime Proxy
      │
      ▼
SimpleJpaRepository
      │
      ▼
EntityManager
      │
      ▼
Hibernate
      │
      ▼
Database
```

---

## 📂 Project Structure

```text
src
├── controller
│   └── StudentController
├── service
│   └── StudentService
├── repository
│   └── StudentRepository
├── entity
│   └── Student
└── SpringDataJpaDemoApplication
```

---

## 🌐 REST APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/api/students` | Create Student |
| GET | `/api/students/{id}` | Get Student by ID |
| GET | `/api/students` | Get All Students (Pagination + Sorting) |
| GET | `/api/students/name/{name}` | Search Students by Name |
| PUT | `/api/students/{id}` | Update Student |

---

## 🧪 API Testing

Tested using **Postman**.

Implemented APIs include:

- Create Student
- Get Student by ID
- Get Students by Name
- Get All Students (Pagination + Sorting)
- Update Student
- Derived Query Methods
- Native SQL Query using `@Query`
