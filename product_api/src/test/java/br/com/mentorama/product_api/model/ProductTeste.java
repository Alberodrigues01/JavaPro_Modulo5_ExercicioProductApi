package br.com.mentorama.product_api.model;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ProductTeste {

    @Test
    public void shouldCalculateTotalPriceWithDiscount(){

        Product product = new Product(1,
                                     "TV",
                                     3,
                                     3000.00,
                                     0.1);

        Double result = product.getPriceWithDiscount(0.10);
        assertEquals(2700.00 , result);
    }

    @Test
    public void
    whenDiscountIsHigherThanMaxDiscountShouldUseMaxDiscountPercentage(){

        Product product = new Product(1,
                "TV",
                3,
                3000.00,
                0.1);

        Double result = product.getPriceWithDiscount(0.15);
        assertEquals(2700.00 , result);
    }

    @Test
    public void
    whenDiscountIsLowerThanMaxDiscountShouldUseMaxDiscountPercentage(){

        Product product = new Product(1,
                "TV",
                3,
                3000.00,
                0.1);

        Double result = product.getPriceWithDiscount(0.05);
        assertEquals(2850.00 , result);
    }

    @Test
    public void shouldAddQuantityIsCorretct(){

        Product product = new Product(1,
                "TV",
                3,
                3000.00,
                0.1);

        Integer result = product.AddQuantity(2);
        assertEquals(5 , result);
    }

    @Test
    public void
    whenQuantityToReduceIsHigherThanQuantityInStock(){

        Product product = new Product(1,
                "TV",
                3,
                3000.00,
                0.1);

        Integer result = product.ReduceQuantity(4);
        assertEquals(0 , result);
    }

    @Test
    public void
    whenQuantityToReduceIsLowerThanQuantityInStock(){

        Product product = new Product(1,
                "TV",
                3,
                3000.00,
                0.1);

        Integer result = product.ReduceQuantity(2);
        assertEquals(1  , result);
    }

}
