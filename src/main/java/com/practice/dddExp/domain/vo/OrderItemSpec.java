package com.practice.dddExp.domain.vo;

public record OrderItemSpec(
        String name,
        Long quantity,
        Long price,
        String currency
) {

}
