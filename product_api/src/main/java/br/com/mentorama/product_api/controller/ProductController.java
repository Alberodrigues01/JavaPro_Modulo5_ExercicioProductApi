package br.com.mentorama.product_api.controller;

import br.com.mentorama.product_api.model.Product;
import br.com.mentorama.product_api.repository.ProductRepository;
import br.com.mentorama.product_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/product")

public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;


  //1) Listar o estoque de todos os produtos:
  @GetMapping
    public ResponseEntity <List<Product>> findAll() {
    return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    //2) Listar o estoque de um produto por id:
    @GetMapping ("/{id}")
    public ResponseEntity <Product> findById(@PathVariable ("id") Integer id) {
    return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    //3) Adicionar quantidade a um produto em estoque:
    @PutMapping ("/{id}/{quantity}")
    public void addStock(@PathVariable ("id") Integer id,
                         @PathVariable ("quantity") Integer quantity){
                         productService.addStock(id , quantity);
                         }


}
