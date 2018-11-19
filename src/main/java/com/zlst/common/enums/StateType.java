package com.zlst.common.enums;

/**
 * Created by 170096 on 2018/5/7
 */
public enum StateType {

    DISABLE("X", "无效"),
    ENABLE("A", "有效");

    private String code;
    private String value;

    StateType(String code, String value) {
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
        for (StateType type : StateType.values()) {
            if (type.getCode().equals(code)) {
                return type.getValue();
            }
        }
        return null;
    }

    public static String getCodeByValue(String value) {
        for (StateType type : StateType.values()) {
            if (type.getValue().equals(value)) {
                return type.getCode();
            }
        }
        return null;
    }

}
