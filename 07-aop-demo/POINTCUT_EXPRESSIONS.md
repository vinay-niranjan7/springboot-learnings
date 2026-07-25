# Spring AOP Pointcut Expressions

This document explains the pointcut expressions used in Spring AOP. Pointcuts determine **which methods should be intercepted by an aspect**.

---

# Pointcut Syntax

```java
execution(modifiers? return-type package.class.method(arguments) throws?)
```

Example

```java
execution(* com.vinay7.aopdemo.service.StudentService.createStudent(..))
```

---

# Wildcards

## `*` (Single Wildcard)

Matches any return type, class name, method name, or one package level.

Example

```java
execution(* com.vinay7.aopdemo.service.StudentService.createStudent(..))
```

Matches

```java
Student createStudent(...)
String createStudent(...)
void createStudent(...)
```

---

## `..` (Multiple Wildcard)

Matches:

- Any number of packages
- Any number of method arguments

Example

```java
execution(* com.vinay7..*(..))
```

Matches every method inside every package under `com.vinay7`.

---

# Matching by Method

## Exact Method

```java
execution(* com.vinay7.aopdemo.service.StudentService.createStudent(..))
```

Matches only

```
createStudent()
```

---

## Any Method

```java
execution(* com.vinay7.aopdemo.service.StudentService.*(..))
```

Matches

```
createStudent()
dummyMethod()
deleteStudent()
updateStudent()
```

---

# Matching by Class

## Single Class

```java
execution(* com.vinay7.aopdemo.service.StudentService.*(..))
```

Intercepts every method of `StudentService`.

---

## Every Class in Package

```java
execution(* com.vinay7.aopdemo.service.*.*(..))
```

Intercepts every method of every class inside the `service` package.

---

## Every Class in Every Subpackage

```java
execution(* com.vinay7.aopdemo..*.*(..))
```

Intercepts all methods inside the project.

---

# Matching by Return Type

## Any Return Type

```java
execution(* *(..))
```

Matches every method.

---

## Only void Methods

```java
execution(void *(..))
```

Matches

```java
void save()
void delete()
```

---

## Only String Methods

```java
execution(String *(..))
```

Matches

```java
String getName()
String dummyMethod()
```

---

# Matching by Arguments

## No Arguments

```java
execution(* *())
```

Matches

```java
hello()
```

---

## Exactly One Argument

```java
execution(* *(String))
```

Matches

```java
dummyMethod(String name)
```

---

## Any Number of Arguments

```java
execution(* *(..))
```

Matches

```java
save()
save(Student)
save(Student,int,String)
```

---

## First Argument Must Be String

```java
execution(* *(String,..))
```

Matches

```java
method(String)
method(String,int)
method(String,Student)
```

---

# Matching by Package

## Specific Package

```java
execution(* com.vinay7.aopdemo.service.*.*(..))
```

Only intercepts service package.

---

## Entire Project

```java
execution(* com.vinay7.aopdemo..*(..))
```

Intercepts every method inside the project.

---

# Frequently Used Pointcuts

## Every Service Method

```java
execution(* com.vinay7.aopdemo.service.*.*(..))
```

---

## One Specific Method

```java
execution(* com.vinay7.aopdemo.service.StudentService.createStudent(..))
```

---

## Any Getter

```java
execution(* get*(..))
```

---

## Any Setter

```java
execution(* set*(..))
```

---

## Every Public Method

```java
execution(public * *(..))
```

---

# Common Pointcut Examples

| Pointcut | Description |
|----------|-------------|
| `execution(* *(..))` | Every method |
| `execution(public * *(..))` | Every public method |
| `execution(* get*(..))` | Every getter |
| `execution(* set*(..))` | Every setter |
| `execution(* save*(..))` | Methods starting with save |
| `execution(* *Service.*(..))` | Every method in classes ending with Service |
| `execution(* com.vinay7.aopdemo.service.*.*(..))` | Every service method |
| `execution(* com.vinay7.aopdemo..*(..))` | Every method in the project |
| `execution(void *(..))` | Every void method |
| `execution(String *(..))` | Every String-returning method |

---

# Other Pointcut Designators

Spring AOP also supports:

## within

Matches every method inside a class or package.

```java
within(com.vinay7.aopdemo.service.*)
```

---

## this

Matches based on the proxy object.

```java
this(com.vinay7.aopdemo.service.StudentService)
```

---

## target

Matches based on the target object.

```java
target(com.vinay7.aopdemo.service.StudentService)
```

---

## args

Matches based on method argument types.

```java
args(String)
```

---

## @annotation

Matches methods annotated with a specific annotation.

```java
@annotation(org.springframework.transaction.annotation.Transactional)
```

---

## @within

Matches every method inside classes annotated with a specific annotation.

```java
@within(org.springframework.stereotype.Service)
```

---

## @target

Matches target objects having a particular annotation.

```java
@target(org.springframework.stereotype.Service)
```

---

## @args

Matches runtime argument annotations.

```java
@args(com.example.Validated)
```

---

# Learning Summary

In this project, the following pointcuts were used:

```java
execution(* com.vinay7.aopdemo.service.StudentService.createStudent(..))
```

```java
execution(* com.vinay7.aopdemo.service.StudentService.dummyMethod(..))
```

These pointcuts were used to demonstrate:

- `@Before`
- `@After`
- `@AfterReturning`
- `@AfterThrowing`
- `@Around`

---

**Author:** Vinay Niranjan
