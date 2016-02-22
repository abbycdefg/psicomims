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
import app.entity.DeliverySchedule;
import app.entity.JobOrder;
import app.entity.PurchaseOrder;
import app.entity.SpecificDr;
import app.entity.SpecificPo;
import app.repositories.BookRepository;
import app.repositories.DeliveryReceiptRepository;
import app.repositories.DeliveryScheduleRepository;
import app.repositories.JobOrderRepository;
import app.repositories.PurchaseOrderRepository;
import app.repositories.SpecificDrRepository;
import app.repositories.SpecificPoRepository;

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
	
	@Autowired
	SpecificPoRepository spoDao;
	
	@Autowired
	SpecificDrRepository sdrDao;
	
	@Autowired
	DeliveryScheduleRepository dsDao;
	
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
	
    public boolean createPurchaseOrder(String poNumber, String dateToday, String contactPerson, String outlet, List<String> booksList, List<String> quantityList)
    {
    	PurchaseOrder p = new PurchaseOrder();

    	Set<Book> listOfBooks= new HashSet<Book>();
    	p.setPurchaseOrderNumber(poNumber);
    	p.setDateToday(dateToday);
    	p.setContactPerson(contactPerson);
    	p.setOutlet(outlet);
    	p = poDao.save(p);
    	
    	SpecificPo sp = new SpecificPo();
    	
    	for(int i = 0; i<booksList.size(); i++)
    	{
    		Book b = bookDao.findByItemCode(booksList.get(i)); 
    		System.out.println(b + "check book");
    		if(b!=null)
    		{
    		sp.setBookId(b);
			listOfBooks.add(b);
    		}
    		
    		PurchaseOrder po = poDao.findByPurchaseOrderNumber(poNumber);
    		sp.setPoId(po);
    		
    		if(quantityList.get(i) != null)
    		{
    			String quantity = quantityList.get(i);
    			System.out.println(quantity);
    			if (quantity != "")
    			{
    			int qty = Integer.parseInt(quantity);
    			sp.setQuantity(qty);
    			}
    		}
    		
    		spoDao.save(sp);    		
    	}
    	

    	System.out.println(listOfBooks);   
      	return p.getId()!= null;
    	
    }
    public boolean editPurchaseOrder(String poNumber, String dateToday, String contactPerson, String outlet, List<String> booksList, List<String> quantityList)
    {
    	PurchaseOrder p = poDao.findByPurchaseOrderNumber(poNumber);

    	Set<Book> listOfBooks= new HashSet<Book>();
    	p.setDateToday(dateToday);
    	p.setContactPerson(contactPerson);
    	p.setOutlet(outlet);
    	//p.setBooks(listOfBooks);
    	p = poDao.save(p);
    	

    	System.out.println(listOfBooks);   
      	return p.getId()!= null;
    	
    }
    public boolean deletePurchaseOrder(String poNumber)
    {
    	
    	PurchaseOrder p = poDao.findByPurchaseOrderNumber(poNumber);
    	System.out.println(p);
    	poDao.delete(p);
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
    public boolean createDeliveryReceipt(String drNumber, String dateToday, String totalAmt, String dateDelivery, List<String> booksList, List<String> quantityList)
    {     	
    	DeliveryReceipt d = new DeliveryReceipt();
    	Set<Book> listOfBooks= new HashSet<Book>();
    	
    	d.setDeliveryReceiptNumber(drNumber);
    	d.setDateToday(dateToday);
    	d.setTotalAmount(totalAmt);
    	d.setDateDelivery(dateDelivery);
    	d = drDao.save(d);
    	
    	SpecificDr sd = new SpecificDr();
    	for(int i = 0; i<booksList.size(); i++)
    	{
    		Book b = bookDao.findByItemCode(booksList.get(i)); 
    		System.out.println(b + "check book");
    		if(b!=null)
    		{
    		sd.setBookId(b);
			listOfBooks.add(b);
    		}
    		
    		DeliveryReceipt dr = drDao.findByDeliveryReceiptNumber(drNumber);
    		sd.setDrId(dr);
    		
    		if(quantityList.get(i) != null)
    		{
    			String quantity = quantityList.get(i);
    			System.out.println(quantity);
    			if (quantity != "")
    			{
    			int qty = Integer.parseInt(quantity);
    			sd.setQuantity(qty);
    			}
    		}
    		
    		sdrDao.save(sd);    		
    		
    	}
    	

    	System.out.println(listOfBooks);

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
    
    public boolean addDeliverySchedule(String scheduleCode, String date, String outlet, String drCode) {
    	DeliverySchedule d = new DeliverySchedule();
    	d.setScheduleCode(scheduleCode);
    	d.setDate(date);
    	d.setOutlet(outlet);
    	d.setDeliveryReceiptCode(drCode);
    	System.out.println(scheduleCode);
    	d = dsDao.save(d);
    	
    	return d.getScheduleCode()!= null;
    	
    }
    public boolean editDeliverySchedule(String scheduleCode, String date, String outlet, String drCode) {
    	
    	DeliverySchedule d = dsDao.findByScheduleCode(scheduleCode);
    	System.out.println(scheduleCode);
    	d.setDate(date);
    	d.setOutlet(outlet);
    	d.setDeliveryReceiptCode(drCode);
    	
    	d = dsDao.save(d);
    	
    	return d.getScheduleCode()!= null;
    	
    }
    public boolean deleteDeliverySchedule(String scheduleCode) {
    	DeliverySchedule d = dsDao.findByScheduleCode(scheduleCode);
    	dsDao.delete(d);
    	
    	return d.getScheduleCode()!= null;
    	
    }
}