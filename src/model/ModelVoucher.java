package model;

public class ModelVoucher {
    private int id;
    private String voucher;
    private String serie;
    private String numberStart;
    private String numberCurrent;
    private String numberEnd;
    private boolean state;
    
    public ModelVoucher(){}

    public ModelVoucher(int id, String voucher, String serie, String numberStart, String numberCurrent, String numberEnd, boolean state) {
        this.id = id;
        this.voucher = voucher;
        this.serie = serie;
        this.numberStart = numberStart;
        this.numberCurrent = numberCurrent;
        this.numberEnd = numberEnd;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumberStart() {
        return numberStart;
    }

    public void setNumberStart(String numberStart) {
        this.numberStart = numberStart;
    }

    public String getNumberCurrent() {
        return numberCurrent;
    }

    public void setNumberCurrent(String numberCurrent) {
        this.numberCurrent = numberCurrent;
    }

    public String getNumberEnd() {
        return numberEnd;
    }

    public void setNumberEnd(String numberEnd) {
        this.numberEnd = numberEnd;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

}
