package com.billyang.datalog.util;



import com.alibaba.fastjson.JSON;
import com.billyang.datalog.domain.ChangeItem;
import com.billyang.datalog.zhujie.DataLog;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class DiffUtil {
    public static final Logger logger = LoggerFactory.getLogger(DiffUtil.class);

    public static Object getObjectById(Object target, Object id) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method findMethod = target.getClass().getDeclaredMethod("findById", Long.class);
        Object oldObject = findMethod.invoke(target, id);
        return oldObject;
    }

    //获取新增操作的change item
    public static List<ChangeItem> getInsertChangeItems(Object obj){
        Map<String,String> valueMap = getBeanSimpleFieldValueMap(obj,true);
        Map<String,String> fieldCnNameMap = getFieldNameMap(obj.getClass());
        List<ChangeItem> items = new ArrayList<>();
        for(Map.Entry<String,String> entry:valueMap.entrySet()){
            String fieldName = entry.getKey();
            String value = entry.getValue();
            ChangeItem changeItem = new ChangeItem();
            changeItem.setOldValue("");
            changeItem.setNewValue(value);
            changeItem.setField(fieldName);
            String cnName = fieldCnNameMap.get(fieldName);
            changeItem.setFieldShowName(StringUtils.isEmpty(cnName)?fieldName:cnName);
        }
        return items;
    }
    /**
     * 获取删除操作的change item
     * @param obj
     * @return
     */
    public static ChangeItem getDeleteChangeItem(Object obj){
        ChangeItem changeItem = new ChangeItem();
        changeItem.setOldValue(JSON.toJSONString(obj));
        changeItem.setNewValue("");
        return changeItem;
    }

    /**
     * 获取更新操作的change item
     * @param oldObj
     * @param newObj
     * @return
     */
    public static List<ChangeItem> getChangeItems(Object oldObj, Object newObj) {
        Class cl = oldObj.getClass();
        List<ChangeItem> changeItems = new ArrayList<ChangeItem>();
        //获取字段中文名称
        Map<String,String> fieldCnNameMap = getFieldNameMap(cl);
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(cl, Object.class);

            for (PropertyDescriptor propertyDescriptor : beanInfo
                    .getPropertyDescriptors()) {
                String field = propertyDescriptor.getName();
                //获取字段旧值
                String oldProp = getValue(PropertyUtils.getProperty(oldObj,
                        field));
                //获取字段新值
                String newProp = getValue(PropertyUtils.getProperty(newObj,
                        field));

                //对比新旧值
                if (!oldProp.equals(newProp)) {
                    ChangeItem changeItem = new ChangeItem();
                    changeItem.setField(field);
                    String cnName = fieldCnNameMap.get(field);
                    changeItem.setFieldShowName(StringUtils.isEmpty(cnName) ? field : cnName);
                    changeItem.setNewValue(newProp);
                    changeItem.setOldValue(oldProp);
                    changeItems.add(changeItem);
                }
            }
        } catch (Exception e) {
            logger.error("There is error when convert change item", e);
        }
        return changeItems;
    }
    //不同类型转字符串的处理
    public static String getValue(Object obj) {
        if (null != obj) {
            if (obj instanceof Date) {
                return formatDateW3C((Date) obj);
            } else {
                return obj.toString();
            }
        } else {
            return "";
        }
    }

    //将date类型转化为字符串形式
    public static String formatDateW3C(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-DD'T'HH:ss:ssZ");
        String text = df.format(date);
        String result = text.substring(0, 22) + ":" + text.substring(22);
        return result;
    }

    //从注解中读取中文名
    public static Map<String, String> getFieldNameMap(Class<?> clz) {
        Map<String, String> map = new HashMap<>();
        for (Field field : clz.getDeclaredFields()) {
            if (field.isAnnotationPresent(DataLog.class)) {
                DataLog dataLog = field.getAnnotation(DataLog.class);
                map.put(field.getName(), dataLog.name());
            }
        }
        return map;
    }
    //获取bean的fieldname和value
    public static Map<String,String> getBeanSimpleFieldValueMap(Object bean,boolean filterNull){
        Map<String,String> map = new HashMap<>();
        if(bean == null){
            return map;
        }
        Class<?> clazz = bean.getClass();
        try{
            Field[] fields = clazz.getDeclaredFields();
            for(int i=0;i<fields.length;i++){
                Class<?> fieldType = fields[i].getType();
                String name = fields[i].getName();
                Method method = clazz.getMethod("get"+name.substring(0,1).toUpperCase()+name.substring(1));
                Object value = method.invoke(bean);
                if(filterNull && value == null){
                    continue;
                }
                if(isBaseDataType(fieldType)){
                    String strValue = getFieldStringValue(fieldType,value);
                    map.put(name,strValue);
                }
            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return map;
    }

    //自定义不同类型的String值
    public static String getFieldStringValue(Class type, Object value) {
        if (type.equals(Date.class)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
            return simpleDateFormat.format((Date) value);
        }
        return value.toString();
    }

    //判断一个类是否为基本基础类型或包装类或者日期
    public static boolean isBaseDataType(Class clazz) throws Exception {
        return
                (
                        clazz.equals(String.class) ||
                                clazz.equals(Integer.class) ||
                                clazz.equals(Byte.class) ||
                                clazz.equals(Long.class) ||
                                clazz.equals(Double.class) ||
                                clazz.equals(Float.class) ||
                                clazz.equals(Character.class) ||
                                clazz.equals(Short.class) ||
                                clazz.equals(BigDecimal.class) ||
                                clazz.equals(BigInteger.class) ||
                                clazz.equals(Boolean.class) ||
                                clazz.equals(Date.class) ||
                                clazz.isPrimitive()
                );
    }
}
