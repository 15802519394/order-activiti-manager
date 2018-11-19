package com.zlst.common.enums;

/**
 * Created by 170096 on 2018/10/10 16:31
 *
 * @author ${User}
 */
public enum HandlerType {
    /*
        M-属性值映射 通过属性关系和属性值关系表来体现
        S-JavaScript脚本，具体脚本放在HANDLER_SCRIPT字段中
     */
    M("M", "Mapping"),
    S("S", "Script");

    private String code;
    private String value;

    HandlerType(String code, String value) {
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

    public static String getValueByCode(String code) {
        for (HandlerType handlerType : HandlerType.values()) {
            if (handlerType.getCode().equals(code)) {
                return handlerType.getValue();
            }
        }
        return null;
    }
}
