package com.example.advancedRelations.repositories;

import com.example.advancedRelations.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AccountRepository extends JpaRepository<Account, Long>, JpaSpecificationExecutor<Account> {

}
