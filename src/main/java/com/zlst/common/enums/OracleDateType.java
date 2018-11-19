package com.zlst.common.enums;

/**
 * Created by 170096 on 2018/9/26
 */
public enum OracleDateType {
    NUMBER("NUMBER", "NUMBER"),
    INTEGER("INTEGER", "INTEGER"),
    DATE("DATE", "DATE"),
    VARCHAR2("VARCHAR2", "VARCHAR2");

    private String code;

    private String value;

    OracleDateType(String code, String value) {
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

    public String getValueByCode(String code) {
        for (OracleDateType oracleDateType : OracleDateType.values()) {
            if (oracleDateType.getCode().equals(code)){
                return oracleDateType.getValue();
            }
        }
        return null;
    }

    private String getCodeByValue(String value) {
        for (OracleDateType oracleDateType : OracleDateType.values()) {
            if (oracleDateType.getValue().equals(code)){
                return oracleDateType.getCode();
            }
        }
        return null;
    }
}
