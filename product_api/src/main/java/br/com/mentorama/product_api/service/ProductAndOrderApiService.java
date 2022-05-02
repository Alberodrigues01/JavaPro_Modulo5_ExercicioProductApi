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
public class ProductAndOrderApiService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private Order order;

    private OrderCalculator orderCalculator;

    private OrderItem orderItem;


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

        }

    //5) Listando as OrderItem:
    public List<OrderItem> listItems(){

        return order.getItems();
    }

    //6) Obtendo o valor total de uma Ordem:
    //Deve retornar o totalOrder especificado na Classe OrderCalculator método calculateOrder
    public Double calculateOrder (Order order) {
        return orderCalculator.calculateOrder(order);
    }



}
