package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements IProductService {
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone",9.5,"X","Apple" ));
        products.put(2, new Product(2, "Iphone 11",12.5,"11","Apple" ));
        products.put(3, new Product(3, "SamSung Note",9.5,"10","SamSung" ));
        products.put(4, new Product(4, "Nokia",5,"Black","Nokia" ));

    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);

    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = findAll();
        List<Product> products = new ArrayList<>();
        for(Product product: productList){
            if( product.getName().contains(name)){
                products.add(product);
            }
        }
        return products;
    }
}
