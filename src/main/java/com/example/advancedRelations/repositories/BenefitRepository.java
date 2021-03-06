package com.example.advancedRelations.repositories;

import com.example.advancedRelations.entities.Benefit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BenefitRepository extends JpaRepository<Benefit, Long>, JpaSpecificationExecutor<Benefit> {
}
