package app.receiver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.mortbay.jetty.Request;
import org.mortbay.jetty.handler.AbstractHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import app.components.Admin;
import app.components.Inventory;
import app.entity.Book;
import app.entity.User;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
class URLHandler extends AbstractHandler {
	
	
	@Autowired
	private Admin ad;
	
	@Autowired
	private Inventory in;
	


	public void handle(String target, HttpServletRequest request, HttpServletResponse response, int dispatch)
			throws IOException, ServletException {

		
		System.out.println("=============================================================================");
		
		System.out.println("Target: "+target);
		System.out.println("URL : "+request.getRequestURL().toString());
		System.out.println("RequestType : "+request.getMethod());
		
		if (request.getMethod().equals("POST"))
		{
			try {
				if (target.equalsIgnoreCase("/addUser")) {
					HashMap<String, String> map = convertJsonToCommand(request);

					String username = map.get("username");
					String password = map.get("password");
					String password2 = map.get("password2");

					
					if(!ad.checkUser(username) && password.equals(password2)){
							ad.addUser(username, password);
							response.getWriter().println("You have succesfully registered " + username + ".");
}
					else{
						response.getWriter().println("Invalid request.");
					}
				}
				else if (target.equalsIgnoreCase("/updatePassword")) {
					updatePassword(request, response);
		
				}
				else if (target.equalsIgnoreCase("/addBook")) {
					HashMap<String, String> map = convertJsonToCommand(request);

					String title = map.get("title");
					String itemCode = map.get("itemCode");
					String price = map.get("price");
					String author = map.get("author");
					String releaseDate = map.get("releaseDate");
					double priceDb = Double.parseDouble(price);

					
					if(!in.checkItemCode(itemCode)){
							in.addBook(title, itemCode, priceDb, author, releaseDate);
							response.getWriter().println("You have succesfully added " + title + ".");
}
					else{
						response.getWriter().println("Invalid request.");
					}
		
				}
				else {
					// Invalid request
					response.getWriter().println("Unsupported POST request: " + target);
				}
				
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		else
		{
		    // Invalid request
			response.getWriter().println("Unsupported GET request: " + target);			
		}
		((Request) request).setHandled(true);
	}
	
	@Transactional
	private void updatePassword(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
			HashMap<String, String> map = convertJsonToCommand(request);

			String username = map.get("username");
			String oldPassword = map.get("oldPassword");
			String newPassword = map.get("newPassword");
			String newPassword2 = map.get("newPassword2");
			
			if(ad.checkUser(ad.getUsername(username)) && oldPassword.equals(ad.getPassword(username)) && newPassword.equals(newPassword2)){
				ad.updatePassword(ad.getUsername(username), newPassword);
				response.getWriter().println("You have succesfully updated the password to " + newPassword + ".");
				JOptionPane.showMessageDialog(null, "Success!", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else{

				response.getWriter().println("Invalid request.");
			}		
				
	}

	public static String readStreamAsString(InputStream is) throws IOException {
		InputStreamReader isr = new InputStreamReader(is);

		BufferedReader reader = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = reader.readLine()) != null) {
			sb.append(line + "\n");
		}

		return sb.toString();
	}
	
	
	private HashMap<String, String> convertJsonToCommand(HttpServletRequest request) {
		try {
			String rawJson = null;

			// extract any sent data
			rawJson = readStreamAsString(request.getInputStream());
			System.out.println("RAW COMMAND JSON: " + rawJson);

			ObjectMapper mapper = new ObjectMapper();
			//mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
			HashMap<String, String> requestData = (HashMap) mapper.readValue(rawJson, HashMap.class);
			
			return requestData;
		} 
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

