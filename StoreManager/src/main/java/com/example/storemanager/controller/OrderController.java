package com.example.storemanager.controller;

import com.example.storemanager.entities.Order;
import com.example.storemanager.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class OrderController {


    private final OrderService orderService;

    @PostMapping("/order")
    public void addOrder(@RequestBody Order order){
        orderService.addOrder(order);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Order> findOrderById(@PathVariable int id){

        var p = orderService.findOrderById(id);

        if(p.isPresent()){
            return ResponseEntity.of(p);
        }
        else{
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/order/{id}")
    public ResponseEntity<Void> updatePriceOrder(@RequestParam String costOverWeight, @PathVariable("id") int id) {
        try {
            orderService.updateOrderById(Integer.parseInt(costOverWeight), id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<Void> deleteOrderById(@PathVariable("id") int id) {
        try {
            orderService.deleteOrderById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
