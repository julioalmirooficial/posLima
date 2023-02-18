package model;

public class ModelBox {
    private int id;
    private int idUser;
    private String openingDate;
    private String clodingDate;
    private double amountOPen;
    private double amountClosing;
    private double amountTransfer;
    private double amountCheque;
    private double amountCash;
    private double amountVisa;
    private boolean state;
    public ModelBox(){}

    public ModelBox(int id, int idUser, String openingDate, String clodingDate, double amountOPen, double amountClosing, double amountTransfer, double amountCheque, double amountCash, double amountVisa, boolean state) {
        this.id = id;
        this.idUser = idUser;
        this.openingDate = openingDate;
        this.clodingDate = clodingDate;
        this.amountOPen = amountOPen;
        this.amountClosing = amountClosing;
        this.amountTransfer = amountTransfer;
        this.amountCheque = amountCheque;
        this.amountCash = amountCash;
        this.amountVisa = amountVisa;
        this.state = state;
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

    public String getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
    }

    public String getClodingDate() {
        return clodingDate;
    }

    public void setClodingDate(String clodingDate) {
        this.clodingDate = clodingDate;
    }

    public double getAmountOPen() {
        return amountOPen;
    }

    public void setAmountOPen(double amountOPen) {
        this.amountOPen = amountOPen;
    }

    public double getAmountClosing() {
        return amountClosing;
    }

    public void setAmountClosing(double amountClosing) {
        this.amountClosing = amountClosing;
    }

    public double getAmountTransfer() {
        return amountTransfer;
    }

    public void setAmountTransfer(double amountTransfer) {
        this.amountTransfer = amountTransfer;
    }

    public double getAmountCheque() {
        return amountCheque;
    }

    public void setAmountCheque(double amountCheque) {
        this.amountCheque = amountCheque;
    }

    public double getAmountCash() {
        return amountCash;
    }

    public void setAmountCash(double amountCash) {
        this.amountCash = amountCash;
    }

    public double getAmountVisa() {
        return amountVisa;
    }

    public void setAmountVisa(double amountVisa) {
        this.amountVisa = amountVisa;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
    
}
