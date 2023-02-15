package model;

public class ModelProducts {
    private int id;
    private int idTypeProduct;
    private String barCode;
    private String title;
    private String description;
    private float discount;
    private float utility;
    private int stock;
    private int stockMinimun;
    private double priceShopping;
    private double priceSale;
    private boolean forStock;
    private boolean state;
    
    public ModelProducts(){}

    public ModelProducts(int id, int idTypeProduct, String barCode, String title, String description, float discount, float utility, int stock, int stockMinimun, double priceShopping, double priceSale, boolean forStock, boolean state) {
        this.id = id;
        this.idTypeProduct = idTypeProduct;
        this.barCode = barCode;
        this.title = title;
        this.description = description;
        this.discount = discount;
        this.utility = utility;
        this.stock = stock;
        this.stockMinimun = stockMinimun;
        this.priceShopping = priceShopping;
        this.priceSale = priceSale;
        this.forStock = forStock;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTypeProduct() {
        return idTypeProduct;
    }

    public void setIdTypeProduct(int idTypeProduct) {
        this.idTypeProduct = idTypeProduct;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getUtility() {
        return utility;
    }

    public void setUtility(float utility) {
        this.utility = utility;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStockMinimun() {
        return stockMinimun;
    }

    public void setStockMinimun(int stockMinimun) {
        this.stockMinimun = stockMinimun;
    }

    public double getPriceShopping() {
        return priceShopping;
    }

    public void setPriceShopping(double priceShopping) {
        this.priceShopping = priceShopping;
    }

    public double getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(double priceSale) {
        this.priceSale = priceSale;
    }

    public boolean isForStock() {
        return forStock;
    }

    public void setForStock(boolean forStock) {
        this.forStock = forStock;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
    
    
}
