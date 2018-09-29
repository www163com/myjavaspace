package com.billyang.datalog.dao;

import com.billyang.datalog.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Long> {
    public Product findById(Long id);
}
