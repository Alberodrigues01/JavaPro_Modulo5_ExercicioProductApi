package br.com.mentorama.product_api.service;

import br.com.mentorama.product_api.model.Product;
import br.com.mentorama.product_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

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

}
