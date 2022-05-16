package br.com.mentorama.product_api.controller;

import br.com.mentorama.product_api.model.OrderItem;
import br.com.mentorama.product_api.repository.Order;
import br.com.mentorama.product_api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private Order order;

    @Autowired
    private OrderService orderService;

    //4) Cadastrar um ordem de venda:
    @PostMapping
    public ResponseEntity<OrderItem> postOrder(@RequestBody OrderItem orderItem){
        orderService.postOrder(orderItem);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
    //5) Listando as ordens:
    //@GetMapping
    //public ResponseEntity <List<OrderItem>> OrderItem () {
    //   return new ResponseEntity <>(orderService.listItems(), HttpStatus.OK);
    //}

    //6) Realizando o cálculo total de preço da Ordem:
    @GetMapping
    public ResponseEntity <Double> calculateOrder(){
    return new ResponseEntity<>(orderService.orderCalculator(), HttpStatus.OK);
   }
}
