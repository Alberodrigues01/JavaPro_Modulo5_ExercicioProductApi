package br.com.mentorama.product_api.repository;

import br.com.mentorama.product_api.model.OrderItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Order {

    public OrderItem orderItem;

    private List<OrderItem> items;

    public Order(List<OrderItem>items){
        this.items = items;
    }

    //1) Adicionando item a uma Ordem de Venda:
    public void postOrder(OrderItem orderItem) {

        this.items.add(orderItem);
               }

    //2) Obtendo os items de uma Ordem de Venda:
    public List<OrderItem> getItems() {
        return items;
    }



 }











