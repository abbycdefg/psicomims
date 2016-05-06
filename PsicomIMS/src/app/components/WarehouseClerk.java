package app.components;

import java.io.*;

import javax.annotation.PostConstruct;
import javax.swing.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import app.entity.Book;
import app.entity.ContactPerson;
import app.entity.DefectiveBook;
import app.entity.JobOrder;
import app.entity.Outlet;
import app.entity.PurchaseOrder;
import app.entity.SpecificPo;
import app.entity.User;
import app.repositories.BookRepository;
import app.repositories.ContactPersonRepository;
import app.repositories.DefectiveBookRepository;
import app.repositories.DeliveryReceiptRepository;
import app.repositories.JobOrderRepository;
import app.repositories.OutletRepository;
import app.repositories.PurchaseOrderRepository;
import app.repositories.SpecificPoRepository;
import app.repositories.UserRepository;

import java.util.*;

@Component
public class WarehouseClerk 
{
	
	@Autowired
	private UserRepository userDao;
	
	@Autowired
	private BookRepository bookDao;
	
	@Autowired
	private DefectiveBookRepository defectiveBookDao;
	
	@Autowired
	private PurchaseOrderRepository poDao;
	
	@Autowired
	private DeliveryReceiptRepository drDao;
	
	@Autowired
	private SpecificPoRepository spoDao;
	
	@Autowired
	private JobOrderRepository joDao;
	
    public boolean checkUser(String username)
    {
        try
        {
            User u = userDao.findByUsername(username);
            return u.checkUsername(username);
        }
        catch(Exception e)
        {
            return false;
        }
        
    }

    
    public String getUsername(String username){
    	User u = userDao.findByUsername(username);
    	return u.getUsername();
    }
    
    public String getPassword(String username){
    	User u = userDao.findByUsername(username);
    	return u.getPassword();
    }
    
    public boolean checkBook(String itemCode)
    {
        try
        {
            Book b = bookDao.findByItemCode(itemCode);
            return b.checkItemCode(itemCode);
        }
        catch(Exception e)
        {
            return false;
        }
        
    }
    
    @Transactional
    public boolean updateStock(String itemCode, int newQuantity) {
    	int a = 0;
    	int remainingOrders = 0;
    	
    	Book b = bookDao.findByItemCode(itemCode);
    	a = b.getQuantity();
    	b.setQuantity(a+=newQuantity);
    	b.setState("old");
    	b = bookDao.save(b);
    	
    	if (joDao.count() > 0 ){
    		JobOrder j = joDao.findByItemCode(itemCode);    		
	    	if (j != null){
	    		remainingOrders = Integer.parseInt(j.getRemainingOrders());
		    	if (newQuantity >= remainingOrders){
		    		j.setJoStatus("COMPLETE");
		    		j.setItemCode(itemCode + "-CO");
		    	}
		    	else if (newQuantity < remainingOrders){
		    		j.setJoStatus("INCOMPLETE");
		    		remainingOrders -= newQuantity;
		    	}         		
	    		j.setRemainingOrders(Integer.toString(remainingOrders));
	    		joDao.save(j);
	    	}	    	
    	}
    	
    	
    	return b.getItemCode()!= null;    	
    }
    
    @Transactional
    public boolean addDefectiveBook(String itemCode, int defQuantity, String outlet, String state) {
    	
    	DefectiveBook d = new DefectiveBook();    	
    	Book b = bookDao.findByItemCode(itemCode);
    	int a = 0;
    	
    	d.setItemCode(itemCode);
    	d.setTitle(b.getTitle());
    	d.setDefectsQuantity(defQuantity);
    	d.setOutlet(outlet);
    	d.setState(state);
    	if (state.equals("GOOD"))
    	{     	
        	a = b.getQuantity();
        	b.setQuantity(a+=defQuantity);
        	b.setState("old");
        	b = bookDao.save(b);
    	}
    	java.util.Date starttijd = new java.util.Date();
    	d.setDateCreated(starttijd);
    	d = defectiveBookDao.save(d);
    	
    	return d.getId()!= null;    	
    }
    
    public String getBookTitle(String itemCode)
    {
        try
        {
            Book b = bookDao.findByItemCode(itemCode);
            return b.getTitle();
        }
        catch(Exception e)
        {
            return "Not found";
        }
        
    } 
    
    @Transactional
    public boolean setOrderStatus(String spoId, String poId, String itemCode, String status, int counter){
    	
    	Long spoId2 = Long.parseLong(spoId);    	
    	SpecificPo sp2 = spoDao.findById(spoId2);
    	PurchaseOrder p = poDao.findByPurchaseOrderNumber(poId);
    	Set<SpecificPo> books = p.getSpecPo();
    	
    	sp2.setStatus(status);    	
    	spoDao.save(sp2);
    	counter++;
    	
    	p.setCounter(counter);
    	
    	if (counter == books.size()){
    		p.setPoStatus("COMPLETE");
    	}
    	else{
    		p.setPoStatus("INCOMPLETE");
    	}
    	    	
    	poDao.save(p);  
      	return p.getPurchaseOrderNumber()!= null;
    }

}