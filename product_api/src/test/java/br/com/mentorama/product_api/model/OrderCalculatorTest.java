package br.com.mentorama.product_api.model;

import br.com.mentorama.product_api.repository.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderCalculatorTest {

    @Test
    public void shouldCalculateTotalOrderPrice() {

        final OrderCalculator orderCalculator = new OrderCalculator();
        final List<OrderItem> items = Arrays.asList(
                aOrderItem(1, 0.0, 3000.00, 0.2),
                aOrderItem(2, 0.5, 2500.00, 0.1)
        );
        Double result = orderCalculator.calculateOrder(new Order(items));
        assertEquals(7500.00, result);
    }

    private OrderItem aOrderItem(final Integer quantity,
                                 final Double discount,
                                 final Double price,
                                 final Double maxDiscountPercentage
    ) {
        Product product = new Product(01, "TV", 5, price, maxDiscountPercentage);
        return new OrderItem(product, quantity, discount);
    }
}

/*=====================================================
    Estudo Utilizando o Mock:
    private List<OrderItem> aListOfOrderItems(){
        return Arrays.asList(
                aOrderItem(3000.00),
                aOrderItem(5400.00)
        );
    }
    private OrderItem aOrderItem(final Double expectedValue){
        OrderItem orderItem = mock(OrderItem.class);
        when(orderItem.totalPrice()).thenReturn(expectedValue);
        return orderItem;
    }
==================================================================
*/

