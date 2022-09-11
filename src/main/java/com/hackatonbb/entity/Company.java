package com.hackatonbb.entity;

import org.springframework.boot.actuate.audit.listener.AuditListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
@EntityListeners(AuditListener.class)
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_generator")
    @SequenceGenerator(name="company_generator", sequenceName = "company_company_id_seq", allocationSize=1)
    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "nazwa")
    private String nazwa;

    @Column(name = "skrot")
    private String skrot;

    @Column(name = "kod_pocztowy")
    private String kodPocztowy;

    @Column(name = "miejscowosc")
    private String miejscowosc;

    @Column(name = "ulica")
    private String ulica;

    @Column(name = "nr_domu")
    private String nrDomu;

    @Column(name = "nr_lokalu")
    private String nrLokalu;

    @Column(name = "nr_konta")
    private String nrKonta;

    @Column(name = "regon")
    private String regon;

    @Column(name = "nip")
    private String nip;

    @Column(name = "telefon")
    private String telefon;

    @Column(name = "uwagi")
    private String uwagi;

    @Column(name = "service_radius_in_km")
    private Integer serviceRadiusInKm;

    @Column(name = "address_longitude")
    private Double addressLongitude;

    @Column(name = "address_latitude")
    private Double addressLatitude;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<User> companyUsersList;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getSkrot() {
        return skrot;
    }

    public void setSkrot(String skrot) {
        this.skrot = skrot;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNrDomu() {
        return nrDomu;
    }

    public void setNrDomu(String nrDomu) {
        this.nrDomu = nrDomu;
    }

    public String getNrLokalu() {
        return nrLokalu;
    }

    public void setNrLokalu(String nrLokalu) {
        this.nrLokalu = nrLokalu;
    }

    public String getNrKonta() {
        return nrKonta;
    }

    public void setNrKonta(String nrKonta) {
        this.nrKonta = nrKonta;
    }

    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getUwagi() {
        return uwagi;
    }

    public void setUwagi(String uwagi) {
        this.uwagi = uwagi;
    }

    public Integer getServiceRadiusInKm() {
        return serviceRadiusInKm;
    }

    public void setServiceRadiusInKm(Integer serviceRadiusInKm) {
        this.serviceRadiusInKm = serviceRadiusInKm;
    }

    public Double getAddressLongitude() {
        return addressLongitude;
    }

    public void setAddressLongitude(Double addressLongitude) {
        this.addressLongitude = addressLongitude;
    }

    public Double getAddressLatitude() {
        return addressLatitude;
    }

    public void setAddressLatitude(Double addressLatitude) {
        this.addressLatitude = addressLatitude;
    }

    public List<User> getCompanyUsersList() {
        return companyUsersList;
    }

    public void setCompanyUsersList(List<User> companyUsersList) {
        this.companyUsersList = companyUsersList;
    }
}
