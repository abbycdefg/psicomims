package app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class DeliverySchedule {
	
	
	
	@Column	
	private Date date;
	
	@Id
	@Column	
	@Size(min=1, max=9)
	private String scheduleCode;
	
	@Column
	@Size(min=2, max=30)
	private String outlet;
	
	@Column
	@Size(min=1, max=9)
	private String deliveryReceiptCode;
	
	
	public String getScheduleCode() {
		return scheduleCode;
	}
	public void setScheduleCode(String scheduleCode) {
		this.scheduleCode = scheduleCode;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getOutlet() {
		return outlet;
	}
	public void setOutlet(String outlet) {
		this.outlet = outlet;
	}
	public String getDeliveryReceiptCode() {
		return deliveryReceiptCode;
	}
	public void setDeliveryReceiptCode(String deliveryReceiptCode) {
		this.deliveryReceiptCode = deliveryReceiptCode;
	}
	
	

}
