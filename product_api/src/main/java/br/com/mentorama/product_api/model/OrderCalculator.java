package br.com.mentorama.product_api.model;

import br.com.mentorama.product_api.repository.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.List;


public class OrderCalculator {

    OrderItem orderItem;

    Double totalOrder;


    //Deve obter o somatório dos totalPrice
    public Double calculateOrder (Order order) {
        return totalOrder =  order.getItems().stream()
               .mapToDouble(OrderItem::totalPrice)
               .sum();
    }

    //public Double calculateMultipleOrders(final List<Order> orders){
     //  return orders.stream()
    //          .mapToDouble(order -> calculateOrder(order))
    //          .sum();
    //}

  }
