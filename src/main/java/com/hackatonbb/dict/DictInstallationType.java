package com.hackatonbb.dict;

public enum DictInstallationType {

    SOLAR_PANEL("SOLAR_PANEL"),
    WINDMILL("WINDMILL");

    private final String code;

    private DictInstallationType(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
