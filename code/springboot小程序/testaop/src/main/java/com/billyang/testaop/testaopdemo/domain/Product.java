package com.billyang.testaop.testaopdemo.domain;

import org.springframework.stereotype.Component;

@Component
public class Product {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
