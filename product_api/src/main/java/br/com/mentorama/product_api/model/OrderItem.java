package br.com.mentorama.product_api.model;


public class OrderItem {

    private Product product;
    private Integer id;
    private Integer quantity;
    private Double discount;

    public OrderItem( Integer id, Integer quantity, Double discount) {
        this.id = id; ;
        this.quantity = quantity;
        this.discount = discount;

    }

    public Double totalPrice(){
        return product.getPriceWithDiscount(discount) * quantity;
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

    public Integer getId(){
        return id;}

    public void setId(Integer id){
        this.id = id;
    }


}
