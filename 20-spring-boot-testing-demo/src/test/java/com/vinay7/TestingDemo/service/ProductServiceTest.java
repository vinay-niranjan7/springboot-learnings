package com.vinay7.TestingDemo.service;

import com.vinay7.TestingDemo.entity.Product;
import com.vinay7.TestingDemo.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void shouldReturnProductIfExists() {
        // Arrange
        Product product =
                new Product(1L, "Laptop", 50000, 10);

        when(productRepository.findById(1L))
                .thenReturn(Optional.of(product));

        // Act
        Product actualResult = productService.getProductById(1L);

        // Assert
        assertEquals(1L, actualResult.getId());
        assertEquals("Laptop", actualResult.getName());

        verify(productRepository).findById(1L);
    }

    @Test
    void shouldThrowExceptionWhenProductDoesNotExist() {
        //Arrange
        when(productRepository.findById(100L))
                .thenReturn(Optional.empty());

        //Act
        RuntimeException exception =
                assertThrows(RuntimeException.class, () ->
                        productService.getProductById(100L)
                );


        // assertion
        assertEquals("Product not found: 100",
                exception.getMessage());

        verify(productRepository).findById(100L);
    }

    @Test
    void shouldCreateProductWhenNameIsUnique() {
        // Arrange
        Product request =
                new Product(null, "Phone", 20000, 5);

        Product savedProduct =
                new Product(5L, "Phone", 20000, 5);

        when(productRepository.existsByName("Phone"))
                .thenReturn(false);

        when(productRepository.save(request))
                .thenReturn(savedProduct);

        // Act
        Product result =
                productService.createProduct(request);

        // Assert
        assertEquals(5L, result.getId());
        assertEquals("Phone", result.getName());

        verify(productRepository)
                .existsByName("Phone");

        verify(productRepository)
                .save(request);
    }

    @Test
    void shouldRejectProductWhenAlreadyExists() {

        // Arrange
        Product request =
                new Product(null, "Phone", 200, 5);

        when(productRepository.existsByName("Phone"))
                .thenReturn(true);

        // Act and Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> productService.createProduct(request)
        );

        verify(productRepository)
                .existsByName("Phone");

        verify(productRepository, never())
                .save(any(Product.class));
    }
}