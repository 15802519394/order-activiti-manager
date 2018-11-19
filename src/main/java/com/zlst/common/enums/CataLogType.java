package com.zlst.common.enums;

/**
 * 目录类型
 * Created by 170115 on 2018/11/06
 */
public enum CataLogType {

    I("I", "存量目录"),
    T("T", "模板目录");

    private String code;

    private String value;

    CataLogType(String code, String value) {
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
        for (CataLogType type : CataLogType.values()) {
            if (type.getCode().equals(code)) {
                return type.getValue();
            }
        }
        return null;
    }
}
