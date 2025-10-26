package com.practice.dddExp.domain.model;

import com.practice.dddExp.domain.vo.OrderItemSpec;

import java.util.UUID;

public class OrderItem {

    private String code;
    private OrderItemSpec spec;


    public OrderItem(OrderItemSpec spec) {
        this.code = UUID.randomUUID().toString();
        this.spec = spec;
    }


    public String getCode() {
        return code;
    }

    public OrderItemSpec getSpec() {
        return spec;
    }
}
