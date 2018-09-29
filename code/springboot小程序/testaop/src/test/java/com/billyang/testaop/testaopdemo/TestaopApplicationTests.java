package com.billyang.testaop.testaopdemo;

import com.billyang.testaop.testaopdemo.domain.Product;
import com.billyang.testaop.testaopdemo.security.CurrentUserHolder;
import com.billyang.testaop.testaopdemo.service.ExecutionService;
import com.billyang.testaop.testaopdemo.service.ProductService;
import com.billyang.testaop.testaopdemo.service.ProductService2;
import com.billyang.testaop.testaopdemo.service.ProductService3;
import com.billyang.testaop.testaopdemo.service.sub.SubExecutionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestaopApplicationTests {
	@Autowired
	ProductService productService;
	@Autowired
	ProductService2 productService2;
	@Autowired
	ProductService3 productService3;
	@Autowired
	ExecutionService executionService;
	@Autowired
	SubExecutionService subExecutionService;
	@Test
	public void contextLoads() {
	}
    @Test(expected = Exception.class)
	public void annoInsertTest(){
		CurrentUserHolder.set("tom");
		productService.delete(1);
	}
	@Test
	public void adminInsertTest(){
		CurrentUserHolder.set("admin");
		productService.delete(1);
	}
	@Test
	public void pkgMatchTest(){
		productService2.delete(1);
		productService2.insert(new Product());
	}
	@Test
	public void objMatchTest(){
		productService3.delete(1);
	}
	@Test
	public void executionMatchTest(){
		executionService.log1();
		executionService.log2();
		executionService.log3();
		subExecutionService.log();
	}
}
