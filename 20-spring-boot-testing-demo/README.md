# 20 - Spring Boot Testing Demo

A Spring Boot project demonstrating **unit testing, Mockito-based testing, controller testing, repository testing, and Spring Boot context testing** using JUnit 5 and Spring Boot test slices.

---

# Features

- JUnit 5 Testing
- Unit Testing
- Mockito
- Mocking Dependencies
- `@Mock`
- `@InjectMocks`
- `@MockitoBean`
- `@ExtendWith(MockitoExtension.class)`
- Assertions
- Exception Testing
- `when()`
- `verify()`
- `never()`
- Service Layer Testing
- Controller Testing
- `@WebMvcTest`
- `MockMvc`
- JSON Response Testing
- Repository Testing
- `@DataJpaTest`
- Spring Boot Context Testing
- Arrange → Act → Assert Pattern

---

# Tech Stack

- Java 25
- Spring Boot 4.1.1
- Spring Web MVC
- Spring Data JPA
- Hibernate ORM
- MySQL
- JUnit 5
- Mockito
- Maven
- Lombok

---

# Project Structure

```text
TestingDemo
│
├── pom.xml
│
└── src
    ├── main
    │   ├── java
    │   │   └── com.vinay7.TestingDemo
    │   │       ├── controller
    │   │       │   └── ProductController
    │   │       ├── entity
    │   │       │   └── Product
    │   │       ├── repository
    │   │       │   └── ProductRepository
    │   │       ├── service
    │   │       │   ├── PriceCalculator
    │   │       │   └── ProductService
    │   │       └── TestingDemoApplication
    │   │
    │   └── resources
    │       └── application.properties
    │
    └── test
        └── java
            └── com.vinay7.TestingDemo
                ├── controller
                │   └── ProductControllerTest
                ├── repository
                │   └── ProductRepositoryTest
                ├── service
                │   ├── PriceCalculatorTest
                │   └── ProductServiceTest
                └── TestingDemoApplicationTests
```

---


# Testing Approaches

## 1. Unit Testing

Unit tests test a small piece of application logic independently.

Example:

```text
PriceCalculator
      ↓
PriceCalculatorTest
```

The `PriceCalculator` is tested without starting Spring.

---

# PriceCalculator Tests

The project tests:

### Valid Discount

```text
Price = 1000
Discount = 20%
Result = 800
```

### Invalid Discount

```text
Discount < 0
        OR
Discount > 100
```

Expected:

```text
IllegalArgumentException
```

---

# 2. Mockito Service Testing

`ProductService` depends on `ProductRepository`.

Instead of using the real repository, Mockito creates a mock.

```text
ProductService
      ↓
Mock ProductRepository
```

The test uses:

```java
@Mock
private ProductRepository productRepository;

@InjectMocks
private ProductService productService;
```

Mockito is initialized using:

```java
@ExtendWith(MockitoExtension.class)
```

---

# Service Test Cases

The project tests:

- Product exists
- Product does not exist
- Product creation with a unique name
- Product creation when the product already exists

### Example Mock

```java
when(productRepository.findById(1L))
        .thenReturn(Optional.of(product));
```

### Verify Repository Interaction

```java
verify(productRepository).findById(1L);
```

### Verify Method Was Not Called

```java
verify(productRepository, never())
        .save(any(Product.class));
```

---

# 3. Controller Testing

The project uses:

```java
@WebMvcTest
```

to test the `ProductController`.

The service dependency is replaced with a Mockito mock:

```java
@MockitoBean
private ProductService productService;
```

The controller is tested using:

```java
MockMvc
```

---

# MockMvc

`MockMvc` allows controller endpoints to be tested without starting a real web server.

Example:

```java
mockMvc.perform(
        get("/api/product/1")
                .accept(MediaType.APPLICATION_JSON)
)
.andExpect(status().isOk());
```

The test also verifies JSON fields:

```java
.andExpect(jsonPath("$.id").value(1))
.andExpect(jsonPath("$.name").value("Laptop"))
.andExpect(jsonPath("$.price").value(50000))
.andExpect(jsonPath("$.stock").value(10));
```

---

# Controller Endpoint

## Get Product

### GET

```text
http://localhost:8081/api/product/{id}
```

Example:

```text
http://localhost:8081/api/product/1
```

### Example Response

```json
{
  "id": 1,
  "name": "Laptop",
  "price": 50000,
  "stock": 10
}
```

---

# Create Product

## POST

```text
http://localhost:8081/api/product
```

### Request Body

```json
{
  "name": "Laptop",
  "price": 50000,
  "stock": 10
}
```

The controller delegates product creation to `ProductService`.

---

# 4. Repository Testing

The project includes:

```java
@DataJpaTest
```

for repository-layer testing.

```text
ProductRepository
       ↓
@DataJpaTest
```

`@DataJpaTest` is intended for testing the JPA repository and persistence layer.

---

# 5. Spring Boot Context Testing

The project also contains:

```java
@SpringBootTest
```

with:

```java
@Test
void contextLoads()
```

This verifies that the Spring Boot application context can start successfully.

---

# Arrange → Act → Assert

The tests follow the common:

```text
Arrange
   ↓
Act
   ↓
Assert
```

pattern.

### Arrange

Prepare test data and mocks.

```java
when(productRepository.findById(1L))
        .thenReturn(Optional.of(product));
```

### Act

Execute the method being tested.

```java
Product result =
        productService.getProductById(1L);
```

### Assert

Verify the result.

```java
assertEquals(1L, result.getId());
```

---

# Testing Layers

The project demonstrates testing at different application layers:

```text
                 Spring Boot Application
                          │
          ┌───────────────┼───────────────┐
          ↓               ↓               ↓
      Controller        Service       Repository
          ↓               ↓               ↓
      @WebMvcTest      Mockito        @DataJpaTest
          ↓               ↓               ↓
       MockMvc        Unit Tests      JPA Tests
```

---

# Testing Concepts Covered

## JUnit 5

- `@Test`
- `@BeforeEach`
- Assertions
- `assertEquals`
- `assertThrows`

## Mockito

- `@Mock`
- `@InjectMocks`
- `@MockitoBean`
- `MockitoExtension`
- `when()`
- `thenReturn()`
- `verify()`
- `never()`
- `any()`

## Spring Boot Testing

- `@SpringBootTest`
- `@WebMvcTest`
- `@DataJpaTest`
- `MockMvc`
- JSON Path Assertions
- HTTP Status Assertions
- Content Type Assertions

## Testing Patterns

- Unit Testing
- Service Layer Testing
- Controller Layer Testing
- Repository Layer Testing
- Integration-style Context Testing
- Arrange → Act → Assert
- Mocking
- Interaction Verification
- Exception Testing

---

# Learning Outcomes

After completing this project, you will understand:

- ✅ How to write JUnit 5 tests
- ✅ How to test business logic independently
- ✅ How to mock dependencies using Mockito
- ✅ How `@Mock` works
- ✅ How `@InjectMocks` works
- ✅ How to verify Mockito interactions
- ✅ How to test exceptions
- ✅ How to test Spring MVC controllers
- ✅ How to use `MockMvc`
- ✅ How to use `@WebMvcTest`
- ✅ How to test JPA repositories with `@DataJpaTest`
- ✅ How to test the Spring Boot application context
- ✅ How to structure tests using Arrange → Act → Assert

---

# Run Tests

Run all tests using Maven:

```bash
mvn test
```

Or using the Maven Wrapper:

### Windows

```bash
mvnw.cmd test
```

### Linux / macOS

```bash
./mvnw test
```

---

# Learning Objective

This project demonstrates how to test different layers of a Spring Boot application using **JUnit 5, Mockito, MockMvc, `@WebMvcTest`, `@DataJpaTest`, and `@SpringBootTest`**, while keeping unit tests isolated and verifying controller, service, repository, and application-context behavior.
