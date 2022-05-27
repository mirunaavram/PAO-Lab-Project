package com.example.storemanager.service;

import com.example.storemanager.entities.Product;
import com.example.storemanager.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {


    private final ProductRepository productRepository;

    public void addProduct(Product product){

        productRepository.save(product);
    }

    public List<Product> findProducts(){

        return productRepository.findAll();
    }

    public Optional<Product> findProductByName(String name) {
        return productRepository.findProductByName(name);
    }

    public void updatePriceByName(int price, String name) throws NoSuchElementException {
        var product = findProductByName(name);

        if (product.isPresent()) {
            productRepository.updatePriceByName(price, name);
        } else {
            throw new NoSuchElementException();
        }
    }

    public void deleteProductByName(String name) throws NoSuchElementException {
        var product = findProductByName(name);

        if (product.isPresent()) {
            productRepository.deleteProductByName(name);
        } else {
            throw new NoSuchElementException();
        }
    }
}
