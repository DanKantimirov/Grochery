package ru.crazycorp.grochery.wsproduct.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import ru.crazycorp.grochery.wsproduct.entity.database.Product;
import ru.crazycorp.grochery.wsproduct.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
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

    @Test
    public void getAllProducts() {

        Product testProduct1 = new Product();
        testProduct1.setProductId(1);
        testProduct1.setProductName("TestProduct1");

        Product testProduct2 = new Product();
        testProduct2.setProductId(2);
        testProduct2.setProductName("TestProduct2");

        List<Product> testProductList = new ArrayList<>();
        testProductList.add(testProduct1);
        testProductList.add(testProduct2);

        when(productRepository.findAll()).thenReturn(testProductList);

        List<Product> productList = productService.getAllProducts();
        assertArrayEquals(testProductList.toArray(), productList.toArray());
    }

    @Test
    public void addProduct() {
        Product testProduct = new Product();
        testProduct.setProductId(777);
        testProduct.setProductName("TestPoduct");
        when(productRepository.save(testProduct)).thenReturn(testProduct);
        Product product = productService.addProduct(testProduct);
        assertEquals(testProduct.getProductId(), product.getProductId());
        assertEquals(testProduct.getProductName(), product.getProductName());
    }
}