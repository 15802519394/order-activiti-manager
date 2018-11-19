package com.zlst.common.enums;

/**
 * Created by 170096 on 2018/10/10 16:27
 *
 * @author ${User}
 */
public enum EventType {
    ONSELCHG("ONSELCHG", "On Selection Change"),
    LOSEFOCUS("LOSEFOCUS", "Lose Focus");

    private String code;
    private String value;

    EventType(String code, String value) {
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
        for (EventType eventType : EventType.values()) {
            if (eventType.getCode().equals(code)) {
                return eventType.getValue();
            }
        }
        return null;
    }
}
