package com.hackatonbb.graphql.customer;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class CustomerInput {

    private Integer customerId;

    private Integer companyId;

    private String firstname;

    private String lastname;

    private boolean companyIdSetFromInput = false;

    private boolean firstnameSetFromInput = false;

    private boolean lastnameSetFromInput = false;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
        this.companyIdSetFromInput = true;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
        this.firstnameSetFromInput = true;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
        this.lastnameSetFromInput = true;
    }

    public boolean isCompanyIdSetFromInput() {
        return companyIdSetFromInput;
    }

    public boolean isFirstnameSetFromInput() {
        return firstnameSetFromInput;
    }

    public boolean isLastnameSetFromInput() {
        return lastnameSetFromInput;
    }
}
