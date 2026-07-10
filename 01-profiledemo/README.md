# Spring Boot Profile Demo

A simple Spring Boot project demonstrating the use of **Spring Profiles** to load different bean implementations and configuration files for different environments such as **Development**, **Staging**, and **Production**.

## 📖 Overview

This project shows how Spring Boot selects different beans and configuration properties depending on the active profile.

The application exposes a REST endpoint that sends different notification messages based on the currently active Spring profile.

## 🚀 Features

- Spring Boot REST API
- Spring Profiles (`dev`, `staging`, `prod`)
- Profile-specific bean loading using `@Profile`
- Profile-specific configuration using `application-{profile}.properties`
- Constructor-based Dependency Injection

## 🛠️ Technologies Used

- Java 25
- Spring Boot 4
- Spring Boot Web MVC
- Maven

## 📂 Project Structure

```
src
└── main
    ├── java
    │   └── com.vinay7.profiledemo
    │       ├── NotificationController.java
    │       ├── NotificationService.java
    │       ├── DevNotificationServiceImp.java
    │       ├── ProdNotificationServiceImp.java
    │       └── ProfiledemoApplication.java
    │
    └── resources
        ├── application.properties
        ├── application-dev.properties
        ├── application-staging.properties
        └── application-prod.properties
```

## ⚙️ Profiles

### Development (Default)

Loads:

- `DevNotificationServiceImp`
- `application-dev.properties`

Returns:

```
dummy notification
```

---

### Staging

Loads:

- `DevNotificationServiceImp`
- `application-staging.properties`

Returns:

```
dummy notification
```

---

### Production

Loads:

- `ProdNotificationServiceImp`
- `application-prod.properties`

Returns:

```
Real Notification
```

## 📌 API Endpoint

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/notification` | Sends a notification message based on the active profile |

Example:

```
POST http://localhost:8081/notification
```

## ▶️ Running the Project

Clone the repository

```bash
git clone https://github.com/vinay-niranjan7/springboot-learnings.git
```

Navigate to the project

```bash
cd 01-profiledemo
```

Run the application

```bash
mvn spring-boot:run
```

### Run with Development Profile

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

### Run with Staging Profile

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=staging
```

### Run with Production Profile

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=prod
```

## 📚 Concepts Practiced

- Spring Profiles
- `@Profile`
- Dependency Injection
- Interface-based Programming
- REST Controller
- ResponseEntity
- Environment-specific Configuration

## 🎯 Learning Outcome

This project helped me understand how Spring Boot can load different beans and configuration files for different environments, making applications easier to configure for development, testing, staging, and production.

---

**Author:** Vinay Niranjan
