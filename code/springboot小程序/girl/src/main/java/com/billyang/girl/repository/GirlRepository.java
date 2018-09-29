package com.billyang.girl.repository;

import com.billyang.girl.domain.Girl;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;
@RepositoryRestController
public interface GirlRepository extends JpaRepository<Girl,Integer>{
    //通过年龄来查询
    public List<Girl> findByAge(Integer age);
}
