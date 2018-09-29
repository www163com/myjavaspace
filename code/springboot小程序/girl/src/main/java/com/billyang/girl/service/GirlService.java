package com.billyang.girl.service;

import com.billyang.girl.domain.Girl;
import com.billyang.girl.enums.ResultEnum;
import com.billyang.girl.exception.GirlException;
import com.billyang.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {
    @Autowired
    public GirlRepository girlRepository;
    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("B");
        girlA.setAge(18);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("BBBB");
        girlB.setAge(18);
        girlRepository.save(girlB);
    }
    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if(age<10){
            //返回"你还在上小学吧" code=100
//            throw new Exception("你还在上小学吧");
//            throw new GirlException(100,"你还在上小学吧");
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age>10 && age<16){
            //返回"你正在上初中" code=101
//            throw new Exception("你还在上初中吧");
//            throw new GirlException(101,"你还在上初中吧");
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }
    public Girl findOne(Integer id){
        return girlRepository.findOne(id);
    }
}
