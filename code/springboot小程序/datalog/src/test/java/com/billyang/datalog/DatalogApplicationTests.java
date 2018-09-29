package com.billyang.datalog;

import com.billyang.datalog.dao.ProductDao;
import com.billyang.datalog.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatalogApplicationTests {
	@Autowired
	ProductDao productDao;
	@Test
	public void contextLoads() {
	}
	@Test
	@Transactional
	public void testInsert(){
		Product product = new Product();
		product.setName("dell computer");
		product.setOnlineTime(new Date());
		product.setBuyPrice(new BigDecimal("29.5"));
		product.setCategory("computer");
		product.setDetail("this is a dell notebook");
		product.setUpdateTime(new Date());
		productDao.save(product);
		System.out.println("new product id:"+product.getId());
	}
	@Test
	public void testUpdate(){
		Product product = productDao.findOne(1L);
		product.setName("test-update");
		product.setOnlineTime(new Date());
		productDao.save(product);
	}
}
