package com.zlst.common.enums;

/**
 * Created by 170096 on 2018/11/6 18:05
 *
 * @author ${User}
 */
public enum ServiceType {
    QUERY("1", "查询服务"),
    JAVA("3", "JAVA服务");

    private String code;
    private String value;

    ServiceType(String code, String value) {
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
        for (ServiceType serviceType : ServiceType.values()) {
            if (serviceType.getCode().equals(code)) {
                return serviceType.getValue();
            }
        }
        return null;
    }
}

