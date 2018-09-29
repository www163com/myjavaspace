package com.billyang.girl.multitenant;

import com.billyang.girl.domain.DataSourceConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface DataSourceConfigRepository extends JpaRepository<DataSourceConfig,Long>{
    @Override
    DataSourceConfig findOne(Long aLong);
    DataSourceConfig findByName(String name);
}

