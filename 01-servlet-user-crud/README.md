# Java Servlet User CRUD

A simple **CRUD (Create, Read, Update, Delete)** application built using **Java Servlets** and **Maven**. This project demonstrates how to perform basic CRUD operations using an **in-memory HashMap** without a database.

---

## Features

- Create User
- Get User by ID
- Get All Users
- Update User
- Delete User
- In-memory data storage using `HashMap`
- Tested using Postman

---

## Technologies Used

- Java
- Jakarta Servlet API
- Apache Tomcat
- Maven
- Postman

---

## Data Storage

This project uses an **in-memory `HashMap<Integer, User>`** to store user information.

- No database is used.
- User data is stored only while the server is running.
- Restarting the Tomcat server clears all stored data.

---

## URL Mapping

Base URL:

```
http://localhost:8080/servlet-crud/users
```

| HTTP Method | Endpoint | Description | Request Parameters |
|-------------|----------|-------------|--------------------|
| POST | `/users` | Create a new user | `id`, `name`, `email`, `mobile` |
| GET | `/users` | Get all users | None |
| GET | `/users?id={id}` | Get user by ID | `id` |
| PUT | `/users` | Update user | `id`, `name`, `email`, `mobile` |
| DELETE | `/users?id={id}` | Delete user | `id` |



## Note

- This project **does not accept JSON request bodies**.
- All input values are passed as **Request Parameters (Query Parameters)** in **Postman**.
- Data is stored temporarily using an **in-memory HashMap**, so all data is lost when the server is restarted.

---

## Project Structure

```
src
└── main
    └── java
        └── com
            └── vinay7
                ├── model
                │   └── User.java
                ├── service
                │   └── UserService.java
                ├── servlet
                │   └── UserServlet.java
                └── Main.java
```

---

## How to Run

### Clone the repository

```bash
git clone https://github.com/vinay-niranjan7/java-servlet-user-crud.git
```

### Open the project

Open the project using:

- IntelliJ IDEA
- VS Code

### Build the project

```bash
mvn clean install
```

### Deploy

Deploy the generated WAR file on **Apache Tomcat**.

### Test APIs

Use **Postman** to test all CRUD operations.

---

## Future Improvements

- Store data in MySQL instead of HashMap
- Use JDBC for database connectivity
- Accept JSON request bodies using Jackson/Gson
- Add Input Validation
- Add Global Exception Handling
- Build REST APIs using Spring Boot

---

## Author

**Vinay Niranjan**

GitHub: https://github.com/vinay-niranjan7
