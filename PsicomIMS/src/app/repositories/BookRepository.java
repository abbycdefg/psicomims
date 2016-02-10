package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> 
{
	public Book findByItemCode(String itemCode);
}