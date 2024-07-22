package com.josiasdasilva.agiletestrestfulapi;

import com.josiasdasilva.agiletestrestfulapi.entities.Product;
import com.josiasdasilva.agiletestrestfulapi.repositories.ProductRepository;
import com.josiasdasilva.agiletestrestfulapi.services.ProductServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void GetProductByIdSuccess() {
        // Configuration
        Long id = 1L;
        Product expectedProduct = new Product();
        expectedProduct.setId(id);
        expectedProduct.setName("Xbox Series X");
        expectedProduct.setDescription("Xbox Series X Game Console");
        expectedProduct.setPrice(399.00);

        when(productService.findById(id)).thenReturn(Optional.of(expectedProduct));

        Optional<Product> foundedProduct = productService.findById(id);
        assertTrue(foundedProduct.isPresent());
        assertEquals(expectedProduct.getId(), foundedProduct.get().getId());
        verify(productRepository, times(1));

    }

    @Test
    public void newProductTest(){
        Product newProduct = new Product();
        newProduct.setId(1L);
        newProduct.setName("Xbox Series X");
        newProduct.setDescription("Xbox Series X Game Console");
        newProduct.setPrice(399.99);

        Product savedProduct = new Product();
        savedProduct.setId(1L);
        savedProduct.setName("Xbox Series X");
        savedProduct.setDescription("Xbox Series X Game Console");
        savedProduct.setPrice(399.99);

        when(productService.save(any(Product.class))).thenReturn(savedProduct);
        Product result = productService.save(newProduct);
        assertNotNull(result);
        assertEquals(Long.valueOf(1L), result.getId());
        assertEquals("Xbox Series X", result.getName());

    }

    @Test
    public void updateProductTest(){
        Long id = 1L;
        Product newProduct = new Product();
        newProduct.setId(id);
        newProduct.setName("Xbox Series X");
        newProduct.setDescription("Xbox Series X Game Console");
        newProduct.setPrice(399.99);

        Product updateProduct = new Product();
        updateProduct.setId(id);
        updateProduct.setName("PlayStation 5");
        updateProduct.setDescription("PlayStation 5 Game Console");
        updateProduct.setPrice(499.99);

        when(productService.findById(id)).thenReturn(Optional.of(newProduct));
        when(productService.save(updateProduct)).thenReturn(updateProduct);

        Optional<Product> result = productService.findById(id);
        assertTrue(result.isPresent());

        Product savedProduct = productService.save(updateProduct);
        assertEquals(updateProduct.getId(), savedProduct.getId());
        assertEquals(updateProduct.getName(), savedProduct.getName());
        assertEquals(updateProduct.getDescription(), savedProduct.getDescription());
        assertEquals(updateProduct.getPrice(), savedProduct.getPrice());

        verify(productRepository, times(1));

    }

    @Test
    public void deleteProductTest(){

        Long id = 1L;
        Product newProduct = new Product();
        newProduct.setId(id);
        newProduct.setName("Xbox Series X");
        newProduct.setDescription("Xbox Series X Game Console");
        newProduct.setPrice(399.99);

        productService.delete(id);
        verify(productRepository, times(1));
    }

}
