package com.example.storemanager.repository;

import com.example.storemanager.entities.Client;
import com.example.storemanager.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Integer> {

    @Query("select c from Client c where c.name=:name")
    Optional<Client> findClientByName(@Param("name") String name);

    @Query("select c from Client c where c.id=:id")
    Optional<Client> findClientById(@Param("id") int id);

    @Modifying
    @Query("update Client c " +
            "set c.username = :username " +
            "where c.id = :id")
    void updateUsernameById(String username, int id);

    @Modifying
    @Query("delete from Client c " +
            "where c.id = :id")
    void deleteClientById(int id);
}
