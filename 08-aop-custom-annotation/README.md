# AOP Custom Annotation

A Spring Boot project demonstrating **Spring AOP with Custom Annotations**. This project shows how to create a custom annotation and use it with Spring AOP to measure method execution time, configure warning thresholds, and customize operation names without writing pointcut expressions for individual methods.

---

## 📖 Overview

This project demonstrates how to:

- Create a custom annotation
- Use annotation-based pointcuts
- Intercept annotated methods
- Measure execution time
- Configure warning thresholds
- Customize operation names
- Build reusable cross-cutting functionality

Instead of targeting methods using an `execution()` pointcut expression, this project intercepts only methods annotated with `@TrackExecutionTime`.

---

## ✨ Features

- Custom Annotation (`@TrackExecutionTime`)
- Annotation-Based Pointcuts
- Execution Time Measurement
- Performance Monitoring
- Slow Operation Detection
- Configurable Warning Threshold
- Custom Operation Names
- Spring AOP using AspectJ
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

```text
src
├── main
│   ├── java
│   │   └── com.vinay7.aopdemo
│   │       ├── annotation
│   │       │   └── TrackExecutionTime
│   │       ├── aspect
│   │       │   └── SimpleAspect
│   │       ├── controller
│   │       │   └── StudentController
│   │       ├── dto
│   │       │   └── Student
│   │       └── service
│   │           └── StudentService

```

---


## 📌 Custom Annotation

```java
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TrackExecutionTime {

    long warnAfter() default 2000;

    String operation() default "";
}
```

### Annotation Parameters

| Parameter | Default | Description |
|-----------|---------|-------------|
| `warnAfter` | `2000` | Warning threshold in milliseconds |
| `operation` | `""` | Custom operation name displayed in logs |

---

## 📌 Annotation Usage

### Default Configuration

```java
@TrackExecutionTime
public Student createStudent(Student student)
```

Uses:

- Default warning threshold (2000 ms)
- Method name as operation name

---

### Custom Configuration

```java
@TrackExecutionTime(
    warnAfter = 1750,
    operation = "get students"
)
public String getStudent(String s)
```

Uses:

- Custom warning threshold
- Custom operation name

---

## 📌 Aspect Implementation

The project intercepts methods annotated with:

```java
@Around("@annotation(trackExecutionTime)")
```

The aspect performs the following:

- Starts execution timer
- Executes target method
- Calculates execution time
- Reads annotation attributes
- Prints execution time
- Displays slow operation alerts when threshold is exceeded

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

### Console Output

```
Student saved
Time Taken by createStudent: 1002
```

---

### Get Students

**GET**

```
/api/students
```

### Response

```
All Student Data
```

### Console Output

```
All Student Data
SLOW OPERATION ALERT : Time Taken by get students: 2001
```

---

## ⚙️ How It Works

1. A method is annotated with `@TrackExecutionTime`.
2. Spring AOP intercepts the method using:

```java
@Around("@annotation(trackExecutionTime)")
```

3. The aspect records the start time.
4. The original method executes.
5. The aspect calculates execution time.
6. Annotation values are read.
7. Execution details are printed.

---

## 📚 Concepts Practiced

- Aspect-Oriented Programming (AOP)
- Spring AOP
- Custom Annotations
- Annotation-Based Pointcuts
- `@Target`
- `@Retention`
- `@Documented`
- `@Aspect`
- `@Around`
- `ProceedingJoinPoint`
- Annotation Binding
- Execution Time Measurement
- Performance Monitoring
- Slow Operation Detection
- Custom Annotation Attributes
- Cross-Cutting Concerns

---

## 🎯 Learning Outcome

This project helped me understand:

- How to create custom annotations.
- How annotation metadata works.
- The purpose of `@Target`.
- The purpose of `@Retention`.
- The purpose of `@Documented`.
- How Spring AOP intercepts annotated methods.
- How to bind annotation instances inside an aspect.
- How to access annotation attribute values.
- How to measure execution time.
- How to create reusable performance monitoring using annotations.

---

## ⭐ If You Found This Project Helpful

If this project helped you learn Spring AOP and custom annotations, consider giving the repository a ⭐ on GitHub.

---

**Author:** Vinay Niranjan
