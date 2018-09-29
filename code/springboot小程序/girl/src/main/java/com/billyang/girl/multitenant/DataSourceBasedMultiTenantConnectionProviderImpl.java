package com.billyang.girl.multitenant;

import com.billyang.girl.domain.DataSourceConfig;
import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.billyang.girl.multitenant.MultiTenantConstants.DEFAULT_TENANT_ID;

@Component
public class DataSourceBasedMultiTenantConnectionProviderImpl extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {
    @Autowired
    DataSource defaultDS;

    @Autowired
    ApplicationContext context;
    @Autowired
    private TenantProperties tenantProperties;
    boolean init = false;

    @PostConstruct
    public void load() {
//        DataSourceConfigRepository configRepo= (DataSourceConfigRepository)context.getBean(DataSourceConfigRepository.class);
//        List<DataSourceConfig> configList = configRepo.findAll();
//        Map<String, DataSource> result = new HashMap<>();
//        if (null != result && result.size() > 0) {
//            for (DataSourceConfig config : configList) {
//                DataSource ds = TenantUtils.createDataSourceByName(config.getName(),config);
//                TenantUtils.addDataSource(config.getName(), ds);
//            }
//        }
        //(OSSVideoRepository)event.getApplicationContext().getBean(OSSVideoRepository.class);
 //       System.out.println("AAAAAAAACCCCCCSSSSSSSSS");
        TenantUtils.addDataSource(tenantProperties.getDefaultTenantName(), defaultDS);
    }


    @Override
    protected DataSource selectAnyDataSource() {
        return TenantUtils.getDataSource(tenantProperties.getDefaultTenantName());
    }

    @Override
    protected DataSource selectDataSource(String tenantIdentifier) {
        if (!init) {
            init = true;
            TenantDataSource tenantDataSource = context.getBean(TenantDataSource.class);
            TenantUtils.addDataSourceMap(tenantDataSource.getAll());
            // map.putAll(tenantDataSource.getAll());
        }
        return TenantUtils.getDataSource(tenantIdentifier);
    }
}
