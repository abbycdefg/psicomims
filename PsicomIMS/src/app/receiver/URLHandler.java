package app.receiver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
import app.components.DocumentationClerk;
import app.components.Inventory;
import app.components.WarehouseClerk;
import app.entity.Book;
import app.entity.PurchaseOrder;
import app.entity.User;
import app.repositories.OutletRepository;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;

@Component
class URLHandler extends AbstractHandler {
	
	
	@Autowired
	private Admin ad;
	
	@Autowired
	private Inventory in;
	
	@Autowired
	private DocumentationClerk dc;
	
	@Autowired
	private WarehouseClerk wc;

	

	
	public void handle(String target, HttpServletRequest request, HttpServletResponse response, int dispatch)
			throws IOException, ServletException {

		
		System.out.println("=============================================================================");
		
		System.out.println("Target: "+target);
		System.out.println("URL : "+request.getRequestURL().toString());
		System.out.println("RequestType : "+request.getMethod());
		
		if (request.getMethod().equals("POST"))
		{
			try {
				
				
				if (target.equalsIgnoreCase("/adminLogin")) {
					HashMap<String, String> map = convertJsonToCommand(request);

					String username = map.get("username");
					String password = map.get("password");

					
					if(ad.checkUser(ad.getUsername(username)) && password.equals(ad.getPassword(username))){
						response.getWriter().println("Success!");
					}
					else{

						response.getWriter().println("Invalid request.");
						JOptionPane.showMessageDialog(null, "Invalid request.", "Error", JOptionPane.ERROR_MESSAGE);
						
					}	
				}
				else if (target.equalsIgnoreCase("/addUser")) {
					HashMap<String, String> map = convertJsonToCommand(request);

					String username = map.get("username");
					String password = map.get("password");
					String password2 = map.get("password2");

					
					if(!ad.checkUser(username) && password.equals(password2)){
						ad.addUser(username, password);
						response.getWriter().println("You have succesfully registered " + username + ".");
						JOptionPane.showMessageDialog(null, "Success!", "Success", JOptionPane.PLAIN_MESSAGE);
					}
					else{
						response.getWriter().println("Invalid request.");
						JOptionPane.showMessageDialog(null, "Invalid request.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else if (target.equalsIgnoreCase("/updatePassword")) {
					HashMap<String, String> map = convertJsonToCommand(request);

					String username = map.get("username");
					String oldPassword = map.get("oldPassword");
					String newPassword = map.get("newPassword");
					String newPassword2 = map.get("newPassword2");

					if(ad.checkUser(ad.getUsername(username)) && oldPassword.equals(ad.getPassword(username)) && newPassword.equals(newPassword2)){
						ad.updatePassword(ad.getUsername(username), newPassword);
						response.getWriter().println("You have succesfully updated the password to " + newPassword + ".");
						JOptionPane.showMessageDialog(null, "Success!", "Success", JOptionPane.PLAIN_MESSAGE);

					}
					else{

						response.getWriter().println("Invalid request.");
						JOptionPane.showMessageDialog(null, "Invalid request.", "Error", JOptionPane.ERROR_MESSAGE);
					}	
		
				}
				else if (target.equalsIgnoreCase("/addOutlet")) {
					HashMap<String, String> map = convertJsonToCommand(request);

					String outletId = map.get("outletId");
					String outletName = map.get("outletName");
					String dateCreated = map.get("dateCreated");

					
					if(!ad.checkOutlet(outletId)){
						ad.addOutlet(outletId, outletName, dateCreated);
						response.getWriter().println("You have succesfully registered " + outletName + ".");
						JOptionPane.showMessageDialog(null, "Success!", "Success", JOptionPane.PLAIN_MESSAGE);
					}
					else{
						response.getWriter().println("Invalid request.");
						JOptionPane.showMessageDialog(null, "Invalid request.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else if (target.equalsIgnoreCase("/editOutlet")) {
					HashMap<String, String> map = convertJsonToCommand(request);

					String outletId = map.get("outletId");
					String outletName = map.get("outletName");
					
					if(ad.checkOutlet(outletId)){
						ad.editOutlet(outletId, outletName);
						response.getWriter().println("You have succesfully updated the information of " + outletName + ".");
						JOptionPane.showMessageDialog(null, "Success!", "Success", JOptionPane.PLAIN_MESSAGE);
					}
					else{
						response.getWriter().println("Invalid request.");
						JOptionPane.showMessageDialog(null, "Invalid request.", "Error", JOptionPane.ERROR_MESSAGE);
					}
	
		
				}
				else if (target.equalsIgnoreCase("/deleteOutlet")) {
					HashMap<String, String> map = convertJsonToCommand(request);

					String outletId = map.get("outletId");
					
					if(ad.checkOutlet(outletId)){
						ad.deleteOutlet(outletId);
						response.getWriter().println("Success!");
						JOptionPane.showMessageDialog(null, "Success!", "Success", JOptionPane.PLAIN_MESSAGE);
					}
					else{
						response.getWriter().println("Invalid request.");
						JOptionPane.showMessageDialog(null, "Invalid request.", "Error", JOptionPane.ERROR_MESSAGE);
					}	
		
				}
				else if (target.equalsIgnoreCase("/addContactPerson")) {
					HashMap<String, String> map = convertJsonToCommand(request);

					String contactPersonId = map.get("contactPersonId");
					String contactPersonName = map.get("contactPersonName");
					String dateCreated = map.get("dateCreated");

					
					if(!ad.checkContactPerson(contactPersonId)){
						ad.addContactPerson(contactPersonId, contactPersonName, dateCreated);
						response.getWriter().println("You have succesfully registered " + contactPersonName + ".");
						JOptionPane.showMessageDialog(null, "Success!", "Success", JOptionPane.PLAIN_MESSAGE);
					}
					else{
						response.getWriter().println("Invalid request.");
						JOptionPane.showMessageDialog(null, "Invalid request.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else if (target.equalsIgnoreCase("/editContactPerson")) {
					HashMap<String, String> map = convertJsonToCommand(request);

					String contactPersonId = map.get("contactPersonId");
					String contactPersonName = map.get("contactPersonName");
					
					//fix
					if(ad.checkContactPerson(contactPersonId)){
						ad.editContactPerson(contactPersonId, contactPersonName);
						response.getWriter().println("You have succesfully updated the information of " + contactPersonName + ".");
						JOptionPane.showMessageDialog(null, "Success!", "Success", JOptionPane.PLAIN_MESSAGE);
					}
					else{
						response.getWriter().println("Invalid request.");
						JOptionPane.showMessageDialog(null, "Invalid request.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else if (target.equalsIgnoreCase("/deleteContactPerson")) {
					HashMap<String, String> map = convertJsonToCommand(request);

					String contactPersonId = map.get("contactPersonId");
					
					if(ad.checkContactPerson(contactPersonId)){
						ad.deleteContactPerson(contactPersonId);
						response.getWriter().println("Success!");
						JOptionPane.showMessageDialog(null, "Success!", "Success", JOptionPane.PLAIN_MESSAGE);
					}
					else{
						response.getWriter().println("Invalid request.");
						JOptionPane.showMessageDialog(null, "Invalid request.", "Error", JOptionPane.ERROR_MESSAGE);
					}	
		
				}
				
				else if (target.equalsIgnoreCase("/dcLogin")) {
					HashMap<String, String> map = convertJsonToCommand(request);

					String username = map.get("username");
					String password = map.get("password");

					
					if(wc.checkUser(wc.getUsername(username)) && password.equals(wc.getPassword(username))){
						response.getWriter().println("Success!");
					}
					else{

						response.getWriter().println("Invalid request.");
						JOptionPane.showMessageDialog(null, "Invalid request.", "Error", JOptionPane.ERROR_MESSAGE);
					}	
				}
				
				else if (target.equalsIgnoreCase("/addBook")) {
					HashMap<String, String> map = convertJsonToCommand(request);

					String title = map.get("title");
					String itemCode = map.get("itemCode");
					String price = map.get("price");
					String author = map.get("author");
					String releaseDate = map.get("releaseDate");
					String state = "new";
					double priceDb = Double.parseDouble(price);

					
					if(!in.checkItemCode(itemCode)){
							in.addBook(title, itemCode, priceDb, author, releaseDate, state);
							response.getWriter().println("You have succesfully added " + title + ".");
					}
					else{
						response.getWriter().println("Invalid request.");
						JOptionPane.showMessageDialog(null, "Invalid request.", "Error", JOptionPane.ERROR_MESSAGE);
					}
		
				}
				else if (target.equalsIgnoreCase("/editBook")) {
					
						try {
							HashMap<String, String> map = convertJsonToCommand(request);

							String title = map.get("title");
							String itemCode = map.get("itemCode");
							String price = map.get("price");
							String author = map.get("author");
							String releaseDate = map.get("releaseDate");
							double priceDb = Double.parseDouble(price);

							in.editBook(title, itemCode, priceDb, author, releaseDate);
							response.getWriter().println("You have succesfully edited " + title + ".");
						} catch (Exception e) {
							response.getWriter().println("Invalid.");
							JOptionPane.showMessageDialog(null, "Invalid request.", "Error", JOptionPane.ERROR_MESSAGE);
						}

				}
				else if (target.equalsIgnoreCase("/deleteBook")) {
					
					try {
						HashMap<String, String> map = convertJsonToCommand(request);


						String itemCode = map.get("itemCode");
						
						in.deleteBook(itemCode);
						response.getWriter().println("You have succesfully deleted a book.");
					} catch (Exception e) {
						response.getWriter().println("Invalid.");
						JOptionPane.showMessageDialog(null, "Invalid request.", "Error", JOptionPane.ERROR_MESSAGE);
					}

				}
				else if (target.equalsIgnoreCase("/addPurchaseOrder")) {
					List<String> booksList = new ArrayList<String>();
					List<String> quantityList = new ArrayList<String>();
					HashMap<String, String> map = convertJsonToCommand(request);

					String purchaseOrderNumber = map.get("purchaseOrderNumber");
					String dateToday = map.get("dateToday");
					String contactPerson = map.get("contactPerson");
					String outlet = map.get("outlet");
					
					
					String books = map.get("booksList");
					if(!books.equals("")) {
						books = books.substring(1, books.length()-1);			
						booksList = Arrays.asList(books.split("\\s*,\\s*"));
					}
					String quantity = map.get("quantityList");  
					if(!quantity.equals("")) {
						quantity = quantity.substring(1, quantity.length()-1);
						quantityList = Arrays.asList(quantity.split("\\s*,\\s*"));
					}
					System.out.println(quantity);
					if(!dc.checkPurchaseOrder(purchaseOrderNumber)){
							dc.createPurchaseOrder(purchaseOrderNumber, dateToday, contactPerson, outlet, booksList, quantityList);
							response.getWriter().println("You have succesfully added Purchase Order " + purchaseOrderNumber + ".");
					}

					else{
						response.getWriter().println("1");
						JOptionPane.showMessageDialog(null, "Invalid request.", "Error", JOptionPane.ERROR_MESSAGE);
					}
		
				}
				
				else if (target.equalsIgnoreCase("/editPurchaseOrder")) {
					HashMap<String, String> map = convertJsonToCommand(request);

					String purchaseOrderNumber = map.get("purchaseOrderNumber");
					String dateToday = map.get("dateToday");
					String contactPerson = map.get("contactPerson");
					String outlet = map.get("outlet");
					
					
					String books = map.get("booksList");
					if(!books.equals(""))
					{
					books = books.substring(1, books.length()-1);	
					}
					System.out.println(books);
					List<String> booksList = Arrays.asList(books.split("\\s*,\\s*"));
					System.out.println(books);
					
					String quantity = map.get("quantityList");  
					if(!quantity.equals(""))
					{
					quantity = quantity.substring(1, quantity.length()-1);
					}
					List<String> quantityList = Arrays.asList(quantity.split("\\s*,\\s*"));
					System.out.println(quantityList);
					if(!dc.checkPurchaseOrder(purchaseOrderNumber)){
							dc.editPurchaseOrder(purchaseOrderNumber, dateToday, contactPerson, outlet, booksList, quantityList);
							response.getWriter().println("You have succesfully edited Purchase Order " + purchaseOrderNumber + ".");

					}

		
				}
				else if (target.equalsIgnoreCase("/deletePurchaseOrder")) {
					HashMap<String, String> map = convertJsonToCommand(request);

					String purchaseOrderNumber = map.get("purchaseOrderNumber");
					
							dc.deletePurchaseOrder(purchaseOrderNumber);
							response.getWriter().println("You have succesfully deleted Purchase Order " + purchaseOrderNumber + ".");

		
				}
				
				else if (target.equalsIgnoreCase("/addDeliveryReceipt")) {
					HashMap<String, String> map = convertJsonToCommand(request);

					String drNumber = (String) map.get("drNumber");
					String dateToday = (String) map.get("dateToday");
					String totalAmt = (String) map.get("totalAmt");
					String dateDelivery = (String) map.get("dateDelivery");
					String poNumber = (String) map.get("poNumber");
					String order = (String) map.get("order");
					String outlet = (String) map.get("outlet");
					
					String books = map.get("booksList");
					books = books.substring(1, books.length()-1);					
					System.out.println(books);
					List<String> booksList = Arrays.asList(books.split("\\s*,\\s*"));
					
					
					String quantity = map.get("quantityList");  
					System.out.println(quantity);
					quantity = quantity.substring(1, quantity.length()-1);
					List<String> quantityList = Arrays.asList(quantity.split("\\s*,\\s*"));
					
					if(!dc.checkDeliveryReceipt(drNumber)){
						dc.createDeliveryReceipt(drNumber, dateToday, totalAmt, dateDelivery, poNumber, order, outlet, booksList, quantityList);
						response.getWriter().println(books);
					}
					else{
						response.getWriter().println("Invalid request.");
						JOptionPane.showMessageDialog(null, "Delivery Receipt Number Already Exists", "Error", JOptionPane.ERROR_MESSAGE);
					}

		
				}
				else if (target.equalsIgnoreCase("/editDeliveryReceipt")) {
					HashMap<String, String> map = convertJsonToCommand(request);

					String drNumber = (String) map.get("drNumber");
					String dateToday = (String) map.get("dateToday");
					String totalAmt = (String) map.get("totalAmt");
					String dateDelivery = (String) map.get("dateDelivery");
					
					String books = map.get("booksList");
					System.out.println(books);
					books = books.substring(1, books.length()-1);										
					List<String> booksList = Arrays.asList(books.split("\\s*,\\s*"));
					
					
					String quantity = map.get("quantityList");  
					System.out.println(quantity);
					quantity = quantity.substring(1, quantity.length()-1);
					List<String> quantityList = Arrays.asList(quantity.split("\\s*,\\s*"));
					
					dc.editDeliveryReceipt(drNumber, dateToday, totalAmt, dateDelivery, booksList, quantityList);
					response.getWriter().println(books);
					
					
		
				}
				else if (target.equalsIgnoreCase("/deleteDeliveryReceipt")) {
					HashMap<String, String> map = convertJsonToCommand(request);

					String drNumber = (String) map.get("drNumber");

					
					dc.deleteDeliveryReceipt(drNumber);
					response.getWriter().println(drNumber);
		
				}
				
				else if (target.equalsIgnoreCase("/addJobOrder")) {
					HashMap<String, String> map = convertJsonToCommand(request);

					String joNumber =  map.get("joNumber");
					String dateToday =  map.get("dateToday");
					String itemCode = map.get("itemCode");
					String title = map.get("title");
					String quantity = map.get("quantity");
					if(!dc.checkJobOrder(joNumber)){
						dc.createJobOrder(joNumber, dateToday, itemCode, title, quantity);
						response.getWriter().println(joNumber);
					}
					else{
						response.getWriter().println("Invalid request.");
						JOptionPane.showMessageDialog(null, "Job Order Number Already Exists", "Error", JOptionPane.ERROR_MESSAGE);
					}				
					
		
				}
				
				else if (target.equalsIgnoreCase("/editJobOrder")) {
					
					try {
						HashMap<String, String> map = convertJsonToCommand(request);

						String joNumber =  map.get("joNumber");
						String dateToday =  map.get("dateToday");
						String itemCode = map.get("itemCode");
						String title = map.get("title");
						String quantity = map.get("quantity");

						dc.editJobOrder(joNumber, dateToday, itemCode, title, quantity);
						response.getWriter().println("You have succesfully edited " + joNumber + ".");
					} catch (Exception e) {
						response.getWriter().println("Invalid.");
						JOptionPane.showMessageDialog(null, "Invalid request.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else if (target.equalsIgnoreCase("/deleteJobOrder")) {
					
					try {
						HashMap<String, String> map = convertJsonToCommand(request);

						String joNumber =  map.get("joNumber");

						dc.deleteJobOrder(joNumber);
						response.getWriter().println("You have succesfully deleted " + joNumber + ".");
					} catch (Exception e) {
						response.getWriter().println("Invalid.");
						JOptionPane.showMessageDialog(null, "Invalid request.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				else if (target.equalsIgnoreCase("/addDeliverySchedule")) {

	
					HashMap<String, String> map = convertJsonToCommand(request);

		
					String date = map.get("date");
					String scheduleCode =  map.get("scheduleCode");
					String outlet = map.get("outlets");
					String deliveryReceiptCode = map.get("deliveryReceiptCode");
					
					dc.addDeliverySchedule(scheduleCode, date, outlet, deliveryReceiptCode);
					response.getWriter().println("You have succesfully edited " + scheduleCode + ".");
		}				
				
				else if (target.equalsIgnoreCase("/editDeliverySchedule")) {
					
						HashMap<String, String> map = convertJsonToCommand(request);

			
						String date = map.get("date");
						String scheduleCode =  map.get("scheduleCode");
						String outlet = map.get("outlets");
						String deliveryReceiptCode = map.get("deliveryReceiptCode");
						
						dc.editDeliverySchedule(scheduleCode, date, outlet, deliveryReceiptCode);
						response.getWriter().println("You have succesfully edited " + scheduleCode + ".");
			}
				

				else if (target.equalsIgnoreCase("/deleteDeliverySchedule")) {

						HashMap<String, String> map = convertJsonToCommand(request);

			
						String scheduleCode =  map.get("scheduleCode");

						dc.deleteDeliverySchedule(scheduleCode);
						response.getWriter().println("You have succesfully deleted " + scheduleCode + ".");
			     }

				
				
				else if (target.equalsIgnoreCase("/wcLogin")) {
					HashMap<String, String> map = convertJsonToCommand(request);

					String username = map.get("username");
					String password = map.get("password");

					
					if(wc.checkUser(wc.getUsername(username)) && password.equals(wc.getPassword(username))){
						response.getWriter().println("Success!");
					}
					else{

						response.getWriter().println("Invalid request.");
						JOptionPane.showMessageDialog(null, "Invalid request.", "Error", JOptionPane.ERROR_MESSAGE);
					}	
				}
				
				else if (target.equalsIgnoreCase("/updateStocks")) {
					HashMap<String, String> map = convertJsonToCommand(request);

					String itemCode = map.get("itemCode");
					int newQuantity = Integer.parseInt(map.get("newQuantity"));
					
					if(wc.checkBook(itemCode)){
						wc.updateStock(itemCode, newQuantity);
						response.getWriter().println("You have succesfully updated the stocks to " + newQuantity + ".");
						JOptionPane.showMessageDialog(null, "Success!", "Success", JOptionPane.PLAIN_MESSAGE);

					}
					else{

						response.getWriter().println("Invalid request.");
						JOptionPane.showMessageDialog(null, "Invalid request.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				else if (target.equalsIgnoreCase("/addDefectiveBook")) {
					HashMap<String, String> map = convertJsonToCommand(request);

					String itemCode = map.get("itemCode");
					int quantity = Integer.parseInt(map.get("quantity"));
					
					if(wc.checkBook(itemCode)){
						wc.addDefectiveBook(itemCode, quantity);
						response.getWriter().println("You have succesfully added " + wc.getBookTitle(itemCode) + ".");
						JOptionPane.showMessageDialog(null, "Success!", "Success", JOptionPane.PLAIN_MESSAGE);

					}
					else{

						response.getWriter().println("Invalid request.");
						JOptionPane.showMessageDialog(null, "Invalid request.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else if (target.equalsIgnoreCase("/setOrderStatus")) {
					HashMap<String, String> map = convertJsonToCommand(request);

					String spoId = map.get("spoId");
					String itemCode = map.get("itemCode");
					String poId = map.get("poId");
					String status = map.get("status");
					
					if(dc.checkBook(itemCode)){
						dc.setStatus(spoId, itemCode, poId, status);
						response.getWriter().println("You have succesfully updated the status of " + wc.getBookTitle(itemCode) + ".");

					}
					else{

						response.getWriter().println("Invalid request.");
						JOptionPane.showMessageDialog(null, "Invalid request.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					// Invalid request
					response.getWriter().println("Unsupported POST request: " + target);
					JOptionPane.showMessageDialog(null, "Invalid request.", "Error", JOptionPane.ERROR_MESSAGE);
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
			JOptionPane.showMessageDialog(null, "Invalid request.", "Error", JOptionPane.ERROR_MESSAGE);			
		}
		((Request) request).setHandled(true);
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

