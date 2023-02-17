package model;

public class ModelSales {
    private int id;
    private int idUser;
    private int idCustomer;
    private int idVoucher;
    private String numberVoucher;
    private String serie;
    private String typePayment;
    private String numberOperation;
    private String entityBank;
    private double total;
    private double subTotal;
    private double igv;
    private double igvAplicate;
    private double amountPaid;
    private double amountReturn;
    
    public ModelSales(){}

    public ModelSales(int id, int idUser, int idCustomer, int idVoucher, String numberVoucher, String serie, String typePayment, String numberOperation, String entityBank, double total, double subTotal, double igv, double igvAplicate, double amountPaid, double amountReturn) {
        this.id = id;
        this.idUser = idUser;
        this.idCustomer = idCustomer;
        this.idVoucher = idVoucher;
        this.numberVoucher = numberVoucher;
        this.serie = serie;
        this.typePayment = typePayment;
        this.numberOperation = numberOperation;
        this.entityBank = entityBank;
        this.total = total;
        this.subTotal = subTotal;
        this.igv = igv;
        this.igvAplicate = igvAplicate;
        this.amountPaid = amountPaid;
        this.amountReturn = amountReturn;
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

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdVoucher() {
        return idVoucher;
    }

    public void setIdVoucher(int idVoucher) {
        this.idVoucher = idVoucher;
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

    public String getTypePayment() {
        return typePayment;
    }

    public void setTypePayment(String typePayment) {
        this.typePayment = typePayment;
    }

    public String getNumberOperation() {
        return numberOperation;
    }

    public void setNumberOperation(String numberOperation) {
        this.numberOperation = numberOperation;
    }

    public String getEntityBank() {
        return entityBank;
    }

    public void setEntityBank(String entityBank) {
        this.entityBank = entityBank;
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

    public double getIgvAplicate() {
        return igvAplicate;
    }

    public void setIgvAplicate(double igvAplicate) {
        this.igvAplicate = igvAplicate;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public double getAmountReturn() {
        return amountReturn;
    }

    public void setAmountReturn(double amountReturn) {
        this.amountReturn = amountReturn;
    }
    
}
