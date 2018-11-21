package com.zlst.order.cpsomsdataobject.bean;

import com.zlst.common.bean.BaseEntityBean;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="CPS_OMS_DATAOBJECT")
public class CpsOmsDataobjectBean extends BaseEntityBean{
    /**
     *元数据对象表
     */
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String dataobjectNo;

    @Column(name = "CATALOG_ID")
    private String catalogId;

    @Column(name = "DATAOBJECT_TYPE")
    private String dataobjectType;

    @Column(name = "DATAOBJECT_CODE")
    private String dataobjectCode;

    @Column(name = "DATAOBJECT_ALIAS")
    private String dataobjectAlias;

    @Column(name = "ORD_TYPE")
    private String ordType;

    @Column(name = "STATE")
    private String state;

    @Column(name = "IS_USER_DEFINED")
    private char isUserDefined;

    @Column(name = "STORE_TYPE")
    private String storeType;

    @Column(name = "TABLE_NAME")
    private String tableName;

    @Column(name = "SERVICE_NAME")
    private String serviceName;

    public CpsOmsDataobjectBean(){}

    public String getDataobjectNo() {
        return dataobjectNo;
    }

    public void setDataobjectNo(String dataobjectNo) {
        this.dataobjectNo = dataobjectNo;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public String getDataobjectType() {
        return dataobjectType;
    }

    public void setDataobjectType(String dataobjectType) {
        this.dataobjectType = dataobjectType;
    }

    public String getDataobjectCode() {
        return dataobjectCode;
    }

    public void setDataobjectCode(String dataobjectCode) {
        this.dataobjectCode = dataobjectCode;
    }

    public String getDataobjectAlias() {
        return dataobjectAlias;
    }

    public void setDataobjectAlias(String dataobjectAlias) {
        this.dataobjectAlias = dataobjectAlias;
    }

    public String getOrdType() {
        return ordType;
    }

    public void setOrdType(String ordType) {
        this.ordType = ordType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public char getIsUserDefined() {
        return isUserDefined;
    }

    public void setIsUserDefined(char isUserDefined) {
        this.isUserDefined = isUserDefined;
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}