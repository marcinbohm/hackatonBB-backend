package com.hackatonbb.graphql.company;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.hackatonbb.OperationStatus;
import com.hackatonbb.dict.DictOperationName;
import com.hackatonbb.entity.Company;
import com.hackatonbb.mapper.SmartMapper;
import com.hackatonbb.repository.CompanyRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;

@Service
public class CompanyMutationResolver implements GraphQLMutationResolver {

    private final CompanyRepository companyRepository;

    public CompanyMutationResolver(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Transactional
    @PreAuthorize("hasAuthority('COMPANY_ADD_PRIVILEGE')")
    public OperationStatus addCompany(CompanyInput companyInput) {
        return saveCompany(null, companyInput);
    }

    @Transactional
    @PreAuthorize("hasAuthority('COMPANY_MODIFY_PRIVILEGE')")
    public OperationStatus updateCompany(@NotNull Integer companyInputId, CompanyInput companyInput) {
        return saveCompany(companyInputId, companyInput);
    }

    @Transactional
    @PreAuthorize("hasAuthority('COMPANY_DELETE_PRIVILEGE')")
    public OperationStatus deleteCompany(@NotNull Integer companyId) {
        Company company = companyRepository.findById(companyId).orElseThrow(EntityNotFoundException::new);

        OperationStatus opStatus = new OperationStatus(Company.class.getSimpleName(), DictOperationName.DELETE.getCode());
        opStatus.setRecordId(companyId);

        companyRepository.delete(company);

        return opStatus.setSuccess(!companyRepository.existsById(companyId));
    }

    protected OperationStatus saveCompany(Integer companyId, CompanyInput companyInput) {
        boolean adding = (companyId == null);
        Company company = (adding ? new Company() : companyRepository.findById(companyId).orElseThrow(EntityNotFoundException::new));

        OperationStatus opStatus = new OperationStatus(Company.class.getSimpleName(), adding ? DictOperationName.ADD.getCode() : DictOperationName.UPDATE.getCode());

        SmartMapper.transferData(companyInput, company);

        Company companySaved = companyRepository.save(company);
        Integer id = companySaved.getCompanyId();
        opStatus.setRecordId(id).setSuccess(id != null);
        return opStatus;
    }
}
