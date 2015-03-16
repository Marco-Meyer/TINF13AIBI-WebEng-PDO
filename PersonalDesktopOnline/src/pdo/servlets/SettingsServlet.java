package pdo.servlets;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pdo.serialization.JSONSerializer;
import pdo.settings.Settings;

@WebServlet("/SettingsServlet")
public class SettingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SettingsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			StringBuffer buffer = new StringBuffer();
			BufferedReader reader = request.getReader();
			String line = null;
			while((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			reader.close();
			Settings settings = JSONSerializer.deserializeSettings(buffer.toString());
			settings.getFeatures(); //do sth with settings so its not optimized away
		} catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
	}

}
