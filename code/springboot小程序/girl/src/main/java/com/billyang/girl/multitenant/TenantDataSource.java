package com.billyang.girl.multitenant;

import com.billyang.girl.domain.DataSourceConfig;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;


import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

@Component
public class TenantDataSource implements Serializable{
    private static Logger log = LoggerFactory.getLogger(TenantDataSource.class);

    @Autowired
    private DataSourceConfigRepository configRepo;
    public DataSource getDataSource(String name) {
        if ( null != TenantUtils.getDataSource(name) ) {
            return TenantUtils.getDataSource(name);
        }
        DataSource dataSource = TenantUtils.createDataSourceByName(name,configRepo.findByName(name));
        if (null != dataSource ) {
            TenantUtils.addDataSource(name,dataSource);
        }
        return dataSource;
    }

    public Map<String, DataSource> getAll() {
        List<DataSourceConfig> configList = configRepo.findAll();
        Map<String, DataSource> result = new HashMap<>();
        for (DataSourceConfig config : configList) {
            DataSource dataSource = getDataSource(config.getName());
            result.put(config.getName(), dataSource);
        }
        return result;
    }
}


