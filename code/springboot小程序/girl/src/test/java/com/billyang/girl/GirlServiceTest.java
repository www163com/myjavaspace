package com.billyang.girl;

import com.billyang.girl.domain.Girl;
import com.billyang.girl.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {
    @Autowired
    private GirlService girlService;
    @Test
    public void findOneTest(){
        Girl girl = girlService.findOne(400);
        Assert.assertEquals(new Integer(14),girl.getAge());
    }
}
