package br.com.mentorama.product_api.repository;

import br.com.mentorama.product_api.model.OrderItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class Order {


    private List<OrderItem> items;


            public Order () {
                this.items = new ArrayList<>();

                OrderItem ord1 = new OrderItem(1, 3, 5.00);

                items.add(ord1);
            }



    //1) Adicionando item a uma Ordem de Venda:
    public Integer postOrder(OrderItem orderItem){
          this.items.add(orderItem);
          return orderItem.getId();

    }

    //2) Obtendo os items de uma Ordem de Venda:
    public List<OrderItem> getItems() {
        return items;
    }




}
