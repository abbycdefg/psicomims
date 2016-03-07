package app.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Book;
import app.entity.DeliveryReceipt;
import app.entity.PurchaseOrder;
import app.entity.SpecificDr;
import app.entity.SpecificPo;

public interface SpecificDrRepository extends JpaRepository<SpecificDr, Long> {
	public SpecificDr findByDrId(DeliveryReceipt drId);
	public SpecificDr findByDrIdAndBookId(DeliveryReceipt drId, Book bookId);

}
