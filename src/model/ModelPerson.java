package model;

public class ModelPerson {
    private int id;
    private String fullName;
    private String email;
    private String adress;
    private String numberDocument;
    private boolean state;
    
    public ModelPerson(){}

    public ModelPerson(int id, String fullName, String email, String adress, String numberDocument, boolean state) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.adress = adress;
        this.numberDocument = numberDocument;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getNumberDocument() {
        return numberDocument;
    }

    public void setNumberDocument(String numberDocument) {
        this.numberDocument = numberDocument;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
    
    
    
}
