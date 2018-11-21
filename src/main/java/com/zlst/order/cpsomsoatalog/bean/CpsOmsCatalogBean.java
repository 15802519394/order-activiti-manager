package com.zlst.order.cpsomsoatalog.bean;


import com.zlst.common.bean.BaseEntityBean;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
/**
 * 公共目录表
 * */
@Entity
@Table(name="CPS_OMS_CATALOG")
public class CpsOmsCatalogBean extends BaseEntityBean {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String catalogId;

    @Column(name = "CATALOG_TYPE")
    private String catalogType;

    @Column(name = "ORD_TYPE")
    private String ordType;

    @Column(name = "CATALOG_NAME")
    private String catalogName;

    @Column(name = "PARENT_ID")
    private String parentId;

    @Column(name = "STATE")
    private String state;


    public CpsOmsCatalogBean(){}

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogType() {
        return catalogType;
    }

    public void setCatalogType(String catalogType) {
        this.catalogType = catalogType;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOrdType() {
        return ordType;
    }

    public void setOrdType(String ordType) {
        this.ordType = ordType;
    }
}
