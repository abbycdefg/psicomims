package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.PurchaseOrder;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> 
{
	public PurchaseOrder findByPurchaseOrderNumber(String poNumber);
	public PurchaseOrder findById(Long id);
}