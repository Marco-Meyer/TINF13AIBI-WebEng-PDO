package pdo.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

import pdo.serialization.JSONSerializer;
import pdo.settings.Feature;
import pdo.settings.Settings;
import pdo.utils.DBConnectionManager;

@WebServlet("/SettingsServlet")
public class SettingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SettingsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("protected/settings.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection connection = DBConnectionManager.getDBConnection();
			StringBuffer buffer = new StringBuffer();
			BufferedReader reader = request.getReader();
			String line = null;
			while((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			reader.close();
			Settings settings = JSONSerializer.deserializeSettings(buffer.toString());
			DBConnectionManager.updateSettings(settings, connection);
			request.getSession().setAttribute("SETTINGS", settings);
			
		} catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
	}
	
}
