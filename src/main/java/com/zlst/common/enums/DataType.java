package com.zlst.common.enums;

/**
 *  数据类型
 *  Created by 170096 on 2018/8/13
 */
public enum DataType {
//    N-Number
//    S-String
//    D-Date
//    I-Int
    N("N", "Number"),
    S("S", "String"),
    D("D", "Date"),
    I("I", "Int");

    private String code;

    private String value;

    DataType(String code, String value) {
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
        for (DataType type : DataType.values()) {
            if (type.getCode().equals(code)){
                return  type.getValue();
            }
        }
        return null;
    }
}
