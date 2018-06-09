package org.torikraju.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.torikraju.domain.Product;

@Service("productService")
//@CacheConfig(cacheNames = "product")
public class ProductServiceImpl implements ProductService {


    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    @Override
    @Cacheable("product")
    public Product getByName(String name) {
        Product product = new Product(name, 100);
        LOGGER.info(name + " -> " + product);
        slowLookupOperation();
        return product;
    }


    private void slowLookupOperation() {
        try {
            long time = 2000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    @CacheEvict(cacheNames = "product", allEntries = true)
    public void updateProduct(Product product) {
        LOGGER.info("updateProduct called for name {}", product.getName());
        //do nothing, we just simulate the update
    }

}
