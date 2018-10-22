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
	private SenderError sender;
	@Autowired
	private SenderInfo sender2;
	@Test
	public void test1(){
		while(true){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		this.sender.send("this is a msg from provider");
		this.sender2.send("this is a info msg from provider");
		}
	}
}
