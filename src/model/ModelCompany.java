package model;

public class ModelCompany extends ModelPerson{
    
    private String cellPhone;
    
    public ModelCompany(){}

    public ModelCompany(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }
    
    
    
}
