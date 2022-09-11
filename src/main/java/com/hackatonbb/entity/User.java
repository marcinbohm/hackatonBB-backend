package com.hackatonbb.entity;

import org.springframework.boot.actuate.audit.listener.AuditListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user", schema = "public")
@EntityListeners(AuditListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name="user_generator", sequenceName = "user_user_id_seq", allocationSize=1)
    @Column(name = "user_id")
    private Integer userId;

    @NotNull
    @Column(name = "company_id")
    private Integer companyId;

    @NotNull
    @Column(name = "firstname")
    private String firstname;

    @NotNull
    @Column(name = "lastname")
    private String lastname;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "login")
    private String login;

    @NotNull
    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "blocked")
    private Boolean blocked;

    @Column(name = "expire_account_date")
    private LocalDate expireAccountDate;

    @Column(name = "expire_password_date")
    private LocalDate expirePasswordDate;

    @Column(name = "last_login_time")
    private LocalDateTime lastLoginTime;

    @NotNull
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "company_id",
            insertable = false,
            updatable = false
    )
    private Company company;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_class",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "class_id") }
    )
    private Set<Class> jednostkaProceduraSet;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Session> userSessionsList;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public LocalDate getExpireAccountDate() {
        return expireAccountDate;
    }

    public void setExpireAccountDate(LocalDate expireAccountDate) {
        this.expireAccountDate = expireAccountDate;
    }

    public LocalDate getExpirePasswordDate() {
        return expirePasswordDate;
    }

    public void setExpirePasswordDate(LocalDate expirePasswordDate) {
        this.expirePasswordDate = expirePasswordDate;
    }

    public LocalDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Set<Class> getJednostkaProceduraSet() {
        return jednostkaProceduraSet;
    }

    public void setJednostkaProceduraSet(Set<Class> jednostkaProceduraSet) {
        this.jednostkaProceduraSet = jednostkaProceduraSet;
    }

    public List<Session> getUserSessionsList() {
        return userSessionsList;
    }

    public void setUserSessionsList(List<Session> userSessionsList) {
        this.userSessionsList = userSessionsList;
    }
}
