package ru.crazycorp.grochery.wsproduct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.crazycorp.grochery.wsproduct.entity.database.Product;
import ru.crazycorp.grochery.wsproduct.exception.ResourceNotFoundException;
import ru.crazycorp.grochery.wsproduct.repository.ProductRepository;
import ru.crazycorp.grochery.wsproduct.service.ProductService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

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
        return productService.getAllProducts();
    }

    /**
     * http://localhost:9030/ws-product/product/getProductById?productId=5
     * */
    @RequestMapping(value = "/getProductById", method = RequestMethod.GET)
    public Product getProductById(Model model, @RequestParam("productId") Integer producId){
        return productService.getProductById(producId);
    }

    /**
     * http://localhost:9030/ws-product/product/addProduct
     * JSON: {"productName":"Киви"}
     *
     * */
    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public Product addProduct(@Valid @RequestBody Product product) {
        return productService.addProduct(product);
    }
}
