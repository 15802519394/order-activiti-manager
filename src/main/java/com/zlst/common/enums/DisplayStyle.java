package com.zlst.common.enums;

/**
 * 显示风格
 * Created by 170096 on 2018/8/13
 */
public enum DisplayStyle {
//    TextEdit: 单行文本框
//    Checkbox: 复选框
//    ComboBox：下拉框
//    DatePick：日期选择框
//    URL：URL连接（弹出界面）
//    IP：IP地址
//    TextArea：多行文本框
    TextEdit("TextEdit", "单行文本框"),
    Passwordbox("Passwordbox", "密码框"),
    Radio("Radio", "单选框"),
    Checkbox("Checkbox", "复选框"),
    ComboBox("ComboBox", "下拉框"),
    DatePick("DatePick", "日期选择框"),
    URL("URL", "URL连接"),
    IP("IP", "IP地址"),
    TextArea("TextArea", "多行文本框");

    private String code;

    private String value;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    DisplayStyle(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public static String getValueByCode(String code) {
        for (DisplayStyle type : DisplayStyle.values()) {
            if (type.getCode().equals(code)){
                return  type.getValue();
            }
        }
        return null;
    }
}
