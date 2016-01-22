package app.components;

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
    
    public boolean addBook(String title, String itemCode, double price, String author, String releaseDate) {
    	Book b = new Book();
    	b.setTitle(title);
    	b.setItemCode(itemCode);
    	b.setPrice(price);
    	b.setAuthor(author);
    	b.setReleaseDate(releaseDate);
    	b = bookDao.save(b);
    	
    	return b.getId()!= null;    	
    }
    

}
