package com.hackatonbb.graphql.customer;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.hackatonbb.entity.Customer;
import com.hackatonbb.repository.CustomerRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;

@Service
public class CustomerQueryResolver implements GraphQLQueryResolver {

    private final CustomerRepository customerRepository;

    public CustomerQueryResolver(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional(readOnly = true)
    @PreAuthorize("hasAuthority('CUSTOMER_READ_PRIVILEGE')")
    public Customer getCustomer(@NotNull Integer customerId) {
        return customerRepository.findById(customerId).orElseThrow(EntityNotFoundException::new);
    }
}
