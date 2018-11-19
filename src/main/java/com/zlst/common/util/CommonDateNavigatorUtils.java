//package com.zlst.common.util;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.zlst.common.constant.GlobalConstants;
//import com.zlst.common.navigator.NavigatorUtils;
//import com.zlst.common.util.vo.DictItemsVo;
//import com.zlst.common.util.vo.DictVo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
///**
// * Created by 170178 on 2018/11/19 14:04
// *
// * @author ${User}
// */
//@Component
//public class CommonDateNavigatorUtils {
//
//    private final String getObjTypeDic = "/commdata/dictInfo/getDictAndItem?objType=";
//    private final String saveObjInfo = "/commdata/dictInfo/saveObjInfo";
//
//    @Autowired
//    private NavigatorUtils navigatorUtils;
//
//    /**
//     * 通过对象获取对象字典
//     */
//    public List<DictVo> getObjDic(String objType) {
//        String result =  navigatorUtils.getJson(getObjTypeDic + objType, GlobalConstants.MICROSERVICE_ZLST_COMMON_DATA, null, getObjTypeDic);
//        if (StringUtils.isNullOrBlank(result)) {
//            return null;
//        }
//        JSONArray data = JSON.parseArray(JSONObject.parseObject(result).getString("data"));
//        List<DictVo> dictVoList = new ArrayList<>();
//        Iterator<Object> it =data.iterator();
//        while (it.hasNext()) {
//            JSONObject dic = (JSONObject) it.next();
//
//            DictVo dictVo = new DictVo();
//            dictVo.setDictCode(dic.getString("dictCode"));
//            dictVo.setDictName(dic.getString("dictName"));
//            dictVo.setRemark(dic.getString("remark"));
//
//            JSONArray itemArray = JSON.parseArray(dic.getString("items"));
//            Iterator<Object> itemIt =itemArray.iterator();
//            List<DictItemsVo> itemList = new ArrayList<>();
//
//            while (itemIt.hasNext()) {
//                JSONObject dicItem = (JSONObject) itemIt.next();
//
//                DictItemsVo dictItemsVo = new DictItemsVo();
//                dictItemsVo.setItemCode(dicItem.getString("itemCode"));
//                dictItemsVo.setItemValue(dicItem.getString("itemValue"));
//
//                itemList.add(dictItemsVo);
//            }
//            dictVo.setItemsVoList(itemList);
//            dictVoList.add(dictVo);
//        }
//        return dictVoList;
//    }
//
//    /**
//     * 保存对象关联字典（对象类型和字典编码）
//     */
//    public void saveObjTypeWithDict(String objType, String dictCode) {
//        String url = saveObjInfo+"?objType=" + objType + "&dictCode=" + dictCode;
//        navigatorUtils.postJson(url,GlobalConstants.MICROSERVICE_ZLST_COMMON_DATA, null, saveObjInfo);
//    }
//}
