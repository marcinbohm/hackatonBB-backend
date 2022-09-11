package com.hackatonbb.graphql.point;

public class PointInput {

    private Integer pointId;

    private Integer customerId;

    private Double latitude;

    private Double longitude;

    private Double yearlyInsolationLevelKwhM2;

    private Double yearlyWindSpeedMph;

    private boolean customerIdSetFromInput = false;

    private boolean latitudeSetFromInput = false;

    private boolean longitudeSetFromInput = false;

    private boolean yearlyInsolationLevelKwhM2SetFromInput = false;

    private boolean yearlyWindSpeedMphSetFromInput = false;

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
        this.customerIdSetFromInput = true;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
        this.latitudeSetFromInput = true;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
        this.longitudeSetFromInput = true;
    }

    public Double getYearlyInsolationLevelKwhM2() {
        return yearlyInsolationLevelKwhM2;
    }

    public void setYearlyInsolationLevelKwhM2(Double yearlyInsolationLevelKwhM2) {
        this.yearlyInsolationLevelKwhM2 = yearlyInsolationLevelKwhM2;
        this.yearlyInsolationLevelKwhM2SetFromInput = true;
    }

    public Double getYearlyWindSpeedMph() {
        return yearlyWindSpeedMph;
    }

    public void setYearlyWindSpeedMph(Double yearlyWindSpeedMph) {
        this.yearlyWindSpeedMph = yearlyWindSpeedMph;
        this.yearlyWindSpeedMphSetFromInput = true;
    }

    public boolean isCustomerIdSetFromInput() {
        return customerIdSetFromInput;
    }

    public boolean isLatitudeSetFromInput() {
        return latitudeSetFromInput;
    }

    public boolean isLongitudeSetFromInput() {
        return longitudeSetFromInput;
    }

    public boolean isYearlyInsolationLevelKwhM2SetFromInput() {
        return yearlyInsolationLevelKwhM2SetFromInput;
    }

    public boolean isYearlyWindSpeedMphSetFromInput() {
        return yearlyWindSpeedMphSetFromInput;
    }
}
