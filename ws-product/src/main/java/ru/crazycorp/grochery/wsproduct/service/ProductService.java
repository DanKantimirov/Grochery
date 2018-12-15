package ru.crazycorp.grochery.wsproduct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.crazycorp.grochery.wsproduct.entity.database.Product;
import ru.crazycorp.grochery.wsproduct.exception.ResourceNotFoundException;
import ru.crazycorp.grochery.wsproduct.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Integer producId) {

        Optional<Product> productOptional = productRepository.findById(producId);
        if (productOptional.isPresent()) {

            return productOptional.get();
        }
        throw new ResourceNotFoundException("Can't find product. ProductId:" + producId);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
}
