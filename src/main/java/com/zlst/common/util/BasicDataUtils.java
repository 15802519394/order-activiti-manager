package com.zlst.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zlst.common.redis.util.RedisUtils;
import com.zlst.common.util.vo.DictInfo;
import com.zlst.common.util.vo.DictItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 170096 on 2018/11/2 17:42
 */
@Component
public class BasicDataUtils {

    @Autowired
    private RedisUtils redisUtil;
    public static final String ALL_DICT = "KEY_COMM_DICTIONARY_INFOS";                      // 所有的数据字典
    public static final String DICT_PREFIX = "KEY_COMM_DICTIONARY_ITEMS_";                   // 数据字典key前缀
    /***********数据字典key**************/
    public static final String ATTR_USE = DICT_PREFIX + "ATTR_USE";             // 属性用途
    public static final String DATA_TYPE = DICT_PREFIX + "DATA_TYPE";           // 数据类型
    public static final String LAYOUT_TYPE = DICT_PREFIX + "LAYOUT_TYPE";       // 布局类型
    public static final String NAMING_TYPE = DICT_PREFIX + "NAMING_TYPE";       // 命名项类型
    public static final String ATTR_VAL_SRC = DICT_PREFIX + "ATTR_VAL_SRC";     // 属性的取值来源
    public static final String DISPLAY_STYLE = DICT_PREFIX + "DISPLAY_STYLE";   // 属性的取值来源
    public static final String COM_TYPE = DICT_PREFIX + "COM_TYPE";             // 组件类型

    // 通过字典项编码获取字典项名字
    public String getNameByCode(String itemCode, List<DictItem> dictItemList) {
        if (CollectionUtils.isEmpty(dictItemList))
            return null;
        for (DictItem dictItem : dictItemList) {
            if (dictItem.getCode().equals(itemCode))
                return dictItem.getName();
        }
        return null;
    }

    // 通过字典项编码获取字典Id
    public String getIdByCode(String itemCode, List<DictItem> dictItemList) {
        if (CollectionUtils.isEmpty(dictItemList))
            return null;
        for (DictItem dictItem : dictItemList) {
            if (dictItem.getCode().equals(itemCode))
                return dictItem.getId();
        }
        return null;
    }

    // 根据字典的key获取字典List
    public List<DictItem> getAllByKey(String key) {
        return getRedisList(key, "dictId", "itemCode", "itemValue");
    }

    /**
     * 从Redis取得List
     */
    private List<DictItem> getRedisList(String key, String basicId, String basicCode, String basicName) {
        List<DictItem> listBasicInfo = new ArrayList<DictItem>();
        String json = redisUtil.getStringJson(key);
        if (json == null) {
            return listBasicInfo;
        }
        JSONArray data = JSON.parseArray(json);
        if (data == null) {
            return listBasicInfo;
        }
        for (Object aData : data) {
            DictItem dictItem = new DictItem();
            JSONObject jsonObject = (JSONObject) aData;
            dictItem.setId(jsonObject.getString(basicId));
            dictItem.setName(jsonObject.getString(basicName));
            dictItem.setCode(jsonObject.getString(basicCode));
            listBasicInfo.add(dictItem);
        }
        return listBasicInfo;
    }

    // 获取所有的字典列表
    public List<DictInfo> getAllDict() {
        return getAllDict(BasicDataUtils.ALL_DICT, "dictId", "dictCode", "dictName");
    }

    private List<DictInfo> getAllDict(String key, String basicId, String basicCode, String basicName) {
        List<DictInfo> dictInfoList = new ArrayList<>();
        String json = redisUtil.getStringJson(key);
        if (json == null) {
            return dictInfoList;
        }
        JSONArray data = JSON.parseArray(json);
        if (data == null) {
            return dictInfoList;
        }
        for (Object aData : data) {
            DictInfo dictInfo = new DictInfo();
            JSONObject jsonObject = (JSONObject) aData;
            dictInfo.setDictId(jsonObject.getString(basicId));
            dictInfo.setDictCode(jsonObject.getString(basicCode));
            dictInfo.setDictName(jsonObject.getString(basicName));
            dictInfoList.add(dictInfo);
        }
        return dictInfoList;
    }


}
