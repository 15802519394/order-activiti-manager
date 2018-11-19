package com.zlst.common.enums;

/**
 * 变量源
 * Created by 170096 on 2018/8/13
 */
public enum SourceType {
//    Enum: 枚举值，枚举值存放在IMS_OBJ_ATTRVAL_ENUM表中
//    Table：来源于静态参数表，静态参数表的定义放在IMS_OBJ_ATTRVAL_TABLE表中
//    URL：来源于另外一个弹出界面，具体的URL值放在URL字段中
//    Sequence：通过序列生成，具体的序列名放在VAL_SEQUENCE字段中
//    Dict：来源于字典表，具体的字典项放在DICT_INDEX字段中
    TABLE("Table", "来源表"),
    Dict("Dictionary", "字典"),
    URL("URL", "来源URL"),
    SEQUENCE("SEQUENCE","序号"),
    INPUT("INPUT", "手工输入");


    private String code;

    private String value;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    SourceType(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public static String getValueByCode(String code) {
        for (SourceType type : SourceType.values()) {
            if (type.getCode().equals(code)){
                return  type.getValue();
            }
        }
        return null;
    }
}
