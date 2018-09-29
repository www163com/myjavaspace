package com.billyang.girl.repository;

import com.billyang.girl.domain.DataSourceConfig;
import com.billyang.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

@RepositoryRestController
public interface DataConfigRepository extends JpaRepository<DataSourceConfig,Integer>{
    //通过年龄来查询
    public List<DataSourceConfig> findByName(String name);
}
