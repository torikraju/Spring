package org.torikraju.service;

import org.torikraju.domain.Product;

public interface ProductService {

    Product getByName(String name);

    void updateProduct(Product product);

}
