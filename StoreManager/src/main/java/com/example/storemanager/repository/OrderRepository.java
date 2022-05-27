package com.example.storemanager.repository;

import com.example.storemanager.entities.Client;
import com.example.storemanager.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Integer> {


    @Query("select o from Order o where o.id=:id")
    Optional<Order> findOrderById(@Param("id") int id);

    @Modifying
    @Query("update Order o " +
            "set o.costOverWeight = :costOverWeight " +
            "where o.id = :id")
    void updateOrderById(double costOverweight, int id);

    @Modifying
    @Query("delete from Order o " +
            "where o.id = :id")
    void deleteOrderById(int id);
}
