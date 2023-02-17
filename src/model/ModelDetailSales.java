package model;

public class ModelDetailSales {
    private int id;
    private int idSales;
    private int idProduct;
    private double priceUnit;
    private int quantity;
    private int discount;
    private double igv;
    private double subTotal;
    private double total;
    private String unitMeasure;
    
    public ModelDetailSales(){}

    public ModelDetailSales(int id, int idSales, int idProduct, double priceUnit, int quantity, int discount, double igv, double subTotal, double total, String unitMeasure) {
        this.id = id;
        this.idSales = idSales;
        this.idProduct = idProduct;
        this.priceUnit = priceUnit;
        this.quantity = quantity;
        this.discount = discount;
        this.igv = igv;
        this.subTotal = subTotal;
        this.total = total;
        this.unitMeasure = unitMeasure;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSales() {
        return idSales;
    }

    public void setIdSales(int idSales) {
        this.idSales = idSales;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public double getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(double priceUnit) {
        this.priceUnit = priceUnit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getUnitMeasure() {
        return unitMeasure;
    }

    public void setUnitMeasure(String unitMeasure) {
        this.unitMeasure = unitMeasure;
    }

}
