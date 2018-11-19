package com.zlst.common.enums;/**
 * Created by 170157 on 2018/9/13.
 */

/**
 * @author liqi/170157
 * @create 2018-09-13 14:11
 **/
public enum KeyEnum {

    P("P", "Primary"),
    U("U", "Unique"),
    R("R", "Foreign");

    private String code;

    private String value;

    KeyEnum(String code, String value) {
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
        for (KeyEnum key : KeyEnum.values()) {
            if (key.getCode().equals(code)){
                return  key.getValue();
            }
        }
        return null;
    }
}
