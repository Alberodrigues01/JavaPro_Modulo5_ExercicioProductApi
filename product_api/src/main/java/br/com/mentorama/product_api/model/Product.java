package br.com.mentorama.product_api.model;



public class Product {

    private Integer id;
    private String name;

    // mQD corresponde à maxQuantityAvailable:
    private Integer mQA;

    private Double price;

    // mDP corresponde à maxDiscoutPercentage:
    private Double mDP;

    public Product(Integer id, String name, Integer mQA, Double price, Double mDP) {
        this.id = id;
        this.name = name;
        this.mQA = mQA;
        this.price = price;
        this.mDP = mDP;
    }

    //1)Obter preço com disconto:
    public Double getPriceWithDiscount(final Double discount) {
        if (discount > mDP) {
            return price * (1 - mDP);
        } else {
            return price * (1 - discount);
        }
    }

    //2) Adicionar uma quantidade de um produto:
    public int AddQuantity(Integer quantity) {

        return (mQA += quantity);
    }

    //3) Reduzindo uma quantidade de um produto:
    public int ReduceQuantity(Integer quantity) {

        if (mQA >= quantity) {
            return (mQA -= quantity);
        }
      return quantity = mQA;

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getmQA() {
        return mQA;
    }

    public void setmQA(Integer mQA) {
        this.mQA = mQA;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getmDP() {
        return mDP;
    }

    public void setmDP(Double mDP) {
        this.mDP = mDP;
    }
}

