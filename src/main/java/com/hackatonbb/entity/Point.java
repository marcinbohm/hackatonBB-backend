package com.hackatonbb.entity;


import org.springframework.boot.actuate.audit.listener.AuditListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "point")
@EntityListeners(AuditListener.class)
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "point_generator")
    @SequenceGenerator(name="point_generator", sequenceName = "point_point_id_seq", allocationSize=1)
    @Column(name = "point_id")
    private Integer pointId;

    @NotNull
    @Column(name = "customer_id")
    private Integer customerId;

    @NotNull
    @Column(name = "latitude")
    private Double latitude;

    @NotNull
    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "yearly_insolation_level_kwh_m2")
    private Double yearlyInsolationLevelKwhM2;

    @Column(name = "yearly_wind_speed_mph")
    private Double yearlyWindSpeedMph;

    @NotNull
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "customer_id",
            insertable = false,
            updatable = false
    )
    private Customer customer;

    public Integer getPointId() {
        return pointId;
    }

    public void setPointId(Integer pointId) {
        this.pointId = pointId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getYearlyInsolationLevelKwhM2() {
        return yearlyInsolationLevelKwhM2;
    }

    public void setYearlyInsolationLevelKwhM2(Double yearlyInsolationLevelKwhM2) {
        this.yearlyInsolationLevelKwhM2 = yearlyInsolationLevelKwhM2;
    }

    public Double getYearlyWindSpeedMph() {
        return yearlyWindSpeedMph;
    }

    public void setYearlyWindSpeedMph(Double yearlyWindSpeedMph) {
        this.yearlyWindSpeedMph = yearlyWindSpeedMph;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
