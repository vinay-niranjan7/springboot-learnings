# 16 - Transaction Propagation & Isolation Demo

A Spring Boot project demonstrating advanced **Spring Transaction Management** concepts, focusing on **Transaction Propagation**, **Isolation Levels**, and how transactions behave across multiple service methods using `@Transactional`.

> This project simulates an order placement workflow where an order is created and a payment audit is recorded within transactional boundaries.

---

# Features

- Spring Transaction Management
- `@Transactional`
- Transaction Propagation
- Isolation Levels
- Order Processing
- Payment Audit
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
│   └── OrderController
│
├── entity
│   ├── Order
│   └── PaymentAudit
│
├── repository
│   ├── OrderRepository
│   └── PaymentAuditRepository
│
├── service
│   ├── OrderService
│   └── PaymentAuditService
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

## Order APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/api/order` | Place Order |

---

# Sample Request

## Place Order

**POST**

```
http://localhost:8081/api/order
```

### Request Body

```json
{
    "productName": "Laptop",
    "amount": 75000
}
```

### Response

```text
Order Placed
```

---

# Project Flow

```
Client

↓

OrderController

↓

OrderService
@Transactional

↓

Save Order

↓

PaymentAuditService
@Transactional

↓

Save Payment Audit

↓

Commit Transaction
```

---

# Concepts Covered

## Spring Transaction Management

Transaction management ensures multiple database operations execute as a single logical unit.

---

## @Transactional

The project demonstrates transaction management using Spring's `@Transactional` annotation.

Example

```java
@Transactional
public void placeOrder(Order order) {

}
```

---

## Transaction Propagation

This project demonstrates transaction propagation between multiple service methods.

Current propagation mode:

```java
Propagation.REQUIRED
```

Behavior:

- Join an existing transaction if one exists.
- Otherwise, create a new transaction.

---

## Isolation Level

The audit service uses:

```java
Isolation.REPEATABLE_READ
```

This isolation level prevents:

- Dirty Reads
- Non-Repeatable Reads

while allowing better concurrency than `SERIALIZABLE`.

---

## Service-to-Service Transactions

```
OrderService

↓

PaymentAuditService
```

Both services participate in the same transaction because of **Propagation.REQUIRED**.

---

## Payment Audit

Whenever an order is placed:

- Order is saved.
- Payment audit entry is created.
- Both operations execute within the transaction.

---

# Transaction Flow

```
BEGIN

↓

Save Order

↓

Save Payment Audit

↓

COMMIT
```

If an exception occurs

```
BEGIN

↓

Save Order

↓

Save Payment Audit

↓

Exception

↓

ROLLBACK
```

---

# Transaction Propagation Modes

This project introduces transaction propagation concepts including:

- REQUIRED
- REQUIRES_NEW
- SUPPORTS
- MANDATORY
- NOT_SUPPORTED
- NEVER
- NESTED

---

# Isolation Levels

The project covers:

- READ_UNCOMMITTED
- READ_COMMITTED
- REPEATABLE_READ
- SERIALIZABLE

---

# Concurrency Problems

The concepts demonstrated include:

- Dirty Read
- Non-Repeatable Read
- Phantom Read

---

# Project Demonstrates

- Spring Transaction Management
- `@Transactional`
- Transaction Propagation
- Propagation.REQUIRED
- Isolation Levels
- Isolation.REPEATABLE_READ
- Service-to-Service Transactions
- Commit
- Rollback
- Order Processing
- Payment Audit
- Spring Data JPA
- Hibernate ORM

---

# Learning Outcomes

After completing this project, you will understand:

- ✅ Spring Transaction Management
- ✅ `@Transactional`
- ✅ Transaction Propagation
- ✅ Propagation.REQUIRED
- ✅ Isolation Levels
- ✅ READ_UNCOMMITTED
- ✅ READ_COMMITTED
- ✅ REPEATABLE_READ
- ✅ SERIALIZABLE
- ✅ Dirty Read
- ✅ Non-Repeatable Read
- ✅ Phantom Read
- ✅ Commit & Rollback
- ✅ Service-to-Service Transactions

---

# Learning Objective

The objective of this project is to understand how Spring manages transactions across multiple service layers, how propagation affects nested service calls, how isolation levels influence concurrent database access, and how Spring Boot ensures data consistency using Spring Data JPA and Hibernate.
