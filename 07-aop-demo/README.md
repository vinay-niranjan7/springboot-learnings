# AOP Demo

A Spring Boot project demonstrating **Spring AOP (Aspect-Oriented Programming)** using AspectJ annotations. This project covers all five major advice types and shows how aspects can intercept method execution to implement cross-cutting concerns such as logging, exception handling, execution control, argument modification, and return value modification.

> **Note:** Only one advice should be enabled at a time while testing. The project contains multiple examples (commented and uncommented) to demonstrate the behavior of each advice independently.

---

## 📖 Overview

This project demonstrates how Spring AOP separates cross-cutting concerns from business logic. It includes examples of:

- Before Advice
- After Advice
- After Returning Advice
- After Throwing Advice
- Around Advice
- Modifying Method Arguments
- Modifying Return Values
- Executing Target Method Multiple Times

---

## ✨ Features

- Spring AOP using AspectJ
- Custom Aspect (`LoggingAspect`)
- Method Interception
- Request Logging
- Exception Handling
- Return Value Modification
- Method Argument Modification
- Around Advice
- REST API using Spring Boot

---

## 🛠️ Technologies Used

- Java
- Spring Boot
- Spring AOP
- AspectJ
- Spring MVC
- Maven

---

## 📂 Project Structure

```
src
├── aspect
│   └── LoggingAspect
├── controller
│   └── StudentController
├── dto
│   └── Student
├── service
│   └── StudentService
├── POINTCUT_EXPRESSIONS.md
└── README.md
```

---

## 📖 Documentation

This project includes an additional guide explaining Spring AOP pointcut expressions in detail.

| File | Description |
|------|-------------|
| **README.md** | Project overview, API endpoints, Spring AOP advice demonstrations, and learning outcomes. |
| **POINTCUT_EXPRESSIONS.md** | Detailed explanation of Spring AOP pointcut expressions, `execution()` syntax, wildcards (`*`, `..`), pointcut designators (`within`, `target`, `args`, `@annotation`, etc.), and practical examples. |

> 📌 **Recommended Reading Order**
>
> 1. Read this **README.md**.
> 2. Explore the project source code.
> 3. Read **POINTCUT_EXPRESSIONS.md** to understand how Spring AOP selects methods for interception.

---

## 📌 API Endpoints

### Create Student

**POST**

```
/api/students
```

### Request Body

```json
{
    "name": "Vinay",
    "age": 20
}
```

### Response

```json
{
    "name": "Vinay",
    "age": 20
}
```

---

### Dummy Method

**GET**

```
/api/students
```

Default Response

```
vinay
```

---

# Advice Demonstrations

## 1️⃣ Before Advice (`@Before`)

Executed before the target method.

### Demonstrates

- Logging before method execution
- Reading method arguments using `JoinPoint`
- Stopping method execution by throwing an exception

### Example Use Cases

- Authentication
- Authorization
- Input Validation
- Logging

---

## 2️⃣ After Returning Advice (`@AfterReturning`)

Executed only when the target method completes successfully.

### Demonstrates

- Accessing returned object
- Modifying returned object
- Logging successful execution

### Example

Original Response

```json
{
    "name":"Vinay",
    "age":20
}
```

Modified Response

```json
{
    "name":"Vinayak",
    "age":19
}
```

---

## 3️⃣ After Throwing Advice (`@AfterThrowing`)

Executed only when the target method throws an exception.

### Demonstrates

- Accessing thrown exception
- Logging exception details

### Example Output

```
Exception type: java.lang.RuntimeException
Exception Message: Some error happened
```

---

## 4️⃣ After Advice (`@After`)

Executed after method completion regardless of whether the method succeeds or fails.

### Demonstrates

- Cleanup logic
- Resource release
- Final logging

---

## 5️⃣ Around Advice (`@Around`) – Method Execution

Provides complete control over method execution.

### Demonstrates

- Executing code before the target method
- Executing code after the target method
- Exception handling
- Finally block execution
- Calling `joinPoint.proceed()`

### Example Flow

```
Starting : createStudent
Student saved
Execution Successful
Execution Completed
```

---

## 6️⃣ Around Advice – Argument Modification

Demonstrates modifying method arguments before execution.

### Original

```
vinay
```

### Modified by Aspect

```
VINAY
```

### Returned Response

```
VINAY : String Intercepted
```

This is achieved by:

- Reading arguments using `joinPoint.getArgs()`
- Creating modified arguments
- Calling `joinPoint.proceed(modifiedArgs)`

---

## 7️⃣ Around Advice – Calling Method Multiple Times

The active implementation demonstrates calling the target method twice.

### Execution Flow

```
dummyMethod called
Intercepted request calling again
dummyMethod called
```

This demonstrates that `@Around` advice has complete control over the execution of the target method.

---

## 📚 Concepts Practiced

- Aspect-Oriented Programming (AOP)
- Spring AOP
- AspectJ Annotations
- `@Aspect`
- `@Before`
- `@After`
- `@AfterReturning`
- `@AfterThrowing`
- `@Around`
- Pointcut Expressions
- JoinPoint
- ProceedingJoinPoint
- Method Interception
- Cross-Cutting Concerns
- Logging
- Exception Handling
- Return Value Modification
- Method Argument Modification
- Multiple Method Execution
- REST API Development

---

## 🎯 Learning Outcome

This project helped me understand:

- What Aspect-Oriented Programming (AOP) is.
- Why AOP is useful for separating cross-cutting concerns.
- How Spring creates proxy objects for aspects.
- How to define pointcuts using AspectJ expressions.
- How Spring intercepts method execution.
- The lifecycle of all five advice types.
- How to access method arguments using `JoinPoint`.
- How to modify method arguments using `ProceedingJoinPoint`.
- How to modify return values using `@AfterReturning`.
- How to intercept exceptions using `@AfterThrowing`.
- How `@Around` advice provides complete control over method execution.

---

## 🚀 Future Improvements

- Reusable Pointcuts using `@Pointcut`
- Applying aspects across multiple services
- Custom Annotation-Based AOP
- Performance Monitoring Aspect
- Audit Logging Aspect
- Security Aspect
- Transaction Management
- Global Logging Framework

---

## 📚 Additional Resources

For a detailed explanation of Spring AOP pointcut expressions, syntax, wildcards, and practical examples used in this project, refer to:

- **POINTCUT_EXPRESSIONS.md**

This document explains:

- `execution()` expression syntax
- Wildcards (`*`, `..`)
- Matching by method
- Matching by class
- Matching by package
- Matching by arguments
- Matching by return type
- Pointcut designators
- Practical Spring AOP examples

---

**Author:** Vinay Niranjan
