package com.zlst.order.cpsomsoatalog.vo;

/**
 * VO数据表
 * */
public class CpsOmsCatalogVo {

    private String catalogId;

    private String catalogName;

    private String parentId;

    private String notes;

    private String catalogType;

    public CpsOmsCatalogVo(){}

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

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
}
