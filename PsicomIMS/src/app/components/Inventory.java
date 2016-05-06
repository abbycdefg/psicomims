package app.components;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Book;
import app.repositories.BookRepository;


@Component
public class Inventory {
	
	@Autowired
	private BookRepository bookDao;
	
	
    public boolean checkItemCode(String itemCode)
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
    
    public boolean addBook(String title, String itemCode, double price, String author, String releaseDate, String state, int threshold) {
    	Book b = new Book();
    	b.setTitle(title);
    	b.setItemCode(itemCode);
    	b.setPrice(price);
    	b.setAuthor(author);
    	DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    	Date rd = null;

		try {
			rd = df.parse(releaseDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	b.setReleaseDate(rd);
    	b.setState(state);
    	b.setThreshold(threshold);
    	b = bookDao.save(b);
    	
    	return b.getItemCode()!= null;    	
    }
    
    public boolean editBook(String title, String itemCode, double price, String author, String releaseDate, int threshold) {
    	Book b = bookDao.findByItemCode(itemCode);
    	b.setTitle(title);
    	b.setPrice(price);
    	b.setAuthor(author);
    	DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    	Date rd = null;

		try {
			rd = df.parse(releaseDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	b.setReleaseDate(rd);
    	b.setThreshold(threshold);
    	b = bookDao.save(b);
    	
    	return b.getItemCode()!= null;    	
    }
    
    public boolean deleteBook(String itemCode) {
    	Book b = bookDao.findByItemCode(itemCode);
    	bookDao.delete(b);
    	
    	return b.getItemCode()!= null;    	
    }
    

}
