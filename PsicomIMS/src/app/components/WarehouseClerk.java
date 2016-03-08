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
import app.entity.Outlet;
import app.entity.PurchaseOrder;
import app.entity.SpecificPo;
import app.entity.User;
import app.repositories.BookRepository;
import app.repositories.ContactPersonRepository;
import app.repositories.DefectiveBookRepository;
import app.repositories.DeliveryReceiptRepository;
import app.repositories.OutletRepository;
import app.repositories.PurchaseOrderRepository;
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
    
    public boolean updateStock(String itemCode, int newQuantity) {

    	Book b = bookDao.findByItemCode(itemCode);
    	b.setQuantity(newQuantity);
    	b.setState("old");
    	b = bookDao.save(b);
    	
    	return b.getId()!= null;    	
    }
    
    @Transactional
    public boolean addDefectiveBook(String itemCode, int defQuantity) {
    	
    	DefectiveBook d = new DefectiveBook();    	
    	Book b = bookDao.findByItemCode(itemCode);
    	
    	d.setItemCode(itemCode);
    	d.setTitle(b.getTitle());
    	d.setDefectsQuantity(defQuantity);
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

 
}