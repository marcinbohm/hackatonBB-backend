package com.hackatonbb.entity;

import org.springframework.boot.actuate.audit.listener.AuditListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "installation")
@EntityListeners(AuditListener.class)
public class Installation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "installation_generator")
    @SequenceGenerator(name="installation_generator", sequenceName = "installation_installation_id_seq", allocationSize=1)
    @Column(name = "installation_id")
    private Integer installationId;

    @NotNull
    @Column(name = "product_id")
    private Integer productId;

    @NotNull
    @Column(name = "product_quantity")
    private Integer productQuantity;

    @NotNull
    @Column(name = "installation_type")
    private String installationType;

    @Column(name = "yield_guarantee")
    private Double yieldGuarantee;

    @Column(name = "south_deviation_roof_slope_correction")
    private Double southDeviationRoofSlopeCorrection;

    @Column(name = "installation_power_kwp")
    private Double installationPowerKWP;

    @Column(name = "wind_speed_ms")
    private Double windSpeedMs;

    @Column(name = "wind_surface_size_m2")
    private Double windSurfaceSizeM2;

    public Integer getInstallationId() {
        return installationId;
    }

    public void setInstallationId(Integer installationId) {
        this.installationId = installationId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getInstallationType() {
        return installationType;
    }

    public void setInstallationType(String installationType) {
        this.installationType = installationType;
    }

    public Double getYieldGuarantee() {
        return yieldGuarantee;
    }

    public void setYieldGuarantee(Double yieldGuarantee) {
        this.yieldGuarantee = yieldGuarantee;
    }

    public Double getSouthDeviationRoofSlopeCorrection() {
        return southDeviationRoofSlopeCorrection;
    }

    public void setSouthDeviationRoofSlopeCorrection(Double southDeviationRoofSlopeCorrection) {
        this.southDeviationRoofSlopeCorrection = southDeviationRoofSlopeCorrection;
    }

    public Double getInstallationPowerKWP() {
        return installationPowerKWP;
    }

    public void setInstallationPowerKWP(Double installationPowerKWP) {
        this.installationPowerKWP = installationPowerKWP;
    }

    public Double getWindSpeedMs() {
        return windSpeedMs;
    }

    public void setWindSpeedMs(Double windSpeedMs) {
        this.windSpeedMs = windSpeedMs;
    }

    public Double getWindSurfaceSizeM2() {
        return windSurfaceSizeM2;
    }

    public void setWindSurfaceSizeM2(Double windSurfaceSizeM2) {
        this.windSurfaceSizeM2 = windSurfaceSizeM2;
    }
}
