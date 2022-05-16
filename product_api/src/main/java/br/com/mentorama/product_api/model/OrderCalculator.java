package br.com.mentorama.product_api.model;

import br.com.mentorama.product_api.repository.Order;

public class OrderCalculator {

    Order order;

    Double totalOrder;

    //5) Obtem o somatório dos totalPrice de cada Item da Ordem de Venda
    //   considerando as demais regras de desconto máximo e quantidade máxima.
    public Double calculateOrder (Order order) {
        return totalOrder = order.getItems().stream()
               .mapToDouble(OrderItem::totalPrice)
               .sum();
    }
}
