package com.zlst.common.util;

import org.springframework.data.util.*;
import org.springframework.util.*;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 170205
 * Date: 2018-11-19
 * Time: 17:42
 */
public class BaseUtil {

    public static HttpServletRequest getRequest() {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        if (ra != null) {
            ServletRequestAttributes sra = (ServletRequestAttributes) ra;
            return sra.getRequest();
        } else {
            return null;
        }

    }

    public static void setOtherProperties(Object t, boolean isUpdate) {
        HttpServletRequest request = getRequest();
//        createdBy---新增
//        modifiedBy---修改
        if (request != null) {
            String userId = request.getHeader("gateway_userId");
            String userName = request.getHeader("gateway_userName");
            if (!org.springframework.util.StringUtils.isEmpty(userId)) {
                if (!isUpdate) {
                    setObjectFieldValue("createdBy", userId, t);
                    setObjectFieldValue("createdName", userName, t);
                } else {
                    setObjectFieldValue("modifiedBy", userId, t);
                    setObjectFieldValue("modifiedName", userName, t);
                }
            }
        }
    }


    private static void setObjectFieldValue(String fieldName, Object fieldValue, Object t) {
        Field updateField = org.springframework.util.ReflectionUtils.findField(t.getClass(), fieldName);
//        updateField.getGenericType().getTypeName().equals("int")
//                java.lang.Integer
        if (updateField != null) {
            String typeName = updateField.getGenericType().getTypeName();
            if (typeName.equals("int") || typeName.equals("java.lang.Integer")) {
                Integer updateValue = Integer.valueOf(fieldValue.toString());
                org.springframework.data.util.ReflectionUtils.setField(updateField, t, updateValue);
            } else {
                org.springframework.data.util.ReflectionUtils.setField(updateField, t, fieldValue.toString());
            }
        }
    }

    /**
     * 数组是否包含某元素
     *
     * @param keyObj 指定元素
     * @param objs   指定数组
     * @return
     */
    public static boolean containsObj(Object keyObj, Object... objs) {

        if (keyObj == null || objs == null) {
            return false;
        }

        boolean result = false;
        String e = keyObj.toString();
        for (Object o : objs) {
            if (o.toString().equals(e)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
