package com.example.advancedRelations.service;

import com.example.advancedRelations.entities.Benefit;
import com.example.advancedRelations.entities.Benefit_;
import com.example.advancedRelations.repositories.BenefitRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenefitSpecService {

   private final BenefitRepository benefitRepository;

    public BenefitSpecService(com.example.advancedRelations.repositories.BenefitRepository benefitRepository) {
        this.benefitRepository = benefitRepository;
    }

    public List<Benefit> findAllByIdIn(List<Long> ids){
        Specification<Benefit> spec = (root, query, criteriaBuilder) ->
                criteriaBuilder.in(root.get(Benefit_.ID)).value(ids);

        return this.benefitRepository.findAll(spec);
    }
}
