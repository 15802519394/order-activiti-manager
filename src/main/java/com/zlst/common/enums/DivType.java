package com.zlst.common.enums;

/**
 * Created by 170096 on 2018/10/19 14:12
 *
 * @author ${User}
 */
public enum DivType {
    /*
    P-Page,在Management页面里面的页签
    V-View,在存量维护主界面右侧的按钮
    B-Button，在Summary页面里面的小区块 widget
    D-拆分规则
    S-Search，查询组件，用于存量维护主界面右侧的查询条件
     */

    P("P", "Page"),
    V("V", "View"),
    B("B", "Button"),
    D("D", "拆分规则"),
    S("S", "Search");

    private String code;
    private String value;

    DivType(String code, String value) {
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
        for (DivType divType : DivType.values()) {
            if (divType.getCode().equals(code)){
                return divType.getValue();
            }
        }
        return null;
    }
}
