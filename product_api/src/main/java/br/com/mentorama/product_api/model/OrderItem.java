package br.com.mentorama.product_api.model;

public class OrderItem {

    private Product product;
    private Integer quantity;
    private Double discount;

    public OrderItem(Product product , Integer quantity, Double discount) {
        this.product = product;
        this.quantity = quantity;
        this.discount = discount;
    }

      //4) Calcula o preço final de um Item da venda aplicando a regra da
      //   do preço com desconto * quantidade disponível em estoque (quantityInStock):
      public Double totalPrice() {
          if (quantity <= product.getQuantityInStock()) {
              return (product.getPriceWithDiscount(discount) * quantity);
          } else {
              return (product.getPriceWithDiscount(discount)* product.getQuantityInStock());
          }
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

}
