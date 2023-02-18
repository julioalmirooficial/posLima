
package controller;

import main.Home;

public class ControllerAccessUser {
    
    public void ventas(String typeUser){
        
    }
    public void shopping(String typeUser){
        if(typeUser.equals("VENDEDOR")) {
            Home.mnuShopping.setVisible(false);
        }
    }
    public void store(String typeUser){
        if(typeUser.equals("VENDEDOR")) {
            Home.mnuStore.setVisible(false);
        }
    }
    public void reports(String typeUser){
        if(typeUser.equals("VENDEDOR")) {
            Home.mnuReport.setVisible(false);
        }
    }
    public void user(String typeUser){
        if(typeUser.equals("VENDEDOR")) {
            Home.mnuUsers.setVisible(false);
        }
    }
    public void customer(String typeUser){
        
    }
    public void company(String typeUser){
        if(typeUser.equals("VENDEDOR")) {
            Home.mnuCompany.setVisible(false);
        }
    }
    public void setting(String typeUser){
        if(typeUser.equals("VENDEDOR")) {
            Home.mnuSetting.setVisible(false);
        }
    }
    
}
