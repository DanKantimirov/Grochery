package ru.crazycorp.grochery.wsproduct.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import ru.crazycorp.grochery.wsproduct.entity.database.Product;
import ru.crazycorp.grochery.wsproduct.repository.ProductRepository;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    @Test
    public void getProductById() {

        Product testProduct = new Product();
        testProduct.setProductId(777);
        testProduct.setProductName("TestPoduct");
        when(productRepository.findById(1)).thenReturn(Optional.of(testProduct));
        Product product = productService.getProductById(1);
        assertEquals(testProduct.getProductId(), product.getProductId());
        assertEquals(testProduct.getProductName(), product.getProductName());
    }
}