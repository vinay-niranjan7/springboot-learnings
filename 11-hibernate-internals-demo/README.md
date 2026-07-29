# 11 - Hibernate Internals Demo

A Spring Boot project demonstrating the **internal working of Hibernate and JPA**, focusing on **Persistence Context**, **Entity Lifecycle**, **EntityManager**, **Transactions**, **Dirty Checking**, and the **First-Level Cache**.

> This project is designed to understand what happens behind the scenes when using Spring Data JPA and Hibernate instead of treating them as a black box.

---

# Features

- CRUD Operations
- Spring Data JPA
- Hibernate ORM
- Persistence Context
- Entity Lifecycle
- Dirty Checking
- First-Level Cache
- Transaction Management
- REST APIs

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
│   └── StudentController
├── service
│   └── StudentService
├── repository
│   └── StudentRepository
├── model
│   └── Student
└── HibernateInternalsDemoApplication
```

---

# API Endpoints

| Method | Endpoint | Description |
|----------|----------------------|-------------------------|
| POST | `/api/students` | Create Student |
| GET | `/api/students/{id}` | Get Student By Id |
| PUT | `/api/students/{id}` | Update Student |
| DELETE | `/api/students/{id}` | Delete Student |

---

# Base URL

```
http://localhost:8081
```

---

# Create Student

### URL

```
POST /api/students
```

### Request Body

```json
{
  "name": "Vinay",
  "email": "vinay@gmail.com",
  "age": 20
}
```
---

# Update Student

### URL

```
PUT /api/students//{id}
```

### Request Body

```json
{
  "name": "Vinay Niranjan",
  "email": "vinay@gmail.com",
  "age": 19
}
```

---

# Get Student By Id

### URL

```
GET /api/students/{id}
```

---

# Delete Student

### URL

```
DELETE /api/students//{id}
```

---

# JPA vs Hibernate

| JPA | Hibernate |
|------|-----------|
| Specification | Implementation of JPA |
| Defines interfaces | Implements those interfaces |
| Database Independent | Hibernate-specific implementation |

```
JPA
 │
 ▼
Hibernate
 │
 ▼
Database
```

---

# EntityManagerFactory

- Heavy-weight object
- Created once during application startup
- Thread-safe
- Creates EntityManager instances

```
EntityManagerFactory
        │
        ▼
Creates EntityManagers
```

---

# EntityManager

EntityManager manages all entities inside the Persistence Context.

### Common APIs

```java
persist()
find()
remove()
merge()
detach()
flush()
clear()
```

---

# Persistence Context

Persistence Context is an in-memory storage that contains all managed entities.

```
Database
     │
     ▼
EntityManager
     │
     ▼
Persistence Context
     │
     ▼
Managed Entities
```

---

# Entity Lifecycle

```
new Student()

      │
      ▼
  Transient
      │
 persist()
      ▼
   Managed
   │      │
detach() remove()
 │         │
 ▼         ▼
Detached Removed
```

### Transient

- Newly created object
- Not stored in database
- Not managed by Hibernate

### Managed

- Stored in Persistence Context
- Hibernate tracks all changes

### Detached

- No longer managed
- Changes are not tracked

### Removed

- Scheduled for deletion
- Deleted during transaction commit

---

# First-Level Cache

Persistence Context acts as Hibernate's First-Level Cache.

```
find(1)

↓

Persistence Context

↓

Found?
 ├── Yes → Return Entity
 └── No → Query Database
```

Repeated calls to `find()` for the same entity within the same Persistence Context do not execute another SQL query.

---

# Dirty Checking

Hibernate automatically detects modifications made to managed entities.

```java
Student student = entityManager.find(Student.class, 1L);

student.setName("Updated Name");
```

No explicit `update()` call is required.

Hibernate automatically generates the SQL UPDATE statement during transaction commit.

---

# Transactions

Without Transaction

```
Operation A

Operation B ❌

Database becomes inconsistent
```

With Transaction

```
BEGIN

Operation A

Operation B

COMMIT
```

Failure Scenario

```
BEGIN

Operation A

Operation B ❌

ROLLBACK
```

---

# Raw Hibernate Transaction

```java
Session session = sessionFactory.openSession();

Transaction transaction = session.beginTransaction();

try {

    session.persist(student);

    transaction.commit();

} catch (Exception e) {

    transaction.rollback();

}
```

---

# Spring Transaction

```java
@Transactional
public void createStudent() {

    // Business Logic

}
```

Spring automatically handles

- Transaction Creation
- Commit
- Rollback
- Closing Resources

---

# Flush vs Commit

## flush()

- Synchronizes Persistence Context with the database
- Transaction remains active
- Can still rollback

## commit()

- Flushes pending changes
- Permanently saves data
- Ends transaction

---

# Important APIs

| Method | Description |
|----------|-------------|
| persist() | Save entity |
| find() | Fetch entity |
| merge() | Reattach detached entity |
| remove() | Delete entity |
| detach() | Remove entity from Persistence Context |
| clear() | Clear Persistence Context |
| flush() | Synchronize changes with database |

---

# Learning Outcomes

After completing this project, you will understand:

- Hibernate Architecture
- JPA vs Hibernate
- EntityManager
- EntityManagerFactory
- Persistence Context
- Entity Lifecycle
- First-Level Cache
- Dirty Checking
- Transactions
- Flush vs Commit
- Spring `@Transactional`
- Hibernate Internals

---


# Learning Objective

The objective of this project is to understand **how Hibernate works internally**, making it easier to write optimized, efficient, and production-ready Spring Boot applications.

---

## Author

**Vinay Niranjan**

GitHub: https://github.com/vinay-niranjan7
