package com.zlst.common.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by 170096 on 2018/8/9
 */
@MappedSuperclass
public class BaseEntityBean {

    @Column(name = "CREATED_BY", length = 32)
    private String createdBy;          //创建人       32

    @CreationTimestamp
    @Column(name = "CREATE_TIME", updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date createTime;            //创建时间

    @Column(name = "MODIFIED_BY", length = 32)
    private String modifiedBy;         //修改人       32

    @UpdateTimestamp
    @Column(name = "MODIFY_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date modifyTime;            //修改时间

    @Column(name = "NOTES", length = 256)
    private String notes;     //备注

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
