package app.components;

import java.io.*;

import javax.annotation.PostConstruct;
import javax.swing.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import app.entity.ContactPerson;
import app.entity.Outlet;
import app.entity.User;
import app.repositories.ContactPersonRepository;
import app.repositories.OutletRepository;
import app.repositories.UserRepository;

import java.util.*;

@Component
public class Admin 
{
	
	@Autowired
	private UserRepository userDao;
	
	@Autowired
	private OutletRepository outletDao;
	
	@Autowired
	private ContactPersonRepository contactPersonDao;
	
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
    
    public boolean addUser(String username, String password) {
    	User u = new User();
    	u.setUsername(username);
    	u.setPassword(password);
    	u = userDao.save(u);
    	
    	return u.getId()!= null;    	
    }
    

    public boolean updatePassword(String username, String newPassword) {

    	User u = userDao.findByUsername(username);
    	u.setPassword(newPassword);
    	u = userDao.save(u);
    	
    	return u.getId()!= null;    	
    }
    
    public String getUsername(String username){
    	User u = userDao.findByUsername(username);
    	return u.getUsername();
    }
    
    public String getPassword(String username){
    	User u = userDao.findByUsername(username);
    	return u.getPassword();
    }
    
    public boolean checkOutlet(String outletName)
    {
        try
        {
            Outlet o = outletDao.findByOutletName(outletName);
            return o.checkOutletName(outletName);
        }
        catch(Exception e)
        {
            return false;
        }
        
    }
    
    public boolean addOutlet(String outletName, String dateCreated, float discountPercent) {
    	Outlet o = new Outlet();
    	o.setOutletName(outletName);
    	o.setDateCreated(dateCreated);
    	o.setDiscountPercent(discountPercent);
    	o = outletDao.save(o);
    	
    	return o.getOutletId()!= null;    	
    }
    
    public boolean editOutlet(String outletId, String outletName, float discountPercent) {
    	Outlet o = outletDao.findByOutletId(Long.parseLong(outletId));
    	o.setOutletName(outletName);
    	o.setDiscountPercent(discountPercent);
    	o = outletDao.save(o);
    	
    	return o.getOutletId()!= null;    	
    }
    
    public boolean deleteOutlet(String outletId) {
    	try{
	    	Outlet o = outletDao.findByOutletId(Long.parseLong(outletId));
	    	outletDao.delete(o);    	    	
	    	return true;  
	    }
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
    }
    
    public Long getOutletId(String outletId){
    	Outlet o = outletDao.findByOutletId(Long.parseLong(outletId));
    	return o.getOutletId();
    }
    
    public boolean checkContactPerson(String contactPersonName)
    {
        try
        {
        	ContactPerson c = contactPersonDao.findByContactPersonName(contactPersonName);
            return c.checkContactPersonName(contactPersonName);
        }
        catch(Exception e)
        {
            return false;
        }
        
    }
    
    public boolean addContactPerson(String contactPersonName, String dateCreated) {
    	ContactPerson c = new ContactPerson();
    	c.setContactPersonName(contactPersonName);
    	c.setDateCreated(dateCreated);
    	c = contactPersonDao.save(c);
    	
    	return c.getContactPersonId()!= null;    	
    }
    
    public boolean editContactPerson(String contactPersonId, String contactPersonName) {
    	ContactPerson c = contactPersonDao.findByContactPersonId(Long.parseLong(contactPersonId));
    	c.setContactPersonName(contactPersonName);
    	c = contactPersonDao.save(c);
    	
    	return c.getContactPersonId()!= null;    	
    }
    
    public boolean deleteContactPerson(String contactPersonId) {
    	try{
    		ContactPerson c = contactPersonDao.findByContactPersonId(Long.parseLong(contactPersonId));
    		contactPersonDao.delete(c);    	    	
	    	return true;  
	    }
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
    }
    
    public Long getContactPersonId(String contactPersonId){
    	ContactPerson c = contactPersonDao.findByContactPersonId(Long.parseLong(contactPersonId));
    	return c.getContactPersonId();
    }
   
}