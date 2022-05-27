package com.example.storemanager.controller;

import com.example.storemanager.entities.Product;
import com.example.storemanager.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/product")
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    @GetMapping("/products")
    public List<Product> findProducts(){

        return productService.findProducts();
    }

    @GetMapping("/product/{name}")
    public ResponseEntity<Product> findProductByName(@PathVariable String name){

        var p = productService.findProductByName(name);

        if(p.isPresent()){
            return ResponseEntity.of(p);
        }
        else{
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/product/{name}")
    public ResponseEntity<Void> updatePriceByName(@RequestParam String price, @PathVariable("name") String name) {
        try {
            productService.updatePriceByName(Integer.parseInt(price), name);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/product/{name}")
    public ResponseEntity<Void> deleteProductByName(@PathVariable("name") String name) {
        try {
            productService.deleteProductByName(name);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
