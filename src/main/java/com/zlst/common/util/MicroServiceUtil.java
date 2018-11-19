//package com.zlst.common.util;
//
//import com.zlst.common.constant.ExceptionConstants;
//import com.zlst.common.constant.GlobalConstants;
//import com.zlst.common.navigator.NavigatorUtils;
//import com.zlst.exception.ZLSTException;
//import com.zlst.param.Result;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ByteArrayResource;
//import org.springframework.stereotype.Component;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.multipart.MultipartFile;
//
//
///**
// * Created with IntelliJ IDEA.
// * Description: 此类集中封装常用微服务调用方法
// * User: 170205
// * Date: 2018-10-29
// * Time: 17:45
// */
//@Component
//public class MicroServiceUtil {
//
//    private static final Logger logger = LoggerFactory.getLogger(MicroServiceUtil.class);
//
//    @Autowired
//    private NavigatorUtils navigatorUtils;
//
//    /**
//     * 插入文件记录并上传文件到服务器
//     */
//    String insertFileInfoAndUpload = "/commonData/fileCommonManageCtrl/insertFileInfoAndUpload";
//
//    String deleteFileByRefId = "/commonData/fileCommonManageCtrl/delFileByRefId/";
//
//
//    /**
//     * 上传文件
//     * @param busiCode 业务code
//     * @param remark 备注
//     * @param realFileName 文件名
//     * @param refId 业务数据id
//     * @param file 文件
//     * @return
//     * @throws Exception
//     */
//     public Object uploadFile(String busiCode, String remark,String realFileName, String refId, MultipartFile file) throws Exception {
//         logger.debug("upload file fileInfo {}", busiCode, remark, realFileName, refId, file);
//
//         MultiValueMap<String, Object> parts = new LinkedMultiValueMap();
//         parts.add("busiCode", busiCode);
//         parts.add("remark", remark);
//         parts.add("realFileName", realFileName);
//         parts.add("refId", refId);
//         parts.add("fileSize", file.getSize()/ 1000);
//         parts.add("file", new ByteArrayResource(file.getBytes()));
//
//         Result results = navigatorUtils.getNavigatorByMap(insertFileInfoAndUpload, GlobalConstants.MICROSERVICE_ZLST_COMMON_DATA, parts);
//
//         if(results.getResultCode()!=0) {
//             throw new ZLSTException(ExceptionConstants.MICRO_SERVICE_INVOKE_ERROR,new Object[]{"上传文件失败"});
//         }
//
//         return results.getData();
//     }
//
//    /**
//     * 根据相关id删除文件
//     * @param refId
//     * @return
//     * @throws Exception
//     */
//     public Object deleteFileByRefId(String refId) throws Exception {
//         logger.debug("deleteFileByRefId refId is {}", refId);
//
//         String json = navigatorUtils.getJson(deleteFileByRefId + refId, GlobalConstants.MICROSERVICE_ZLST_COMMON_DATA, null, "get" + deleteFileByRefId);
//         return  json;
//
//     }
//}
