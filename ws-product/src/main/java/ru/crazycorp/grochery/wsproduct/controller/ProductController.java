package ru.crazycorp.grochery.wsproduct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.crazycorp.grochery.wsproduct.entity.database.Product;
import ru.crazycorp.grochery.wsproduct.exception.ResourceNotFoundException;
import ru.crazycorp.grochery.wsproduct.repository.ProductRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    /**
     * http://localhost:9030/ws-product/product/
     * */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String sayHello(Model model){
        return "Hello from ws-product";
    }

    /**
     * http://localhost:9030/ws-product/product/getAllProducts
     * */
    @RequestMapping(value = "/getAllProducts", method = RequestMethod.GET)
    public List<Product> getAllProducts(Model model){
        return productRepository.findAll();
    }

    /**
     * http://localhost:9030/ws-product/product/getProductById?productId=5
     * */
    @RequestMapping(value = "/getProductById", method = RequestMethod.GET)
    public Product getProductById(Model model, @RequestParam("productId") Integer producId){
        Optional<Product> productOptional =  productRepository.findById(producId);
        if(productOptional.isPresent()){
            return productOptional.get();
        }
        throw new ResourceNotFoundException("Can't find product. ProductId:" + producId);
    }

    /**
     * http://localhost:9030/ws-product/product/addProduct
     * JSON: {"productName":"Киви"}
     *
     * */
    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public Product addProduct(@Valid @RequestBody Product product) {
        return productRepository.save(product);
    }
}
