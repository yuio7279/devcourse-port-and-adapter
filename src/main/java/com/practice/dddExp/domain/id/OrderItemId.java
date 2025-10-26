package com.practice.dddExp.domain.id;

import java.util.UUID;

public record OrderItemId(UUID value) {
    public OrderItemId {
        if (value == null) throw new IllegalArgumentException("OrderItemId cannot be null");
    }

    public static OrderItemId newId() {
        return new OrderItemId(UUID.randomUUID());
    }
}