package com.zlst.common.enums;

/**
 * 是否继承
 * Created by 170157 on 2018/8/31
 */
public enum IsInherited {
    //   命名规则是否继承
    INHERITED("1", "是继承"),
    NOTINHERITED("0", "不是继承");

    private String code;

    private String value;

    IsInherited(String code, String value) {
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
        for (IsInherited type : IsInherited.values()) {
            if (type.getCode().equals(code)) {
                return type.getValue();
            }
        }
        return null;
    }
}

