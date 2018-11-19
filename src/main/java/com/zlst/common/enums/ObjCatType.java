package com.zlst.common.enums;

/**
 * Created by 170096 on 2018/10/22 19:16
 *
 * @author ${User}
 */
public enum ObjCatType {
    /*
     * RES: Resource
     CFS: Customer Facing Service
     RFS: Resource Facing Service
     PROD: Product Specification
     TMPL: Template
     STAT: Statistics
     PRTC: Protocol
     */

    RES("RES"),
    CFS("CFS"),
    RFS("RFS"),
    PROD("PROD"),
    TMPL("TMPL"),
    STAT("STAT"),
    PRTC("PRTC");

    private String code;

    ObjCatType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

