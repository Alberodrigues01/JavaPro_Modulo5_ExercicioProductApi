package br.com.mentorama.product_api.model;

public class Product {

    private Integer productID;
    private String nameProduct;
    private Integer quantityInStock;
    private Double price;
    private Double maxDiscountPercentage;

    public Product(Integer productID, String nameProduct, Integer quantityInStock, Double price, Double maxDiscountPercentage) {
        this.productID = productID;
        this.nameProduct = nameProduct;
        this.quantityInStock = quantityInStock;
        this.price = price;
        this.maxDiscountPercentage = maxDiscountPercentage;
    }

    //1)Obter o preço aplicando a regra da Percentagem Máxima
    // de Desconto permitida (maxDiscountPercentage):
    public Double getPriceWithDiscount(final Double discount) {
        if (discount > maxDiscountPercentage) {
            return price * (1.00 - maxDiscountPercentage);
        } else {
            return price * (1.00 - discount);
        }
    }

    //2) Adiciona uma quantidade de um produto:
    public int AddQuantity(Integer quantity) {

        return (quantityInStock += quantity);
    }

    //3) Reduzuz uma quantidade de um produto:
    public int ReduceQuantity(Integer quantity) {

        if (quantityInStock >= quantity) {
            return (quantityInStock -= quantity);
        }
      return (quantityInStock - quantityInStock);

    }

   public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getMaxDiscountPercentage() {
        return maxDiscountPercentage;
    }

    public void setMaxDiscountPercentage(Double maxDiscountPercentage) {
        this.maxDiscountPercentage = maxDiscountPercentage;
    }
}

