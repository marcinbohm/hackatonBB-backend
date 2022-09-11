package com.hackatonbb.graphql.installation;

public class InstallationInput {
    private Integer installationId;

    private String installationType;

    private Double yieldGuarantee;

    private Double southDeviationRoofSlopeCorrection;

    private Double installationPowerKWP;

    private Double windSpeedMs;

    private Double windSurfaceSizeM2;

    private boolean installationTypeSetFromInput = false;

    private boolean yieldGuaranteeSetFromInput = false;

    private boolean southDeviationRoofSlopeCorrectionSetFromInput = false;

    private boolean installationPowerKWPSetFromInput = false;

    private boolean windSpeedMsSetFromInput = false;

    private boolean windSurfaceSizeM2SetFromInput = false;

    public Integer getInstallationId() {
        return installationId;
    }

    public void setInstallationId(Integer installationId) {
        this.installationId = installationId;
    }

    public String getInstallationType() {
        return installationType;
    }

    public void setInstallationType(String installationType) {
        this.installationType = installationType;
        this.installationTypeSetFromInput = true;
    }

    public Double getYieldGuarantee() {
        return yieldGuarantee;
    }

    public void setYieldGuarantee(Double yieldGuarantee) {
        this.yieldGuarantee = yieldGuarantee;
        this.yieldGuaranteeSetFromInput = true;
    }

    public Double getSouthDeviationRoofSlopeCorrection() {
        return southDeviationRoofSlopeCorrection;
    }

    public void setSouthDeviationRoofSlopeCorrection(Double southDeviationRoofSlopeCorrection) {
        this.southDeviationRoofSlopeCorrection = southDeviationRoofSlopeCorrection;
        this.southDeviationRoofSlopeCorrectionSetFromInput = true;
    }

    public Double getInstallationPowerKWP() {
        return installationPowerKWP;
    }

    public void setInstallationPowerKWP(Double installationPowerKWP) {
        this.installationPowerKWP = installationPowerKWP;
        this.installationPowerKWPSetFromInput = true;
    }

    public Double getWindSpeedMs() {
        return windSpeedMs;
    }

    public void setWindSpeedMs(Double windSpeedMs) {
        this.windSpeedMs = windSpeedMs;
        this.windSpeedMsSetFromInput = true;
    }

    public Double getWindSurfaceSizeM2() {
        return windSurfaceSizeM2;
    }

    public void setWindSurfaceSizeM2(Double windSurfaceSizeM2) {
        this.windSurfaceSizeM2 = windSurfaceSizeM2;
        this.windSurfaceSizeM2SetFromInput = true;
    }

    public boolean isInstallationTypeSetFromInput() {
        return installationTypeSetFromInput;
    }

    public boolean isYieldGuaranteeSetFromInput() {
        return yieldGuaranteeSetFromInput;
    }

    public boolean isSouthDeviationRoofSlopeCorrectionSetFromInput() {
        return southDeviationRoofSlopeCorrectionSetFromInput;
    }

    public boolean isInstallationPowerKWPSetFromInput() {
        return installationPowerKWPSetFromInput;
    }

    public boolean isWindSpeedMsSetFromInput() {
        return windSpeedMsSetFromInput;
    }

    public boolean isWindSurfaceSizeM2SetFromInput() {
        return windSurfaceSizeM2SetFromInput;
    }
}
