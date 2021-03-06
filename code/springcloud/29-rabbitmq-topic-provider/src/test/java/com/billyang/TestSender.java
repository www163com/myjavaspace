package com.billyang;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App29.class)
public class TestSender {
	@Autowired
	private OrderSender orderSender;
	@Autowired
	private ProductSender productSender;
	@Autowired
	private UserSender userSender;
	@Test
	public void test1(){
		this.orderSender.send("UserSender...");
		this.productSender.send("ProductSender...");
		this.userSender.send("OrderSender...");
	}
}
