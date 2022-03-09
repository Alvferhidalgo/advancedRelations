package com.example.advancedRelations.repositories;

import com.example.advancedRelations.entities.Office;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeRepository extends JpaRepository<Office, Long> {
}
