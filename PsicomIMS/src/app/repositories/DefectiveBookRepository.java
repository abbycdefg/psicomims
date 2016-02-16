package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Book;
import app.entity.DefectiveBook;

@Repository
public interface DefectiveBookRepository extends JpaRepository<DefectiveBook, Long> 
{
	public DefectiveBook findByItemCode(String itemCode);
}