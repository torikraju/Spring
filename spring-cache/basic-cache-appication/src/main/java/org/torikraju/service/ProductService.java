package org.torikraju.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.torikraju.domain.Product;

@Service
public class ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    @Cacheable("product")
    public Product getProduct(String id) {
        LOGGER.info("getProduct called for id {}", id);
        return new Product(id, "The Angry Beavers: The Complete Series");
    }

    @CacheEvict(cacheNames = "product"/*, key = "#root.args[0].id"*/, allEntries = true)
    public void updateProduct(Product product) {
        LOGGER.info("updateProduct called for id {}", product.getId());
        //do nothing, we just simulate the update
    }


}
