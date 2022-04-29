package br.com.mentorama.product_api.model;

import br.com.mentorama.product_api.repository.Order;

import java.util.List;

public class OrderCalculator {

    Double totalOrder;

    public Double calculateOrder (final Order order) {

        this.totalOrder = order.getItems().stream()
                .mapToDouble(OrderItem::totalPrice)
                .sum();
        return totalOrder;
    }


    public Double calculateMultipleOrders(List<Order> orders){
        return orders.stream()
                .mapToDouble(order -> calculateOrder(order))
                .sum();
    }

    public Double getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(Double totalOrder) {
        this.totalOrder = totalOrder;
    }
}
