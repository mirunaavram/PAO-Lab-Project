package com.example.storemanager.service;

import com.example.storemanager.entities.Client;
import com.example.storemanager.entities.Order;
import com.example.storemanager.repository.ClientRepository;
import com.example.storemanager.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void addOrder(Order order){
        orderRepository.save(order);

    }

    public List<Order> findOrder(){
        return orderRepository.findAll();
    }

    public Optional<Order> findOrderById(int id){
        return orderRepository.findOrderById(id);
    }

    public void updateOrderById(double costOverweight, int id) throws NoSuchElementException {
        var order = findOrderById(id);

        if (order.isPresent()) {
            orderRepository.updateOrderById(costOverweight, id);
        } else {
            throw new NoSuchElementException();
        }
    }

    public void deleteOrderById(int id) throws NoSuchElementException {
        var order = findOrderById(id);

        if (order.isPresent()) {
            orderRepository.deleteOrderById(id);
        } else {
            throw new NoSuchElementException();
        }
    }
}
