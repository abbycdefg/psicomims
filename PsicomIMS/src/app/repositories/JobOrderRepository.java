package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sun.xml.internal.bind.v2.model.core.ID;

import app.entity.JobOrder;

@Repository
public interface JobOrderRepository extends JpaRepository<JobOrder, Long> 
{
	public JobOrder findByJoNumber(String joNumber);
	public JobOrder findByItemCode(String itemCode);
}