package com.zlst.common.enums;

/**
 * Created by 170096 on 2018/10/12 11:16
 *
 * @author ${User}
 */
public enum FilterType {
    V("V", "Value Mapping"),
    C("C", "Column Mapping");

    private String code;
    private String value;

    FilterType(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
