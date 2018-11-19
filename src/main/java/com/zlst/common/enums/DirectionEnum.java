package com.zlst.common.enums;

/**
 * 数据权限枚举
 * Created by 170157 on 2018/3/21 14:37.
 */
public enum DirectionEnum
{
    ONEWAY("U","单向"),TWOWAY("B","双向"),;

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    DirectionEnum(String id, String name)
    {
        this.id = id;
        this.name = name;
    }
}
