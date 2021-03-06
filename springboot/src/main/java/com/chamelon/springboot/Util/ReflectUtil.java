package com.chamelon.springboot.Util;

import com.chamelon.springboot.Bean.DynamicBean;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

public class ReflectUtil {

    static Logger logger = LogManager.getLogger(ReflectUtil.class);

    @SuppressWarnings("rawtypes")
    public static Object getTarget(Object dest, Map<String, Object> addProperties) {
        PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
        PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(dest);
        Map<String, Class> propertyMap = new HashMap<>();
        for (PropertyDescriptor d : descriptors) {
            if (!"class".equalsIgnoreCase(d.getName())) {
                propertyMap.put(d.getName(), d.getPropertyType());
            }
        }
        // add extra properties
        addProperties.forEach((k, v) -> propertyMap.put(k, v.getClass()));
        // new dynamic bean
        DynamicBean dynamicBean = new DynamicBean(dest.getClass(), propertyMap);
        // add old value
        propertyMap.forEach((k, v) -> {
            try {
                // filter extra properties
                if (!addProperties.containsKey(k)) {
                    dynamicBean.setValue(k, propertyUtilsBean.getNestedProperty(dest, k));
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        });
        // add extra value
        addProperties.forEach((k, v) -> {
            try {
                dynamicBean.setValue(k, v);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        });
        Object target = dynamicBean.getTarget();
        return target;
    }

    public static void main(String[] args) {
        AttendanceVo entity = new AttendanceVo();
        Map<String, Object> addProperties = new HashMap<>();
        addProperties.put("day31", "你好");
        AttendanceVo newVo = (AttendanceVo) getTarget(entity, addProperties);
        System.out.println(newVo.getDay());
    }

}