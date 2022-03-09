package com.example.advancedRelations.service;

import com.example.advancedRelations.entities.Account;
import com.example.advancedRelations.entities.Account_;
import com.example.advancedRelations.repositories.AccountRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AccountSpecService {

    private final AccountRepository accountRepository;

    public AccountSpecService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> findAllByIdIn(List<Long> ids){
        Specification<Account> spec = (root, query, criteriaBuilder) ->
                criteriaBuilder.in(root.get(Account_.ID)).value(ids);

        return this.accountRepository.findAll(spec);
    }
}
