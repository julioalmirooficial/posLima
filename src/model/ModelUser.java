package model;

public class ModelUser {
    private int id;
    private String fullName;
    private String email;
    private String password;
    private String userName;
    private String numberDocument;
    private String typeUser;
    private boolean state;
    
    public ModelUser(){}

    public ModelUser(int id, String fullName, String email, String password, String userName, String numberDocument, String typeUser, boolean state) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.numberDocument = numberDocument;
        this.typeUser = typeUser;
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
        if(email.contains("@")) {
            this.email = email;            
        } else {
        this.email = "ERROR";            
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password.length() > 4) {
            this.password = password;            
        } else {
        this.password = "ERROR";            
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNumberDocument() {
        return numberDocument;
    }

    public void setNumberDocument(String numberDocument) {
        this.numberDocument = numberDocument;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        if(typeUser.equals("TIPO DE USUARIO")){
            this.typeUser = "ERROR";
        } else {
            this.typeUser = typeUser;
        }
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
    
    
}
