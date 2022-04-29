package br.com.mentorama.product_api.controller;

import br.com.mentorama.product_api.model.OrderItem;
import br.com.mentorama.product_api.model.Product;
import br.com.mentorama.product_api.repository.Order;
import br.com.mentorama.product_api.repository.ProductRepository;
import br.com.mentorama.product_api.service.ProductApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/product")

public class ProductController {

    Order order;

    @Autowired
    private ProductApiService productApiService;

    private ProductRepository productRepository;

   //1) Listar o estoque de todos os produtos:
//  @GetMapping
//    public ResponseEntity <List<Product>> findAll() {
//       return new ResponseEntity<>(productApiService.findAll(), HttpStatus.OK);
//   }

    //2) Listar o estoque de um produto por id:
    @GetMapping ("/{id}")
    public ResponseEntity <Product> findById(@PathVariable ("id") Integer id) {
    return new ResponseEntity<>(productApiService.findById(id), HttpStatus.OK);
    }

    //3) Adicionar quantidade a um produto em estoque:
    @PutMapping ("/{id}/{quantity}")
    public void addStock(@PathVariable ("id") Integer id, @PathVariable ("quantity")
                                             Integer quantity){
                                             productApiService.addStock(id , quantity);
                                             }

    //4) Cadastrar um ordem de venda:
    @PostMapping
    public ResponseEntity <OrderItem > postOrder(@RequestBody OrderItem orderItem){
        productApiService.postOrder(orderItem);
        // Executa a "baixa" (reduce) em ProductRepository
        // contudo, não adiciona a ordemItem na List<OrderItem>
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    //5) Listando as ordens:
    @GetMapping
    public ResponseEntity <List<OrderItem>> getItems() {
        // Da mesma forma não lista uma orderItem, mesmo criando
        // um objeto (ord1) na Classe Order.
        return new ResponseEntity<>(order.getItems(), HttpStatus.OK);
    }




}
