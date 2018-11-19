//package com.zlst.common.navigator;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.netflix.hystrix.HystrixCommand;
//import com.zlst.common.constant.ExceptionConstants;
//import com.zlst.exception.ZLSTException;
//import com.zlst.navigator2.DefaultRestNavigatorImpl;
//import com.zlst.navigator2.RestNavigator;
//import com.zlst.navigator2.factory.HystrixSetterAdapter;
//import com.zlst.navigator2.factory.HystrixSetterFactory;
//import com.zlst.param.ObjectToResult;
//import com.zlst.param.Result;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.*;
//import org.springframework.stereotype.Component;
//import org.springframework.util.MultiValueMap;
//
//import java.io.*;
//import java.util.Map;
//
///**
// * 请求微服务工具
// * Created by 170096 on 2017/9/26.
// */
//@Component
//public class NavigatorUtils {
//    private static final Logger log = LoggerFactory.getLogger(NavigatorUtils.class);
//
//    /**
//     * 导航器post请求，Json返回
//     *
//     * @param url
//     * @param serviceId
//     * @param json
//     * @return
//     */
//    public String postJson(String url, String serviceId, JSONObject json, String commandKey) {
//        HystrixCommand.Setter setter = hystrixCommandSetter(serviceId, "post:" + commandKey);
//        RestNavigator<String> impl = new DefaultRestNavigatorImpl<>(String.class, serviceId, url, setter);
//        return impl.post(null, json);
//    }
//
//    /**
//     * 导航器get请求，Json返回
//     *
//     * @param url
//     * @param serviceId
//     * @param params
//     * @return
//     */
//    public String getJson(String url, String serviceId, Map<String, Object> params, String commandKey) {
//        HystrixCommand.Setter setter = hystrixCommandSetter(serviceId, "get:" + commandKey);
//        RestNavigator<String> impl = new DefaultRestNavigatorImpl<>(String.class, serviceId, url, setter);
//        return null == params ? impl.get(null) : impl.get(null, params);
//    }
//
//
//    /**
//     * 适配器
//     *
//     * @param microServiceName 服务名称
//     * @param commandKey       熔断线程KEY
//     * @return
//     */
//    private HystrixCommand.Setter hystrixCommandSetter(String microServiceName, String commandKey) {
//        HystrixSetterAdapter adapter = new HystrixSetterAdapter(microServiceName)
//                .withExecutionTimeoutInMilliseconds(10000) // 配置熔断超时时间
//                .withCommand(commandKey) // 服务标识【熔断起决定作用】
//                .withThread(commandKey); //线程标识【线程分组】
//        HystrixCommand.Setter setter = HystrixSetterFactory.setter(adapter);
//        return setter;
//    }
//
//    /**
//     * 以【POST】【JSON】方式跨微服务请求，并返回Result对象
//     * @param url
//     * @param serviceId
//     * @param json
//     * @return
//     * @throws IOException
//     */
//    public static Result getNavigatorByJson(String url, String serviceId, JSONObject json) throws IOException {
//        log.debug("getNavigatorByJson start, the  request is : {}", JSONObject.toJSONString(json));
//        // 自定义参数
//        HystrixSetterAdapter adapter = new HystrixSetterAdapter()
//                .withExecutionTimeoutInMilliseconds(10000);   // 熔断超时时间
////                .withThreadCoreSize(10);                    // 服务接口最大线程并行数
//        HystrixCommand.Setter setter = HystrixSetterFactory.setter(adapter);
//        String result = new DefaultRestNavigatorImpl<>(String.class, serviceId, url, setter).post(null, json);
//        log.debug("getNavigatorByJson end, the  response is : {}", result);
//
//        Result results = JSON.parseObject(result, Result.class);
//        if (JSON.parseObject(result).getString("resultCode").equals(String.valueOf(ObjectToResult.FAIL_CODE))) {
//            throw new ZLSTException(ExceptionConstants.UNIVERSAL_EXCEPTION, new Object[] {"微服务请求异常"});
//        }
//
//        return results;
//    }
//
//    public static Result getNavigatorByMap(String url, String serviceId, MultiValueMap<String, Object> parts) throws IOException {
//        // 自定义参数
//        HystrixSetterAdapter adapter = new HystrixSetterAdapter()
//                .withExecutionTimeoutInMilliseconds(10000);   // 熔断超时时间
////                .withThreadCoreSize(10);                    // 服务接口最大线程并行数
//        HystrixCommand.Setter setter = HystrixSetterFactory.setter(adapter);
//
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
//        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity(parts, headers);
//
//        parts.add("destination", "./");
//
//        String result = new DefaultRestNavigatorImpl<>(String.class, serviceId, url, setter).post(null, requestEntity);
//        log.debug("getNavigatorByJson end, the  response is : {}", result);
//
//        Result results = JSON.parseObject(result, Result.class);
//        if (JSON.parseObject(result).getString("resultCode").equals(String.valueOf(ObjectToResult.FAIL_CODE))) {
//            throw new ZLSTException(ExceptionConstants.UNIVERSAL_EXCEPTION, new Object[] {"微服务请求异常"});
//        }
//
//        return results;
//    }
//
//
//}
