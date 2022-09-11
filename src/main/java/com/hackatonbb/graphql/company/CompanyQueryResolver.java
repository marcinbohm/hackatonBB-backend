package com.hackatonbb.graphql.company;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.hackatonbb.entity.Company;
import com.hackatonbb.repository.CompanyRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;

@Service
public class CompanyQueryResolver implements GraphQLQueryResolver {

    private final CompanyRepository companyRepository;

    public CompanyQueryResolver(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Transactional(readOnly = true)
    @PreAuthorize("hasAuthority('COMPANY_READ_PRIVILEGE')")
    public Company getCompany(@NotNull Integer companyId) {
        return companyRepository.findById(companyId).orElseThrow(EntityNotFoundException::new);
    }
}
