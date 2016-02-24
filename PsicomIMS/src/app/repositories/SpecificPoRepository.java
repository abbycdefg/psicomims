package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Book;
import app.entity.SpecificPo;
import app.entity.User;

public interface SpecificPoRepository  extends JpaRepository<SpecificPo, Long> {
	

	public SpecificPo findByBookId(Book bookId);
	public SpecificPo findById(Long id);
	
}




