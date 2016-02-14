package app.components;

import java.io.*;

import javax.annotation.PostConstruct;
import javax.persistence.metamodel.ListAttribute;
import javax.swing.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import app.entity.Book;
import app.entity.DeliveryReceipt;
import app.entity.JobOrder;
import app.entity.PurchaseOrder;
import app.repositories.BookRepository;
import app.repositories.DeliveryReceiptRepository;
import app.repositories.JobOrderRepository;
import app.repositories.PurchaseOrderRepository;

import java.util.*;

@Component
public class DocumentationClerk 
{
	@Autowired
	PurchaseOrderRepository poDao;
	
	@Autowired
	BookRepository bookDao;
	
	@Autowired
	DeliveryReceiptRepository drDao;
	
	@Autowired
	JobOrderRepository joDao;
	
	public boolean checkPurchaseOrder(String poNumber)
    {
        try
        {
            PurchaseOrder p = poDao.findByPurchaseOrderNumber(poNumber);
            return p.checkPONumber(poNumber);
        }
        catch(Exception e)
        {
            return false;
        }
        
    }
	public List<PurchaseOrder> getAllPurchaseOrders()
    {

        	List <PurchaseOrder> poList = poDao.findAll();
        	return poList;     
    }
    public boolean createPurchaseOrder(String poNumber, String dateToday, String contactPerson, String outlet, List<String> booksList)
    {
    	PurchaseOrder p = new PurchaseOrder();
    	Set<Book> listOfBooks= new HashSet<Book>();
    	p.setPurchaseOrderNumber(poNumber);
    	p.setDateToday(dateToday);
    	p.setContactPerson(contactPerson);
    	p.setOutlet(outlet);
   	
    	for(int i = 0; i<booksList.size(); i++)
    	{
    		Book b = bookDao.findByItemCode(booksList.get(i)); 
    		if(b!=null)
    		{
    		listOfBooks.add(b);
    		}
    		
    	}
    	

    	System.out.println(listOfBooks);

    	p.setBooks(listOfBooks);
    	p = poDao.save(p);
   
      	return p.getId()!= null;
    	
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
    public boolean createDeliveryReceipt(String drNumber, String dateToday, String totalAmt, String dateDelivery, List<String> booksList)
    {
    	DeliveryReceipt d = new DeliveryReceipt();
    	Set<Book> listOfBooks= new HashSet<Book>();
    	
    	d.setDeliveryReceiptNumber(drNumber);
    	d.setDateToday(dateToday);
    	d.setTotalAmount(totalAmt);
    	d.setDateDelivery(dateDelivery);
    	for(String i : booksList)
    	{
    		Book b = bookDao.findByItemCode(i);
        	System.out.println(i);
        	System.out.println(b);
    		
    		if(b!=null)
    		{
    		listOfBooks.add(b);
    		}
    		
    	}
    	

    	System.out.println(listOfBooks);

    	d.setBooks(listOfBooks);
    	d = drDao.save(d);
   
    	return d.getId()!= null;
    	
    }
    
    @Transactional
    public boolean createJobOrder(String joNumber, String dateToday, String itemCode, String title, String quantity)
    {
    	JobOrder j = new JobOrder();
    	
    	j.setJoNumber(joNumber);
    	j.setDate(dateToday);
    	j.setItemCode(itemCode);
    	j.setTitle(title);
    	j.setQuantity(quantity);
    	
    	j = joDao.save(j);
   
    	return j.getId()!= null;
    	
    }
    public boolean editJobOrder(String joNumber, String dateToday, String itemCode, String title, String quantity) {
    	JobOrder j = joDao.findByJoNumber(joNumber);
    	j.setJoNumber(joNumber);
    	j.setDate(dateToday);
    	j.setItemCode(itemCode);
    	j.setTitle(title);
    	j.setQuantity(quantity);
    	
    	j = joDao.save(j);
    	return j.getId()!= null;    	
    }
    
    public boolean deleteJobOrder(String joNumber) {
    	JobOrder j = joDao.findByJoNumber(joNumber);
    	joDao.delete(j);;
    	return j.getId()!= null;    	
    }
}