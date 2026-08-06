# 15 - Transaction Demo

A Spring Boot project demonstrating **database transaction management** using Spring's **`@Transactional`** annotation. This project simulates a bank account transfer and explains how Spring ensures data consistency using **ACID properties**, **commit**, and **rollback**.

> This project demonstrates how multiple database operations can be executed as a single business transaction.

---

# Features

- Spring Transaction Management
- `@Transactional`
- Bank Account Transfer
- ACID Properties
- Commit & Rollback
- Transaction Boundary
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
│   ├── AccountController
│   └── TransferController
│
├── entity
│   ├── Account
│   └── TransferRecord
│
├── repository
│   ├── AccountRepository
│   └── TransferRepository
│
├── service
│   ├── AccountService
│   └── TransferService
│
└── TransactiondemoApplication
```

---

# Base URL

```
http://localhost:8081
```

---

# API Endpoints

## Account APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/api/account` | Create Account |

---

## Transfer APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/api/transfer` | Transfer Amount Between Accounts |

---

# Sample Requests

## Create Account

**POST**

```
http://localhost:8081/api/account
```

### Request Body

```json
{
  "name": "Vinay",
  "balance": 10000
}
```

---

## Transfer Money

**POST**

```
http://localhost:8081/api/transfer
```

### Request Body

```json
{
  "fromAccountId": 1,
  "toAccountId": 2,
  "amount": 1000
}
```

---

# Concepts Covered

## Database Transaction

A transaction is a group of database operations treated as **one logical unit of work**.

Example

```
Debit Account A

↓

Credit Account B

↓

Record Transfer
```

Either all operations succeed or all of them are rolled back.

---

# ACID Properties

## Atomicity

All operations succeed together or all are discarded.

Example

```
Debit Account

↓

Credit Account

↓

Success ✅

OR

Rollback ❌
```

---

## Consistency

Moves the database from one valid state to another while maintaining business rules.

Example

- Account balance cannot become negative.
- Total money remains unchanged after transfer.

---

## Isolation

Controls how concurrent transactions interact with each other.

Prevents issues like:

- Dirty Read
- Lost Update
- Inconsistent Data

---

## Durability

Once a transaction is committed, the changes survive:

- Application crash
- Database restart
- Server failure

---

# Transaction Boundary

A transaction begins before a business operation starts and ends after it completes.

```
Begin Transaction

↓

Business Logic

↓

Commit

OR

Rollback
```

In Spring, the transaction boundary is typically defined at the **Service Layer** using `@Transactional`.

---

# Begin, Commit and Rollback

## Begin

Starts a database transaction.

---

## Commit

Permanently saves all successful changes.

```
BEGIN

↓

Operations

↓

COMMIT
```

---

## Rollback

Discards all uncommitted changes if an exception occurs.

```
BEGIN

↓

Operations

↓

Exception

↓

ROLLBACK
```

---

# Transaction Layers

Spring transaction management works on top of lower-level persistence APIs.

```
Service Method

↓

Spring Transaction Management

↓

JPA EntityManager

↓

Hibernate Session

↓

JDBC Connection

↓

Database Transaction
```

---

# JDBC Transaction

Manual transaction management.

```java
connection.setAutoCommit(false);

connection.commit();

connection.rollback();
```

---

# JPA Transaction

Uses `EntityTransaction`.

```java
EntityTransaction transaction =
entityManager.getTransaction();

transaction.begin();

transaction.commit();

transaction.rollback();
```

---

# Hibernate Transaction

Uses Hibernate's native transaction API.

```java
Transaction transaction =
session.beginTransaction();

transaction.commit();

transaction.rollback();
```

---

# Spring Transaction

Spring removes transaction boilerplate using `@Transactional`.

```java
@Transactional
public void transfer(...) {

    // Business Logic

}
```

Spring automatically manages:

- Transaction Begin
- Commit
- Rollback
- Resource Management

---

# Transaction Flow

```
Client

↓

Controller

↓

@Transactional Service

↓

Repository

↓

Database
```

If every operation succeeds:

```
BEGIN

↓

Execute Operations

↓

COMMIT
```

If an exception occurs:

```
BEGIN

↓

Execute Operations

↓

Exception

↓

ROLLBACK
```

---

# Project Demonstrates

- Spring Transaction Management
- `@Transactional`
- Database Transactions
- ACID Properties
- Atomicity
- Consistency
- Isolation
- Durability
- Transaction Boundary
- Begin
- Commit
- Rollback
- JDBC Transactions
- JPA Transactions
- Hibernate Transactions
- Spring Data JPA
- Hibernate ORM

---

# Learning Outcomes

After completing this project, you will understand:

- ✅ Database Transactions
- ✅ ACID Properties
- ✅ Transaction Lifecycle
- ✅ Begin, Commit & Rollback
- ✅ Spring `@Transactional`
- ✅ Transaction Boundary
- ✅ JDBC Transactions
- ✅ JPA Transactions
- ✅ Hibernate Transactions
- ✅ Spring Transaction Management
- ✅ Real-world Bank Transfer Example

---

# Learning Objective

The objective of this project is to understand how Spring Boot manages database transactions, why transactions are essential for maintaining data integrity, and how `@Transactional` simplifies transaction management by coordinating JPA, Hibernate, JDBC, and the underlying database transaction.
