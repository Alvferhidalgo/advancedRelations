package com.example.advancedRelations.repositories;

import com.example.advancedRelations.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
