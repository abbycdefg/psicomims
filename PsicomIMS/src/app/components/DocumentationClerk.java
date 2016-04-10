package app.components;

import java.io.*;

import javax.annotation.PostConstruct;
import javax.persistence.metamodel.ListAttribute;
import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

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
    		System.out.println(poNumber);
            return p.checkPONumber(poNumber);
        }
        catch(Exception e)
        {
            return false;
        }
        
    }
	public boolean checkDeliveryReceipt(String drNumber)
    {
        try
        {
            DeliveryReceipt d = drDao.findByDeliveryReceiptNumber(drNumber);
            return d.checkDRNumber(drNumber);
        }
        catch(Exception e)
        {
            return false;
        }
        
    }
	public boolean checkJobOrder(String joNumber)
    {
        try
        {
            JobOrder j = joDao.findByJoNumber(joNumber);
            return j.checkJobOrder(joNumber);
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
    	p.setPoStatus("INCOMPLETE");
    	p.setCounter(0);
    	p = poDao.save(p);
    	   	
    	for(int i = 0; i<booksList.size(); i++)
    	{
    		int bQty = 0;
    		SpecificPo sp = new SpecificPo();
    		Book b = bookDao.findByItemCode(booksList.get(i)); 
    		System.out.println(b + "check book");
    		if(b!=null)
    		{    		
    		bQty = b.getQuantity();
    		sp.setStatus("INCOMPLETE");	
    		sp.setBookId(b);
			listOfBooks.add(b);
    		}
    		
    		PurchaseOrder po = poDao.findByPurchaseOrderNumber(poNumber);
    		sp.setPoId(po);
    		
    		if(quantityList.get(i) != null)
    		{
    			String quantity = quantityList.get(i);
    			
    			if (quantity != "")
    			{    			
    			int qty = Integer.parseInt(quantity);
    			sp.setQuantity(qty);
    			int newQty = bQty - qty;
    			System.out.println(newQty);
    			b.setQuantity(newQty);
    			}
    		}
    		
    		spoDao.save(sp); 
    		bookDao.save(b);
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
    public boolean createDeliveryReceipt(String drNumber, String dateToday, String totalAmt, String dateDelivery, String poNumber, String order, String outlet, List<String> booksList, List<String> quantityList)
    {     	
    	DeliveryReceipt d = new DeliveryReceipt();
    	Set<Book> listOfBooks= new HashSet<Book>();
    	System.out.println(order);
    	d.setDeliveryReceiptNumber(drNumber);
    	d.setDateToday(dateToday);
    	d.setTotalAmount(totalAmt);
    	d.setDateDelivery(dateDelivery);
    	d.setPurchaseOrderNumber(poNumber);
    	d.setOutlet(outlet);
    	d.setOrders(order);
    	d = drDao.save(d);
    	
    	
    	for(int i = 0; i<booksList.size(); i++)
    	{
    		SpecificDr sd = new SpecificDr();
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
    public boolean editDeliveryReceipt(String drNumber, String dateToday, String totalAmt, String dateDelivery, List<String> booksList, List<String> quantityList)
    {   
    	Set<Book> listOfBooks= new HashSet<Book>();
    	DeliveryReceipt d = drDao.findByDeliveryReceiptNumber(drNumber);
    	
    	d.setDeliveryReceiptNumber(drNumber);
    	d.setDateToday(dateToday);
    	d.setTotalAmount(totalAmt);
    	d.setDateDelivery(dateDelivery);
    	d = drDao.save(d);
    	
		List<SpecificDr> sdsList = sdrDao.findAll();
		List<Book> bookList = new ArrayList();
		for(int j = 0; j<sdsList.size(); j++)
    	{
			if(sdsList.get(j).getDrId().getDeliveryReceiptNumber().equals(drNumber))
			{
				bookList.add(sdsList.get(j).getBookId());
			}
    	}
		
    	for(int i = 0; i<bookList.size(); i++)
    	{
    		Book b = bookList.get(i);
    		SpecificDr sd = sdrDao.findByDrIdAndBookId(d, b);
    		System.out.println(sd + "findByDrIdAndBookId");
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
    			if (quantity != "")
    			{
    			int qty = Integer.parseInt(quantity);
    			sd.setQuantity(qty);
    			}
    		}
    		
    		sdrDao.save(sd);    		
    		System.out.println(sd + "    sdr");
    	}   	

    	System.out.println(listOfBooks);

    	d = drDao.save(d);
   
    	return d.getId()!= null;
    	
    }
    public boolean deleteDeliveryReceipt(String drNumber)
    {

    	DeliveryReceipt d = drDao.findByDeliveryReceiptNumber(drNumber);
    	System.out.println(d);
    	drDao.delete(d);
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
       
    public int getPOCounter(String poId) {

    	PurchaseOrder p = poDao.findByPurchaseOrderNumber(poId);
    	int c = p.getCounter();
    	
    	return c;
    	
    }
    
}