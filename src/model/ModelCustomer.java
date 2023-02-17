package model;

public class ModelCustomer extends ModelPerson{
    
    private String typeDocument;
    
    public ModelCustomer(){}

    public ModelCustomer(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    public String getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }
    
    
}
