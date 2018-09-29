package com.billyang.girl.multitenant;

import com.billyang.girl.domain.DataSourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InitTenant {
    @Autowired
    ApplicationContext context;
    @PostConstruct
    public void init(){
        DataSourceConfigRepository configRepo= (DataSourceConfigRepository)context.getBean(DataSourceConfigRepository.class);
        List<DataSourceConfig> configList = configRepo.findAll();
        Map<String, DataSource> result = new HashMap<>();
        if (null != result && result.size() > 0) {
            for (DataSourceConfig config : configList) {
                DataSource ds = TenantUtils.createDataSourceByName(config.getName(),config);
                TenantUtils.addDataSource(config.getName(), ds);
            }
        }
    }
}
