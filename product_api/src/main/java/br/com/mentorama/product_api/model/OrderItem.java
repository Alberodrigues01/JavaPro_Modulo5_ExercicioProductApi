package br.com.mentorama.product_api.model;


public class OrderItem {


    private Product product;

    private Integer id;
    private Integer quantity;
    private Double discount;

    public OrderItem(Product product, Integer quantity, Double discount) {
        this.product = product;
        this.quantity = quantity;
        this.discount = discount;

    }

      public Double totalPrice(){

       OrderItem orderItem = new OrderItem(product , quantity, discount);

       return product.getPriceWithDiscount(discount);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount){
        this.discount = discount;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }


}
