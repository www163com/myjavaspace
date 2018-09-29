package com.billyang.testaop.testaopdemo.service;

import com.billyang.testaop.testaopdemo.domain.Product;
import com.billyang.testaop.testaopdemo.security.AdminOnly;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProductService2 {
    private static final Logger logger = LoggerFactory.getLogger(ProductService2.class);
    public void insert(Product product){
        //authService.checkAccess();
        logger.info("insert product2");
    }
    public void delete(Integer id){
        // authService.checkAccess();
        logger.info("delete product2");
    }
}
