package com.example.storemanager.repository;

import com.example.storemanager.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer> {


    @Query("select p from Product p where p.name=:name")
    Optional<Product> findProductByName(@Param("name") String name);


    @Modifying
    @Query("update Product p " +
            "set p.price = :price " +
            "where p.name = :name")
    void updatePriceByName(int price, String name);

    @Modifying
    @Query("delete from Product p " +
            "where p.name = :name")
    void deleteProductByName(String name);

}
