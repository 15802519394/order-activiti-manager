package com.zlst.common.enums;

/**
 * Created by 170157 on 2018/9/17.
 */
public enum IndexType {

    N("N", "Normal"),
    U("U", "Unique"),
    B("B", "Bitmap");

    private String code;

    private String value;

    IndexType(String code, String value) {
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
        for (IndexType type : IndexType.values()) {
            if (type.getCode().equals(code)){
                return  type.getValue();
            }
        }
        return null;
    }

}
