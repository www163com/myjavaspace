package com.billyang.girl.service;

import com.billyang.girl.domain.DataSourceConfig;
import com.billyang.girl.domain.Girl;
import com.billyang.girl.enums.ResultEnum;
import com.billyang.girl.exception.GirlException;
import com.billyang.girl.repository.DataConfigRepository;
import com.billyang.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DataConfigService {
    @Autowired
    public DataConfigRepository dataConfigRepository;
    public DataSourceConfig findOne(Integer id){
        return dataConfigRepository.findOne(id);
    }
}
