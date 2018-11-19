package com.zlst.common.enums;

/**
 * 目录类型
 * Created by 170115 on 2018/11/13
 */
public enum SpecCatType {

    PROD("PROD", "产品"),
    PES("PES", "产品事件类型"),
    PEVT("PEVT", "产品事件"),
    PFS("PFS", "生产服务"),
    PFES("PFES", "生产服务事件类型"),
    PFEVT("PFEVT", "生产服务事件"),
    RFS("RFS", "生产服务事件"),
    RACT("RACT", "资源服务动作"),
    PRD("PRD", "工序");

    private String code;

    private String value;

    SpecCatType(String code, String value) {
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
        for (SpecCatType type : SpecCatType.values()) {
            if (type.getCode().equals(code)) {
                return type.getValue();
            }
        }
        return null;
    }
}
