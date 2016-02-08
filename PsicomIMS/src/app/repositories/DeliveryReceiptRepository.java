package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import app.entity.DeliveryReceipt;


@Repository
public interface DeliveryReceiptRepository extends JpaRepository<DeliveryReceipt, Long> {
	public DeliveryReceipt findByDeliveryReceiptNumber(String deliverReceiptNumber);
}
