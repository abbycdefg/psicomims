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
import app.entity.PurchaseOrder;
import app.repositories.BookRepository;
import app.repositories.DeliveryReceiptRepository;
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
    	for(int i = 0; i<booksList.size(); i++)
    	{
    		Book b = bookDao.findByItemCode(booksList.get(i)); 
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
}