package com.billyang.girl.multitenant;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

public class PropertityUtils {
    public static Properties loadProperties(String fileName){
        if(StringUtils.isNotBlank(fileName)){
            try {
                return PropertiesLoaderUtils.loadAllProperties(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
