package app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DeliverySchedule {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long scheduleCode;
	
	@Column	
	private String date;
	
	@Column
	private String outlet;
	
	@Column
	private String deliveryReceiptCode;
	
	
	public Long getScheduleCode() {
		return scheduleCode;
	}
	public void setScheduleCode(Long scheduleCode) {
		this.scheduleCode = scheduleCode;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
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
