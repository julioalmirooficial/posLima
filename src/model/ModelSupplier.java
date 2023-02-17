package model;

public class ModelSupplier extends ModelPerson{
    
    private String cellPhone;
    
    public ModelSupplier(){}

    public ModelSupplier(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }
    
    
}
