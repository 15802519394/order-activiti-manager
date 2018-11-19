package com.zlst.common.enums;

/**
 * Created by 170096 on 2018/5/7
 */
public enum YesOrNo {

    YES("Y", "是"),
    NO("N", "否");

    private String code;
    private String value;

    YesOrNo(String code, String value) {
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
        for (YesOrNo type : YesOrNo.values()) {
            if (type.getCode().equals(code)) {
                return type.getValue();
            }
        }
        return null;
    }

    public static String getCodeByValue(String value) {
        for (YesOrNo type : YesOrNo.values()) {
            if (type.getValue().equals(value)) {
                return type.getCode();
            }
        }
        return null;
    }

}
