package app.components;

import java.io.*;

import javax.annotation.PostConstruct;
import javax.swing.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import app.entity.Outlet;
import app.entity.User;
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
            Outlet o = outletDao.findById(outletDao.findByOutletId(outletId).getId());
            return o.checkId(outletDao.findByOutletId(outletId).getId());
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
    
    public String getOutletId(String outletId){
    	Outlet o = outletDao.findByOutletId(outletId);
    	return o.getOutletId();
    }
   
}