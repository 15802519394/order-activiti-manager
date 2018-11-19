package com.zlst.common.enums;

/**
 * Created by 170096 on 2018/5/7
 */
public enum NamingItemType {

    CONSTANT("1", "常量"),
    ATTRIBUTE("2", "资源属性"),
    FUNCTION("4", "自定义函数"),
    INPUT("5", "界面录入");

    private String code;
    private String value;

    NamingItemType(String code, String value) {
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
        for (NamingItemType type : NamingItemType.values()) {
            if (type.getCode().equals(code)) {
                return type.getValue();
            }
        }
        return null;
    }

    public static String getCodeByValue(String value) {
        for (NamingItemType type : NamingItemType.values()) {
            if (type.getValue().equals(value)) {
                return type.getCode();
            }
        }
        return null;
    }

}
