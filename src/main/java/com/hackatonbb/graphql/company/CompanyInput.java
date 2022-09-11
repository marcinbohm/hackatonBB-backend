package com.hackatonbb.graphql.company;

public class CompanyInput {

    private Integer companyId;

    private String nazwa;

    private String skrot;

    private String kodPocztowy;

    private String miejscowosc;

    private String ulica;

    private String nrDomu;

    private String nrLokalu;

    private String nrKonta;

    private String regon;

    private String nip;

    private String telefon;

    private String uwagi;

    private Integer serviceRadiusInKm;

    private Double adressLongitude;

    private Double addressLatitude;

    private boolean nazwaSetFromInput = false;

    private boolean skrotSetFromInput = false;

    private boolean kodPocztowySetFromInput = false;

    private boolean miejscowoscSetFromInput = false;

    private boolean ulicaSetFromInput = false;

    private boolean nrDomuSetFromInput = false;

    private boolean nrLokaluSetFromInput = false;

    private boolean nrKontaSetFromInput = false;

    private boolean regonSetFromInput = false;

    private boolean nipSetFromInput = false;

    private boolean telefonSetFromInput = false;

    private boolean uwagiSetFromInput = false;

    private boolean serviceRadiusInKmSetFromInput = false;

    private boolean adressLongitudeSetFromInput = false;

    private boolean addressLatitudeSetFromInput = false;

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
        this.nazwaSetFromInput = true;
    }

    public String getSkrot() {
        return skrot;
    }

    public void setSkrot(String skrot) {
        this.skrot = skrot;
        this.skrotSetFromInput = true;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
        this.kodPocztowySetFromInput = true;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
        this.miejscowoscSetFromInput = true;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
        this.ulicaSetFromInput = true;
    }

    public String getNrDomu() {
        return nrDomu;
    }

    public void setNrDomu(String nrDomu) {
        this.nrDomu = nrDomu;
        this.nrDomuSetFromInput = true;
    }

    public String getNrLokalu() {
        return nrLokalu;
    }

    public void setNrLokalu(String nrLokalu) {
        this.nrLokalu = nrLokalu;
        this.nrLokaluSetFromInput = true;
    }

    public String getNrKonta() {
        return nrKonta;
    }

    public void setNrKonta(String nrKonta) {
        this.nrKonta = nrKonta;
        this.nrKontaSetFromInput = true;
    }

    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
        this.regonSetFromInput = true;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
        this.nipSetFromInput = true;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
        this.telefonSetFromInput = true;
    }

    public String getUwagi() {
        return uwagi;
    }

    public void setUwagi(String uwagi) {
        this.uwagi = uwagi;
        this.uwagiSetFromInput = true;
    }

    public Integer getServiceRadiusInKm() {
        return serviceRadiusInKm;
    }

    public void setServiceRadiusInKm(Integer serviceRadiusInKm) {
        this.serviceRadiusInKm = serviceRadiusInKm;
        this.serviceRadiusInKmSetFromInput = true;
    }

    public Double getAdressLongitude() {
        return adressLongitude;
    }

    public void setAdressLongitude(Double adressLongitude) {
        this.adressLongitude = adressLongitude;
        this.adressLongitudeSetFromInput = true;
    }

    public Double getAddressLatitude() {
        return addressLatitude;
    }

    public void setAddressLatitude(Double addressLatitude) {
        this.addressLatitude = addressLatitude;
        this.addressLatitudeSetFromInput = true;
    }

    public boolean isNazwaSetFromInput() {
        return nazwaSetFromInput;
    }

    public boolean isSkrotSetFromInput() {
        return skrotSetFromInput;
    }

    public boolean isKodPocztowySetFromInput() {
        return kodPocztowySetFromInput;
    }

    public boolean isMiejscowoscSetFromInput() {
        return miejscowoscSetFromInput;
    }

    public boolean isUlicaSetFromInput() {
        return ulicaSetFromInput;
    }

    public boolean isNrDomuSetFromInput() {
        return nrDomuSetFromInput;
    }

    public boolean isNrLokaluSetFromInput() {
        return nrLokaluSetFromInput;
    }

    public boolean isNrKontaSetFromInput() {
        return nrKontaSetFromInput;
    }

    public boolean isRegonSetFromInput() {
        return regonSetFromInput;
    }

    public boolean isNipSetFromInput() {
        return nipSetFromInput;
    }

    public boolean isTelefonSetFromInput() {
        return telefonSetFromInput;
    }

    public boolean isUwagiSetFromInput() {
        return uwagiSetFromInput;
    }

    public boolean isServiceRadiusInKmSetFromInput() {
        return serviceRadiusInKmSetFromInput;
    }

    public boolean isAdressLongitudeSetFromInput() {
        return adressLongitudeSetFromInput;
    }

    public boolean isAddressLatitudeSetFromInput() {
        return addressLatitudeSetFromInput;
    }
}
