package com.billyang.framework.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

/**   
*    
* 项目名称：mybatis-shiro3   
* 类名称：DruidConfig   
* 类描述：   Druid数据库信息配置加载
* 创建人：yangcan14944   
* 创建时间：2018-11-15 下午4:31:49   
* 修改人：yangcan14944   
* 修改时间：2018-11-15 下午4:31:49   
* 修改备注：   
* @version    
*    
*/
@Configuration
public class DruidConfig {

	private static final Logger log = LoggerFactory.getLogger(DruidConfig.class);
	@Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Value("${spring.datasource.initialSize}")
    private int initialSize;

    @Value("${spring.datasource.minIdle}")
    private int minIdle;

    @Value("${spring.datasource.maxActive}")
    private int maxActive;

    @Value("${spring.datasource.maxWait}")
    private int maxWait;

    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;

    @Value("${spring.datasource.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.testOnReturn}")
    private boolean testOnReturn;

    @Value("${spring.datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${spring.datasource.filters}")
    private String filters;

    @Value("{spring.datasource.connectionProperties}")
    private String connectionProperties;
    @Bean(initMethod="init",destroyMethod="close")
    public DataSource dataSource(){
    	DruidDataSource dataSource = new DruidDataSource();
    	dataSource.setUrl(this.dbUrl);
    	dataSource.setUsername(username);
    	dataSource.setPassword(password);
    	dataSource.setDriverClassName(driverClassName);
        /** configuration */
    	dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxWait(maxWait);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        try
        {
        	dataSource.setFilters(filters);
        }
        catch (SQLException e)
        {
            log.error("druid configuration initialization filter", e);
        }
        dataSource.setConnectionProperties(connectionProperties);
    	return dataSource;
    }
}
