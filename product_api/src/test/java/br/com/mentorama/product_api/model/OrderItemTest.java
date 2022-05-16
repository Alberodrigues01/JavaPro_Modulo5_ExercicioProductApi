package br.com.mentorama.product_api.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderItemTest {

    @Test
    public void shouldCalculateTotalPrice(){
        final Product product = new Product(01,
                                            "TV",
                                            3,
                                            3000.00,
                                            0.1);

        final OrderItem orderItem = new OrderItem(product,
                                                 2,
                                                 0.1);

        final Double result = orderItem.totalPrice();
        assertEquals(5400.00, result);
      }


}
