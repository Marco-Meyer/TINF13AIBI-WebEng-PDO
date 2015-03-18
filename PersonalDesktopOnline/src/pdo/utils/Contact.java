package pdo.utils;

import java.io.Serializable;

public class Contact implements Serializable{
	
	private static final long serialVersionUID = 6297385302078200511L;
    
    private String prename;
    private String lastName;
    private int id;
    private String mail;
    private String telephone;
    private String mobilephone;
     
    public Contact(String pre, String last, String mail,String phone,String mphone, int i){
        this.prename=pre;
        this.id=i;
        this.lastName=last;
        this.mail=mail;
        this.telephone=phone;
        this.mobilephone=mphone;
    }
 
    public void setPreName(String prename) {
        this.prename = prename;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
 
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
 
    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }
    
    public void setMail(String mail) {
        this.mail = mail;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
 
    public String getPreName() {
        return prename;
    }
    
    public String getLastName() {
        return lastName;
    }
 
    public String getEmail() {
        return mail;
    }
    
    public String getTelephone() {
        return telephone;
    }
    
    public String getMobilephone() {
        return mobilephone;
    }
 
    public int getId() {
        return id;
    }
 
     
    @Override
    public String toString(){
        return "Vorame="+this.prename+", Nachname="+this.lastName;
    }
}


