package com.zlst.common.util;

import org.springframework.util.*;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 170178 on 2018/9/17.
 */
public class CreateUtil {

    public static void setCreatedOrModified(Object t, boolean isUpdate) {
        HttpServletRequest request = BaseUtil.getRequest();
        if(request != null) {
            String userId = request.getHeader("gateway_userId");
            //String userName = request.getHeader("gateway_userName");
            if(!org.springframework.util.StringUtils.isEmpty(userId)) {
                if(!isUpdate) {
                	setObjectFieldValue("createdBy", userId, t);
                    //setObjectFieldValue("createDate", getNowTime(), t);
                } else {
                	setObjectFieldValue("modifiedBy", userId, t);
                    //setObjectFieldValue("modifyDate", getNowTime(), t);
                }
            }
        }
    }
    
    public static String getNowTime() {
    	return getNowTime("yyyy-MM-dd hh:mm:ss");
    }
    
    public static String getNowTime(String timeType) {
    	Date date = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat(timeType);
    	return sdf.format(date);
    }

    private static void setObjectFieldValue(String fieldName, Object fieldValue, Object t) {
        Field updateField = ReflectionUtils.findField(t.getClass(), fieldName);
        if(updateField != null) {
            String typeName = updateField.getGenericType().getTypeName();
            if(!typeName.equals("int") && !typeName.equals("java.lang.Integer")) {
                org.springframework.data.util.ReflectionUtils.setField(updateField, t, fieldValue.toString());
            } else {
                Integer updateValue = Integer.valueOf(fieldValue.toString());
                org.springframework.data.util.ReflectionUtils.setField(updateField, t, updateValue);
            }
        }

    }


}
