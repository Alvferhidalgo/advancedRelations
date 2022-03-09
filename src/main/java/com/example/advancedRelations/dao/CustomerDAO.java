package com.example.advancedRelations.dao;

import com.example.advancedRelations.entities.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Customer> findAll(){
        String jpql = "select c from Customer c";
        return this.entityManager.createQuery(jpql, Customer.class).getResultList();
    }

    public Optional<Customer> findById(Long id){
        Customer customer = this.entityManager.find(Customer.class, id);
        return Optional.ofNullable(customer);
    }
}
