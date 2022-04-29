package br.com.mentorama.product_api.service;

import br.com.mentorama.product_api.model.OrderCalculator;
import br.com.mentorama.product_api.model.OrderItem;
import br.com.mentorama.product_api.model.Product;
import br.com.mentorama.product_api.repository.Order;
import br.com.mentorama.product_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductApiService {

    @Autowired

    private ProductRepository productRepository;

    private OrderItem orderItem;

    private Order order;

    private OrderCalculator orderCalculator;


    //1) Listando todos os produtos
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    //2) Buscando um produto por Id:
    public Product findById(Integer id) {
        return productRepository.findById(id);
    }

    //3) Adiconando uma quantidade no estoque do produto:
    public void addStock(Integer id, Integer quantity) {
        productRepository.addStock(id, quantity);
    }

    //4) Cadastrando uma ordem de venda:
    public void postOrder(OrderItem orderItem) {

            order.postOrder(orderItem);
            productRepository.reduceStock(orderItem.getId(), orderItem.getQuantity());
            //return orderItem.getId();

        }

    //5) Listando as OrderItem:
    public List<OrderItem> getItems(){
        return order.getItems();
    }

    //6) Obtendo o valor total de uma Ordem:
    public Double  calculateOrder(){
        return orderCalculator.getTotalOrder();
    }

}
