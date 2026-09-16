# 21 - Logging Demo

A simple Spring Boot project demonstrating **Log4j2 logging, log levels, console logging, file logging, and package-specific logging** using a custom `log4j2-spring.xml` configuration.

---

# Features

- Log4j2
- Logger
- Log Levels
- `log.info()`
- `log.debug()`
- `log.warn()`
- `log.error()`
- Console Logging
- File Logging
- Console Appender
- File Appender
- PatternLayout
- Package-specific Logging
- `AppenderRef`
- `additivity`
- `log4j2-spring.xml`
- `application.properties`
- Writing Logs to a File

---

# Tech Stack

- Java 25
- Spring Boot 4.1.1
- Spring Web MVC
- Log4j2
- Maven

---

# Project Structure

```text
LoggingDemo
│
├── pom.xml
│
├── logs
│   └── app.log
│
└── src
    └── main
        ├── java
        │   └── com.vinay7.LoggingDemo
        │       ├── controller
        │       │   └── HelloController
        │       ├── service
        │       │   └── HelloService
        │       └── LoggingDemoApplication
        │
        └── resources
            ├── application.properties
            └── log4j2-spring.xml
```

---

# Log4j2

The project uses **Log4j2** as the logging framework.

Spring Boot uses a default logging implementation, but this project replaces it with Log4j2.

The dependency is added using:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-log4j2</artifactId>
</dependency>
```

The default Spring Boot logging starter is excluded from the Web MVC dependency.

---

# Logger

A logger is created using:

```java
private static final Logger log =
        LogManager.getLogger(HelloController.class);
```

The logger is then used to write application logs.

Example:

```java
log.info("greet() method started");
```

---

# Log Levels

The project demonstrates the basic Log4j2 log levels:

```java
log.debug("Debug message");

log.info("Info message");

log.warn("Warning message");

log.error("Error message");
```

Each log level represents a different level of importance.

---

# Console Logging

A `Console` appender is configured to display logs in the IntelliJ console.

```xml
<Console name="Console">
    <PatternLayout pattern="%d{HH:mm:ss} %-5level %c - %msg%n"/>
</Console>
```

Application logs can therefore be seen directly in the console while running the application.

---

# File Logging

A `File` appender is used to write logs into a file.

```xml
<File name="File" fileName="logs/app.log">
    <PatternLayout pattern="%d{HH:mm:ss} %-5level %c - %msg%n"/>
</File>
```

The log file is created at:

```text
logs/app.log
```

---

# PatternLayout

`PatternLayout` defines how each log message is displayed.

```xml
<PatternLayout pattern="%d{HH:mm:ss} %-5level %c - %msg%n"/>
```

Example output:

```text
22:36:50 INFO  com.vinay7.LoggingDemo.controller.HelloController - greet() method started
```

The pattern contains:

```text
%d       → Date / Time
%-5level → Log level
%c       → Logger / Class name
%msg     → Log message
%n       → New line
```

---

# Package-specific Logging

The project configures logging specifically for:

```text
com.vinay7.LoggingDemo
```

```xml
<Logger name="com.vinay7.LoggingDemo"
        level="info"
        additivity="false">

    <AppenderRef ref="Console"/>
    <AppenderRef ref="File"/>

</Logger>
```

This allows the application's own logs to be handled separately from other libraries.

---

# AppenderRef

`AppenderRef` connects a logger to an appender.

The project connects the application logger to both:

```xml
<AppenderRef ref="Console"/>
<AppenderRef ref="File"/>
```

Therefore:

```text
Logger
   │
   ├── Console
   │
   └── File
```

The same application log is displayed in the console and written to `app.log`.

---

# Additivity

The logger uses:

```xml
additivity="false"
```

This prevents the application's logs from being passed to a parent/root logger.

This helps keep the logging configuration controlled at the application package level.

---

# Root Logger

A Root logger is also configured:

```xml
<Root level="error">
    <AppenderRef ref="Console"/>
</Root>
```

This handles other logs at the `ERROR` level while the application's own logs are handled by the package-specific logger.

---

# Application Properties

The Log4j2 configuration file is specified in:

```text
src/main/resources/application.properties
```

Configuration:

```properties
logging.config=classpath:log4j2-spring.xml
```

This tells Spring Boot to use:

```text
log4j2-spring.xml
```

as the Log4j2 configuration file.

---

# Controller Logging

`HelloController` contains a logger:

```java
private static final Logger log =
        LogManager.getLogger(HelloController.class);
```

The `/greet` endpoint logs different stages of execution.

Example:

```java
log.info("greet() method started");

String message = helloService.greet();

log.info("Message received from service: {}", message);

log.info("greet() method completed");
```

---

# Service Logging

`HelloService` also contains a logger:

```java
private static final Logger log =
        LogManager.getLogger(HelloService.class);
```

Example:

```java
log.info("greet() method started");

String message = "Welcome to Logging Demo";

log.info("Returning message: {}", message);

return message;
```

---

# Request Flow

When the `/greet` endpoint is called:

```text
GET /greet
     │
     ↓
HelloController
     │
     │ log.info()
     ↓
HelloService
     │
     │ log.info()
     ↓
Return Message
     │
     ↓
HelloController
     │
     │ log.info()
     ↓
Response
```

---

# Example Output

The application logs are displayed in the console:

```text
22:36:50 INFO  com.vinay7.LoggingDemo.controller.HelloController - greet() method started
22:36:50 INFO  com.vinay7.LoggingDemo.service.HelloService - greet() method started
22:36:50 INFO  com.vinay7.LoggingDemo.service.HelloService - Returning message: Welcome to Logging Demo
22:36:50 INFO  com.vinay7.LoggingDemo.controller.HelloController - Message received from service: Welcome to Logging Demo
22:36:50 INFO  com.vinay7.LoggingDemo.controller.HelloController - greet() method completed
```

The same application logs are written to:

```text
logs/app.log
```

---

# API Endpoint

## Greet

### GET

```text
http://localhost:8080/greet
```

### Response

```text
Welcome to Logging Demo
```

---

# Logging Flow

The complete Log4j2 flow in this project:

```text
Application Code
      │
      ↓
    Logger
      │
      ↓
 Package Logger
      │
      ├───────────────┐
      ↓               ↓
 Console Appender  File Appender
      ↓               ↓
 IntelliJ Console  logs/app.log
```

---

# Configuration Files

## application.properties

```properties
logging.config=classpath:log4j2-spring.xml
```

## log4j2-spring.xml

The main Log4j2 configuration contains:

- Console Appender
- File Appender
- PatternLayout
- Package-specific Logger
- Root Logger
- Appender References

---

# Learning Outcomes

After completing this project, you will understand:

- ✅ What logging is
- ✅ How Log4j2 works with Spring Boot
- ✅ How to create a Logger
- ✅ How to use different log levels
- ✅ How to log messages using `log.info()`
- ✅ How to log variables using `{}` placeholders
- ✅ How to configure a Console Appender
- ✅ How to configure a File Appender
- ✅ How to write logs into a file
- ✅ How `PatternLayout` works
- ✅ How `AppenderRef` works
- ✅ How package-specific logging works
- ✅ What `additivity` means
- ✅ How to configure Log4j2 using `log4j2-spring.xml`
- ✅ How to connect Spring Boot with Log4j2
- ✅ How to send logs to both console and file

---

# Run the Application

Run the Spring Boot application using Maven:

```bash
mvn spring-boot:run
```

Or run:

```bash
mvn clean package
```

Then start the generated application.

Open:

```text
http://localhost:8080/greet
```

After calling the endpoint, check:

```text
logs/app.log
```

for the generated application logs.

---

# Learning Objective

This project demonstrates the **basics of logging in Spring Boot using Log4j2**, including creating loggers, using log levels, configuring console and file appenders, writing application logs to a file, and controlling application-specific logging using a package logger.