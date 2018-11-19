package com.zlst.common.enums;

public enum ModularEnum {

    WMS("WMS", "仓储"),
    OMS("OMS", "OMS的名字"),
    RSM("RSM", "RSM的名字"),
    BDM("BDM", "BDM的名字"),
    MWM("MWM", "MWM的名字"),
    DDM("DDM", "DDM的名字");

    private String code;

    private String value;

    ModularEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public static String getValueByCode(String code) {
        for (ModularEnum key : ModularEnum.values()) {
            if (key.getCode().equals(code)) {
                return key.getValue();
            }
        }
        return null;
    }
}
