package br.com.mentorama.product_api.controller;


import br.com.mentorama.product_api.model.OrderCalculator;
import br.com.mentorama.product_api.model.OrderItem;
import br.com.mentorama.product_api.model.Product;
import br.com.mentorama.product_api.repository.Order;
import br.com.mentorama.product_api.repository.ProductRepository;
import br.com.mentorama.product_api.service.ProductAndOrderApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    private ProductRepository productRepository;

    @Autowired
    private Order order;

    @Autowired
    private ProductAndOrderApiService productAndOrderApiService;



    //4) Cadastrar um ordem de venda:
    @PostMapping
    public ResponseEntity<OrderItem> postOrder(@RequestBody OrderItem orderItem){
        productAndOrderApiService.postOrder(orderItem);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
    //5) Listando as ordens:
    //@GetMapping
    //public ResponseEntity <List<OrderItem>> OrderItem () {
    //   return new ResponseEntity <>(productAndOrderApiService.listItems(), HttpStatus.OK);
    //}

    @GetMapping
    public ResponseEntity <Double> calculateOrder(){

       return new ResponseEntity<>(productAndOrderApiService.orderCalculator(), HttpStatus.OK);
    }
}
