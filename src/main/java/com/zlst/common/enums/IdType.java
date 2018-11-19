package com.zlst.common.enums;

/**
 * Created by 170096 on 2018/5/7
 */
public enum IdType {

    M("M", "成员Id"),
    T("T", "模板Id");

    private String code;
    private String value;

    IdType(String code, String value) {
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
        for (IdType type : IdType.values()) {
            if (type.getCode().equals(code)) {
                return type.getValue();
            }
        }
        return null;
    }

    public static String getCodeByValue(String value) {
        for (IdType type : IdType.values()) {
            if (type.getValue().equals(value)) {
                return type.getCode();
            }
        }
        return null;
    }

}
