package pdo.contacts;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspWriter;

import pdo.utils.DBConnectionManager;

public class Contact implements Serializable{
	
	private static final long serialVersionUID = 6297385302078200511L;
    
	public String userId;
    public String prename;
    public String lastName;
    private int id;
    public String mail;
    public String telephone;
    public String mobilephone;
    
    public Contact(){
    	this.userId="";
    	this.prename="";
        this.lastName="";
        this.mail="";
        this.telephone="";
        this.mobilephone="";
    }
     
    public Contact(String user, String pre, String last, String mail,String phone,String mphone){
        this.userId=user;
    	this.prename=pre;
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
    	String name = this.prename + " " + this.lastName+ " <br/>";
    	String mail = this.mail+" <br/>";
    	String telephone = this.telephone+" <br/>";
    	String mobilephone = this.mobilephone;
        return name + mail + telephone + mobilephone;
    }
    
//static public List<Contact> showContacts(String UserId, String letter){
//		
////		Connection connection=null;
//		Statement statement=null;
//		ResultSet resultSet=null;
//		String userID;
//		String preName;
//		String lastName;
//		String mail;
//		String telephone;
//		String mobilephone;
//		
//		List<Contact> nameList = new ArrayList<>();
//		
//		Connection connection = DBConnectionManager.getDBConnection();
//		
//		try {
//			statement = connection.createStatement();
//			String query = "SELECT * FROM contact WHERE '"+ UserId + "' AND prename like '"+ letter + "%';";
//			resultSet = statement.executeQuery(query);
//			while(resultSet.next()){
//				userID = resultSet.getString("userID");
//				preName = resultSet.getString("prename");
//				lastName = resultSet.getString("lastname");
//				mail = resultSet.getString("mail");
//				telephone = resultSet.getString("telephone");
//				mobilephone = resultSet.getString("mobilephone");
//				Contact contact = new Contact(userID, preName,lastName,mail,telephone,mobilephone);
//				nameList.add(contact);
//			}	
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			if (resultSet!=null) { 
//				try {
//					resultSet.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				resultSet=null; 
//			}    
//			if (statement!=null) { 
//				try {
//					statement.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				statement=null; 
//			}
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}         
//			connection=null;
//		}
//		return nameList;
//	}

	static public JspWriter editContact(Contact contact, JspWriter out){
		try {
			out.println("<p>" + contact.toString());
			out.println("<form method=POST action=EditContactServlet>");
			out.println("<input type=hidden name=pre value=" + contact.prename + ">"); 
			out.println("<input type=hidden name=last value=" + contact.lastName + ">");
			out.println("<input type=hidden name=email value=" + contact.mail + ">");
			out.println("<input type=hidden name=phone value=" + contact.telephone + ">");
			out.println("<input type=hidden name=mphone value=" + contact.mobilephone + ">");
			out.println("<input type=submit name=submit value=Ändern />");
			out.println("</form>");
			out.println("<br/>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
		
	}

	static public JspWriter deleteContact(Contact contact,JspWriter out){
		try {
			out.println("<form method=POST action=DeleteContactServlet>");
			out.println("<input type=hidden name=pre value=" + contact.prename + ">");
			out.println("<input type=hidden name=last value=" + contact.lastName + ">");
			out.println("<input type=hidden name=email value=" + contact.mail + ">");
			out.println("<input type=hidden name=phone value=" + contact.telephone + ">");
			out.println("<input type=hidden name=mphone value=" + contact.mobilephone + ">");
			out.println("<input type=submit name=submit value=Löschen />");
			out.println("</form>");
			out.println("<br/>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}
}


