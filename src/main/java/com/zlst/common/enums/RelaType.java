package com.zlst.common.enums;/**
 * Created by 170157 on 2018/9/14.
 */

/**
 * @author liqi/170157
 * @create 2018-09-14 11:09
 **/
public enum RelaType {

    G1004("1004", "关联关系"),
    G2001("2001", "属性连动关系"),
    G2003("2003", "属性映射关系  ");

    private String code;
    private String value;

    RelaType(String code, String value) {
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
        for (RelaType type : RelaType.values()) {
            if (type.getCode().equals(code)) {
                return type.getValue();
            }
        }
        return null;
    }

    public static String getCodeByValue(String value) {
        for (RelaType type : RelaType.values()) {
            if (type.getValue().equals(value)) {
                return type.getCode();
            }
        }
        return null;
    }
}
