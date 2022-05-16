package br.com.mentorama.product_api.service;

import br.com.mentorama.product_api.model.OrderCalculator;
import br.com.mentorama.product_api.model.OrderItem;
import br.com.mentorama.product_api.repository.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    Double totalOrder;

    @Autowired
    private Order order;

    private OrderCalculator orderCalculator;

    private OrderItem orderItem;


    //1) Cadastrando uma ordem de venda:
    public void postOrder(OrderItem orderItem) {

        order.postOrder(orderItem);
    }

    //2) Listando as OrderItem:
    public List<OrderItem> listItems() {

        return order.getItems();
    }

    //3) Obtendo o valor total de uma Ordem:
    public Double orderCalculator() {
      this.orderCalculator = new OrderCalculator();
          return orderCalculator.calculateOrder(order);
    }
}
