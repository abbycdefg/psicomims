package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.DeliverySchedule;



@Repository
public interface DeliveryScheduleRepository extends JpaRepository<DeliverySchedule, Long> {

		public DeliverySchedule findByScheduleCode(String scheduleCode);
}

