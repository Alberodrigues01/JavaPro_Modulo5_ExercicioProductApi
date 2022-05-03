package br.com.mentorama.product_api.repository;

import br.com.mentorama.product_api.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {


    private  final List<Product> products;

        public ProductRepository (){

        this.products = new ArrayList<>();

        Product prod1 = new Product(01 , "TV", 10, 3000.00,0.9 );
        Product prod2 = new Product(02 , "Geladeira", 20 , 1500.00 , 0.9);
        Product prod3 = new Product(03 , "Fogão", 30, 1000.00, 0.9);

        products.add(prod1);
        products.add(prod2);
        products.add(prod3);

    }

    //1) Listar todos os produtos:
    public List<Product> findAll() {
        return products;
    }

    //2) Localizar um produto pelo ID:
    public Product findById (Integer id) {
        return products.stream()
                .filter(prd -> prd.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    //3) Adicionando uma quantidade a um produto no repositório (Entrada/Compra em Estoque):
    public void addStock (Integer id, Integer quantity) {

        products.stream()
                .filter(prd -> prd.getId().equals(id))
                .forEach(prd-> prd.AddQuantity(quantity));

    }

    //4) Reduzindo uma quantidade de um produto no repositório (Saída/Venda de Estoque):
    public void reduceStock (Integer id , Integer quantity){
                products.stream()
                .filter(prd -> prd.getId().equals(id))
                .forEach(prd -> prd.ReduceQuantity(quantity));

    }

}



