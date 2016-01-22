package app.components;

import java.io.*;

import javax.annotation.PostConstruct;
import javax.swing.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import app.entity.User;
import app.repositories.UserRepository;

import java.util.*;

@Component
public class Admin 
{
	
	@Autowired
	private UserRepository userDao;
	
	
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
   
}