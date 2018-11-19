package com.zlst.common.constant;/**
 * Created by 170157 on 2018/8/10.
 */

/**
 * @author liqi/170157
 * @create 2018-08-10 15:53
 **/
public interface ExceptionConstants {
    //公用的异常
    String EMPTY = "METADATA100001";        //不能为空
    String EXISTS = "METADATA100002";        //已存在
    String UNIVERSAL_EXCEPTION = "METADATA100003";//万能异常
    String is_not_exist = "METADATA100004";        //不存在
    String cannot_del = "METADATA100005";        //不可删
    String cannot_repeat = "METADATA100006";        //不能重复
    String is_not_empty = "METADATA100007";        //不能重复

    /**
     * 微服务调用异常
     */
    String MICRO_SERVICE_INVOKE_ERROR = "SWMSGL000001";


}
