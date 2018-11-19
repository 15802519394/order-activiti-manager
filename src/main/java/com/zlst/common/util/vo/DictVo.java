package com.zlst.common.util.vo;

import java.util.List;

/**
 * Created by 170096 on 2018/10/23 14:44
 *
 * @author ${User}
 */
public class DictVo {

    private String dictCode;

    private String dictName;

    private String remark;

    private List<DictItemsVo> itemsVoList;

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<DictItemsVo> getItemsVoList() {
        return itemsVoList;
    }

    public void setItemsVoList(List<DictItemsVo> itemsVoList) {
        this.itemsVoList = itemsVoList;
    }
}
