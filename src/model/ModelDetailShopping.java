package model;

public class ModelDetailShopping {
    private int id; 
    private int idShopping;
    private int idProduct;
    private int quantity;
    private double priceSales;
   private double priceShopping;
   
   public ModelDetailShopping(){}

    public ModelDetailShopping(int id, int idShopping, int idProduct, int quantity, double priceSales, double priceShopping) {
        this.id = id;
        this.idShopping = idShopping;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.priceSales = priceSales;
        this.priceShopping = priceShopping;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdShopping() {
        return idShopping;
    }

    public void setIdShopping(int idShopping) {
        this.idShopping = idShopping;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPriceSales() {
        return priceSales;
    }

    public void setPriceSales(double priceSales) {
        this.priceSales = priceSales;
    }

    public double getPriceShopping() {
        return priceShopping;
    }

    public void setPriceShopping(double priceShopping) {
        this.priceShopping = priceShopping;
    }

}
