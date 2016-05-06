package app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class JobOrder implements Serializable{
	
	
	
	@Id
	@Column
	@Size(min=1, max=9)
	private String joNumber;
	
	@Column
	private Date date;
	
	@Column
	@Size(min=1, max=12)
	private String itemCode;
	
	@Column
	private String title;
	
	@Column
	private int quantity;
	
	@Column
	private String joStatus;
	
	@Column
	private String remainingOrders;
	
	public String getRemainingOrders() {
		return remainingOrders;
	}
	public void setRemainingOrders(String remainingOrders) {
		this.remainingOrders = remainingOrders;
	}
	public String getJoStatus() {
		return joStatus;
	}
	public void setJoStatus(String status) {
		this.joStatus = status;
	}

	public String getJoNumber() {
		return joNumber;
	}
	public void setJoNumber(String joNumber) {
		this.joNumber = joNumber;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean checkJobOrder(String joNumber){
		return joNumber.equals(this.joNumber);
	}
	

}
