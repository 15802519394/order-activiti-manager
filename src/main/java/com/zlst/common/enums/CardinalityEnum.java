package com.zlst.common.enums;

/**
 *  基数类型
 *  Created by 170157 on 2018/8/13
 */
public enum CardinalityEnum {
    O2O("O2O", "一对一"),
    O2M("O2M", "一对多"),
    M2O("M2O", "多对一"),
    M2M("M2M", "多对多");

    private String code;

    private String value;

    CardinalityEnum(String code, String value) {
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
        for (CardinalityEnum type : CardinalityEnum.values()) {
            if (type.getCode().equals(code)){
                return  type.getValue();
            }
        }
        return null;
    }
}
