package model;

public class ModelShopping {
    private int id;
    private int idUser;
    private int idSupplier;
    private int idVoucher;
    private double total;
    private double subTotal;
    private double igv;
    private double discount;
    private String numberVoucher;
    private String serie;
    
    public ModelShopping(){}

    public ModelShopping(int id, int idUser, int idSupplier, int idVoucher, double total, double subTotal, double igv, double discount, String numberVoucher, String serie) {
        this.id = id;
        this.idUser = idUser;
        this.idSupplier = idSupplier;
        this.idVoucher = idVoucher;
        this.total = total;
        this.subTotal = subTotal;
        this.igv = igv;
        this.discount = discount;
        this.numberVoucher = numberVoucher;
        this.serie = serie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    public int getIdVoucher() {
        return idVoucher;
    }

    public void setIdVoucher(int idVoucher) {
        this.idVoucher = idVoucher;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getNumberVoucher() {
        return numberVoucher;
    }

    public void setNumberVoucher(String numberVoucher) {
        this.numberVoucher = numberVoucher;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    
}
