package com.zlst.common.constant;

import java.text.SimpleDateFormat;

/**
 * 全局常量
 * Created by 170096 on 2017/8/22.
 */
public final class GlobalConstants {
    // API版本
    public static final String VERSION = "V1";

    // 默认数据库用户名
    public static final String DEFAULT_DBUSER="metadata";

    // 网关参数
    public final static String GATEWAY_USERID = "gateway_userId";
    public final static String GATEWAY_USERNAME = "gateway_userName";
    public final static String GATEWAY_CORPID = "gateway_corpId";

    //微服务id
    public static final String MICROSERVICE_ZLST_MANAGE_SYSTEM = "microservice-zlst-sys-manage";    //系统管理
    public static final String MICROSERVICE_ZLST_COMMON_DATA = "microservice-zlst-common-data";     //数据字典

    //索引类型
    public static final String INDEX_TYPE_NORMAL = "NORMAL";
    public static final String INDEX_TYPE_UNIQUE = "UNIQUE";
    public static final String INDEX_TYPE_BITMAP = "BITMAP";
    public static final String UNIQUENESS_UNIQUE = "UNIQUE";
    public static final String UNIQUENESS_NONUNIQUE = "NONUNIQUE";

    //资源型号业务编码
    public static final String BUSICODE_CPSRESOURCEMODEL = "CPSRESOURCEMODEL";

    // 服务配置（服务名）
    public static final String QUERY_RELATION_TABLE = "queryRelationTable";     // 查询对象关联表


}
