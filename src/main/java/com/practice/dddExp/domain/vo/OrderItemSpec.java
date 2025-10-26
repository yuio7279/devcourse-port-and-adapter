package com.practice.dddExp.domain.vo;

public record OrderItemSpec(
        String name,
        String quantity,
        Long price,
        String currency
) {

}
