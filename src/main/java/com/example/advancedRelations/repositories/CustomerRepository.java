package com.example.advancedRelations.repositories;

import com.example.advancedRelations.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "select c from Customer c join fetch c.address where c.id = :id")
    Customer findByIdWithAddressJQPL(Long id);
}
