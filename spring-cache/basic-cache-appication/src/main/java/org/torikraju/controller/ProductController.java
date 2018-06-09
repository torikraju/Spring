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


    @GetMapping("product/{id}")
    public Product getProduct(@PathVariable("id") String id) {
        LOGGER.info("getProduct called for id {}", id);
        return productService.getProduct(id);
    }

    @PostMapping("product/{id}")
    public Product updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        LOGGER.info("updateProduct called for id {}", id);
        product.setId(id);
        productService.updateProduct(product);
        return productService.getProduct(id);
    }

}
