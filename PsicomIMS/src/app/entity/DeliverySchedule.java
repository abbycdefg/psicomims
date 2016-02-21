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
	private Long id;
	
	@Column	
	private String date;
	
	@Column	
	private String scheduleCode;
	
	@Column
	private String outlet;
	
	@Column
	private String deliveryReceiptCode;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getScheduleCode() {
		return scheduleCode;
	}
	public void setScheduleCode(String scheduleCode) {
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
