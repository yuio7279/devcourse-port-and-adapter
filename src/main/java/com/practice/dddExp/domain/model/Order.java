package com.practice.dddExp.domain.model;


import com.practice.dddExp.domain.vo.Money;
import com.practice.dddExp.domain.id.OrderId;
import com.practice.dddExp.domain.vo.OrderItemSpec;

import java.util.List;

public class Order {
    private OrderId id;
    private List<OrderItem> items;
    private Money totalPrice;

    public Order(OrderId id, List<OrderItem> items) {
        this.id = id;
        this.items = items;
        Money calculateTotal = getTotalPrice(items);
        if(calculateTotal.amount() <= 0 ) throw new IllegalArgumentException("총 금액은 0원 이상이어야 합니다.");
        this.totalPrice = calculateTotal;
    }

    private Money getTotalPrice(List<OrderItem> items) {
        Long sum = 0L;
        for (OrderItem item : items){
            OrderItemSpec itemSpec = item.getSpec();
            if( !itemSpec.currency().equals("KRW") ){
                throw new IllegalArgumentException("통화가 달라 계산할 수 없습니다.");
            }
            sum += itemSpec.price();
        }
        return new Money(sum, "KRW");
    }
}
