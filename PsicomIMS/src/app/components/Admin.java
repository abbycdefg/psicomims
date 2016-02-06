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
    
    //fix
    public boolean checkOutlet(String outletId)
    {
        try
        {
            Outlet o = outletDao.findByOutletId(outletId);
            return o.checkOutletId(outletId);
        }
        catch(Exception e)
        {
            return false;
        }
        
    }
    
    public boolean addOutlet(String outletId, String outletName, String dateCreated) {
    	Outlet o = new Outlet();
    	o.setOutletId(outletId);
    	o.setOutletName(outletName);
    	o.setDateCreated(dateCreated);
    	o = outletDao.save(o);
    	
    	return o.getId()!= null;    	
    }
    
    public boolean editOutlet(String outletId, String outletName) {
    	Outlet o = outletDao.findByOutletId(outletId);
    	o.setOutletId(outletId);
    	o.setOutletName(outletName);
    	o = outletDao.save(o);
    	
    	return o.getId()!= null;    	
    }
    
    public boolean deleteOutlet(String outletId) {
    	try{
	    	Outlet o = outletDao.findByOutletId(outletId);
	    	outletDao.delete(o);    	    	
	    	return true;  
	    }
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
    }
    
    public String getOutletId(String outletId){
    	Outlet o = outletDao.findByOutletId(outletId);
    	return o.getOutletId();
    }
    
  //fix
    public boolean checkContactPerson(String contactPersonId)
    {
        try
        {
        	ContactPerson c = contactPersonDao.findByContactPersonId(contactPersonId);
            return c.checkContactPersonId(contactPersonId);
        }
        catch(Exception e)
        {
            return false;
        }
        
    }
    
    public boolean addContactPerson(String contactPersonId, String contactPersonName, String dateCreated) {
    	ContactPerson c = new ContactPerson();
    	c.setContactPersonId(contactPersonId);
    	c.setContactPersonName(contactPersonName);
    	c.setDateCreated(dateCreated);
    	c = contactPersonDao.save(c);
    	
    	return c.getId()!= null;    	
    }
    
    public boolean editContactPerson(String contactPersonId, String contactPersonName) {
    	ContactPerson c = contactPersonDao.findByContactPersonId(contactPersonId);
    	c.setContactPersonId(contactPersonId);
    	c.setContactPersonName(contactPersonName);
    	c = contactPersonDao.save(c);
    	
    	return c.getId()!= null;    	
    }
    
    public boolean deleteContactPerson(String contactPersonId) {
    	try{
    		ContactPerson c = contactPersonDao.findByContactPersonId(contactPersonId);
    		contactPersonDao.delete(c);    	    	
	    	return true;  
	    }
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
    }
    
    public String getContactPersonId(String contactPersonId){
    	ContactPerson c = contactPersonDao.findByContactPersonId(contactPersonId);
    	return c.getContactPersonId();
    }
   
}