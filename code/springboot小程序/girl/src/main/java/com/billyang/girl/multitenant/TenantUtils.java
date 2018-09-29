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
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.util.*;

//多数据库工具类
public class TenantUtils {
    private static Logger log = LoggerFactory.getLogger(TenantDataSource.class);
    @Autowired
    private TenantProperties tenantProperties;
    @Autowired
    private DataSourceConfigRepository configRepo;
    static Map<String, DataSource> map = new HashMap<>();
    //添加一个数据源
    public static void addDataSource(String dataSourceName, DataSource dataSource ){
        if(!map.keySet().contains(dataSourceName)){
            map.put(dataSourceName,dataSource);
        }
    }
    //获取一个数据源
    public static DataSource getDataSource(String dataSourceName){
        if(StringUtils.isNotBlank(dataSourceName)){
            return map.get(dataSourceName);
        }else{
            return map.get(dataSourceName);
        }
    }
    public static void addDataSourceMap(Map<String,DataSource> dataSourceMap){
        if(null!=dataSourceMap){
            map.putAll(dataSourceMap);
        }
    }
    public static ComboPooledDataSource createDateSource(String databasesName, String username, String password){
        ComboPooledDataSource defaultDataSource = new ComboPooledDataSource(databasesName);
        Properties properties = PropertityUtils.loadProperties("jdbc.properties");
        if (StringUtils.isNotBlank(databasesName)){
            defaultDataSource.setDataSourceName(databasesName);
            defaultDataSource.setJdbcUrl(properties.getProperty("jdbc.url.prefix")
                    + databasesName + properties.getProperty("jdbc.url.suffix"));
        } else {
            defaultDataSource.setDataSourceName(properties.getProperty("jdbc.databaseName"));
            defaultDataSource.setJdbcUrl(properties.getProperty("jdbc.url"));
        }
        if (StringUtils.isNotBlank(username)){
            defaultDataSource.setUser(username);
        } else {
            defaultDataSource.setUser(properties.getProperty("jdbc.username"));
        }
        if (StringUtils.isNotBlank(password)){
            defaultDataSource.setPassword(password);
        } else {
            defaultDataSource.setPassword(properties.getProperty("jdbc.password"));
        }

        defaultDataSource.setInitialPoolSize(5);
        defaultDataSource.setMaxConnectionAge(100);
        try {
            defaultDataSource.setDriverClass(properties.getProperty("jdbc.driverClassName"));
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        log.info("数据库初始化信息：url={}", defaultDataSource.getJdbcUrl());
        log.info("               ：username={}", defaultDataSource.getUser());
        log.info("               ：password={}", defaultDataSource.getPassword());
        log.info("               ：driverClass={}", defaultDataSource.getDriverClass());
        return defaultDataSource;
    }
    public static DataSource createDataSourceByName(String name,DataSourceConfig config) {
        if (config != null) {
            DataSourceBuilder factory = DataSourceBuilder
                    .create().driverClassName(config.getDriverClassName())
                    .username(config.getUsername())
                    .password(config.getPassword())
                    .url(config.getUrl());
            DataSource ds = factory.build();
            if (config.getInitialize()) {
                initialize(ds,name);
            }
            return ds;
        }
        return null;
    }
    private static void initialize(DataSource dataSource,String databaseName) {
//        ClassPathResource schemaResource = new ClassPathResource("schema.sql");
//        ClassPathResource dataResource = new ClassPathResource("data.sql");
//        ResourceDatabasePopulator populator = new ResourceDatabasePopulator(schemaResource, dataResource);
        // populator.execute(dataSource);
        try {
            dataSource = TenantUtils.createDateSource(null, null, null);
            JdbcTemplate template = getTemplate(dataSource);
            String sql = "CREATE DATABASE IF NOT EXISTS `"+databaseName+"` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;";
            template.execute(sql);
            ComboPooledDataSource newDateSource = TenantUtils.createDateSource(databaseName, null, null);
            template.setDataSource(newDateSource);
            template.execute("use `" + databaseName +"`");
            template.batchUpdate(loadSql());
            log.info("创建数据库[{}]成功", databaseName);
        }catch(DataAccessException e){
            log.error(e.getMessage());
        }
    }
    private static JdbcTemplate getTemplate(DataSource dataSource) {
        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(dataSource);
        return template;
    }
    private static String[] loadSql(){
        String[] result = new String[0];
        try {
            Resource resource = new ClassPathResource("news.sql");
            File resourceFile = resource.getFile();
            if (resourceFile.canRead()){
                List<String> lines = FileUtils.readLines(resourceFile,"UTF-8");
                List<String> tmp = new ArrayList<String>();
                StringBuilder sb = new StringBuilder();
                for (String sql : lines) {
                    sb.append(sql);
                    if (sb.indexOf(";") != -1){
                        tmp.add(sb.toString());
                        sb.delete(0, sb.length());
                    }
                }
                return tmp.toArray(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
