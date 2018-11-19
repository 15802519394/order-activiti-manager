//package com.zlst.common.util;
//
//import com.alibaba.fastjson.JSONObject;
//import com.zlst.common.constant.GlobalConstants;
//import com.zlst.common.navigator.NavigatorUtils;
//import com.zlst.common.redis.RedisKey;
//import com.zlst.common.redis.util.RedisUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Created by 170115 on 2017/10/25.
// */
//@Component
//public class SystemManageUtils {
//    private final Logger logger = LoggerFactory.getLogger(SystemManageUtils.class);
//
//    private static final String parametersUrl = "/system/parameters";            //查询所有员工信息url
//    private static final String staffUrl = "/system/staffs/";            //查询所有员工信息url
//    private static final String userUrl = "/system/users/";            //查询所有用户信息url
//
//    /**
//     * 微服务请求工具
//     */
//    @Autowired
//    private NavigatorUtils navigatorUtils;
//
//    @Autowired
//    private RedisUtils redisUtils;
//
//    /**
//     * 通过用户id查询用户信息
//     *
//     * @param id
//     * @return
//     */
//    public Map<String, String> getUserInfoById(String id) {
//        Map<String, String> res = new HashMap<String, String>();
//        if (StringUtils.isNullOrBlank(id)) {
//            return res;
//        }
//        try {
//            //查询缓存
//            res = getByRedis(id);
//            if (StringUtils.isNullOrBlank(res.get("userId"))) {
//                res = getByNavigator(userUrl, id);
//                return res;
//            }
//        } catch (Exception e) {
//            logger.error("查询员工失败");
//        }
//        return res;
//    }
//
//
//    /************私有方法************/
//    private Map getByRedis(String id) {
//        String json = redisUtils.getStringJson(RedisKey.KEY_RADIS_USER + id);
//        if (StringUtils.isNullOrBlank(json)) {
//            return new HashMap();
//        } else {
//            return JSONObject.parseObject(json);
//        }
//    }
//
//    private Map getByNavigator(String url, String id) {
//        String json = navigatorUtils.getJson(userUrl + id, GlobalConstants.MICROSERVICE_ZLST_MANAGE_SYSTEM, null, "get" + userUrl);
//        if (StringUtils.isNullOrBlank(json)) {
//            return new HashMap();
//        } else {
//            return JSONObject.parseObject(json);
//        }
//    }
//}
