package com.hackatonbb.graphql.customer;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.hackatonbb.OperationStatus;
import com.hackatonbb.dict.DictOperationName;
import com.hackatonbb.entity.Customer;
import com.hackatonbb.mapper.SmartMapper;
import com.hackatonbb.repository.CustomerRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;

@Service
public class CustomerMutationResolver implements GraphQLMutationResolver {

    private final CustomerRepository customerRepository;

    public CustomerMutationResolver(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    @PreAuthorize("hasAuthority('CUSTOMER_ADD_PRIVILEGE')")
    public OperationStatus addCustomer(CustomerInput customerInput) {
        return saveCustomer(null, customerInput);
    }

    @Transactional
    @PreAuthorize("hasAuthority('CUSTOMER_MODIFY_PRIVILEGE')")
    public OperationStatus updateCustomer(@NotNull Integer customerInputId, CustomerInput customerInput) {
        return saveCustomer(customerInputId, customerInput);
    }

    @Transactional
    @PreAuthorize("hasAuthority('CUSTOMER_DELETE_PRIVILEGE')")
    public OperationStatus deleteCustomer(@NotNull Integer customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(EntityNotFoundException::new);

        OperationStatus opStatus = new OperationStatus(Customer.class.getSimpleName(), DictOperationName.DELETE.getCode());
        opStatus.setRecordId(customerId);

        customerRepository.delete(customer);

        return opStatus.setSuccess(!customerRepository.existsById(customerId));
    }

    protected OperationStatus saveCustomer(Integer customerId, CustomerInput customerInput) {
        boolean adding = (customerId == null);
        Customer customer = (adding ? new Customer() : customerRepository.findById(customerId).orElseThrow(EntityNotFoundException::new));

        OperationStatus opStatus = new OperationStatus(Customer.class.getSimpleName(), adding ? DictOperationName.ADD.getCode() : DictOperationName.UPDATE.getCode());

        SmartMapper.transferData(customerInput, customer);

        Customer customerSaved = customerRepository.save(customer);
        Integer id = customerSaved.getCustomerId();
        opStatus.setRecordId(id).setSuccess(id != null);
        return opStatus;
    }
}
