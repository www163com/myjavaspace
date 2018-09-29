package com.billyang.girl.controller;

import com.billyang.girl.domain.DataSourceConfig;
import com.billyang.girl.domain.Girl;
import com.billyang.girl.domain.Result;
import com.billyang.girl.multitenant.TenantUtils;
import com.billyang.girl.repository.DataConfigRepository;
import com.billyang.girl.repository.GirlRepository;
import com.billyang.girl.service.DataConfigService;
import com.billyang.girl.service.GirlService;
import com.billyang.girl.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import javax.validation.Valid;
import java.util.List;

@RestController
public class DataConfigController {
    private final static Logger logger = LoggerFactory.getLogger(DataConfigController.class);
    @Autowired
    private DataConfigRepository dataConfigRepository;
    @Autowired
    private DataConfigService dataConfigService;
    /*
    * 查找数据源配置列表
    * */
    @GetMapping(value="/dataSourcesConfigList")
    public List<DataSourceConfig> girlList(){
        return dataConfigRepository.findAll();
    }
    /*
* 新增数据源配置
* */
    @PostMapping(value="/addDataSourcesConfig")
    public void addDataSourceConfig(@RequestParam Long id,@RequestParam String name,
                                    @RequestParam String url,@RequestParam String username,@RequestParam String password,
                                    @RequestParam String driverClassName,@RequestParam Boolean initialize){
        DataSourceConfig config = new DataSourceConfig();
        config.setId(id);
        config.setName(name);
        config.setUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName(driverClassName);
        config.setInitialize(initialize);
        config = dataConfigRepository.save(config);
        DataSource dataSource = null;
        try{
            dataSource = TenantUtils.createDataSourceByName(name,config);
        }catch(Exception e){
            logger.info(e.getMessage());
        }
        if(null !=dataSource){
            TenantUtils.addDataSource(name,dataSource);
            config.setInitialize(false);
            dataConfigRepository.save(config);
        }
    }
}
