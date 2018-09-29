package com.billyang.datalog.dao;

import com.billyang.datalog.domain.Action;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActionDao extends MongoRepository<Action,String> {
}
