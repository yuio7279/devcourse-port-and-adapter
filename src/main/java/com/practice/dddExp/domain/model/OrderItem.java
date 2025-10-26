package com.practice.dddExp.domain.model;

import com.practice.dddExp.domain.vo.OrderItemSpec;

import java.util.UUID;

public class OrderItem {

    private String code;
    private OrderItemSpec spec;


    public OrderItem(OrderItemSpec spec) {
        validation(spec);
        this.code = UUID.randomUUID().toString();
        this.spec = spec;
    }

    private void validation(OrderItemSpec spec){
        Long price = spec.price();
        Long quantity = spec.quantity();
        String name = spec.name();

        if(price <= 0) throw new IllegalArgumentException("가격은 반드시 0원 이상이어야 합니다.");
        if(quantity <= 0) throw new IllegalArgumentException("수량은 반드시 1개 이상이어야 합니다.");
        if(name == null || name.isEmpty()) throw new IllegalArgumentException("이름을 반드시 정해야 합니다.");
    }

    public String getCode() {
        return code;
    }

    public OrderItemSpec getSpec() {
        return spec;
    }
}
