package com.zlst.common.enums;

/**
 * Created by 170096 on 2018/8/31
 */
public enum LayoutType {

    QUERY("QUERY", "查询布局"),
    FORM("FORM", "表单布局"),
    LIST("LIST", "列表布局");

    private String code;

    private String value;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    LayoutType(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public static String getValueByCode(String code) {
        for (LayoutType type : LayoutType.values()) {
            if (type.getCode().equals(code)){
                return  type.getValue();
            }
        }
        return null;
    }
}
