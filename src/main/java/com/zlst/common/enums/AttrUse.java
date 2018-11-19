package com.zlst.common.enums;

/**
 * 属性用途
 * Created by 170096 on 2018/8/13
 */
public enum AttrUse {
//    属性的业务用途，目前只支持
//1：ID
//0：NAME
    ID("1", "ID"),
    NAME("0", "NAME");

    private String code;

    private String value;

    AttrUse(String code, String value) {
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
        for (AttrUse type : AttrUse.values()) {
            if (type.getCode().equals(code)){
                return  type.getValue();
            }
        }
        return null;
    }
}

