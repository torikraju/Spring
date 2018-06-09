package org.torikraju.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.torikraju.domain.Product;
import org.torikraju.service.ProductService;

@RestController
public class ProductController {


    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;


    @GetMapping("product/{name}")
    public Product getProduct(@PathVariable("name") String name) {
        Product product = productService.getByName(name);
        LOGGER.info(name + " -> " + product);
        return product;
    }

    @PostMapping("product/{id}")
    public Product updateProduct(@PathVariable("id") String name, @RequestBody Product product) {
        LOGGER.info("updateProduct called for name {}", name);
        product.setName(name);
        productService.updateProduct(product);
        return productService.getByName(name);
    }

}
