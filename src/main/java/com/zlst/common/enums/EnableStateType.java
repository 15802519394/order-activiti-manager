package com.zlst.common.enums;

/**
 * Created by 170285 on 2018/11/7
 */
public enum EnableStateType {

    CLOSE("X", "禁用"),
    OPEN("A", "启用");

    private String code;
    private String value;

    EnableStateType(String code, String value) {
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
        for (EnableStateType type : EnableStateType.values()) {
            if (type.getCode().equals(code)) {
                return type.getValue();
            }
        }
        return null;
    }

    public static String getCodeByValue(String value) {
        for (EnableStateType type : EnableStateType.values()) {
            if (type.getValue().equals(value)) {
                return type.getCode();
            }
        }
        return null;
    }

}
