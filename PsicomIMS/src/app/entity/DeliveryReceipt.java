package app.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class DeliveryReceipt {
	

	
	@Id
	@Column
	@Size(min=1, max=9)
	private String deliveryReceiptNumber;

	@Column	
	private Date dateToday;
	
	@Column	
	private double totalAmount;
	
	@Column
	private Date dateDelivery;
	
	@Column
	@Size(min=1, max=9)
	private String purchaseOrderNumber;
	
	@Column
	private String orders;
	
	@Column
	@Size(min=2, max=30)
	private String outlet;
	
	@Column
	private String status;
		
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrders() {
		return orders;
	}

	public void setOrders(String orders) {
		this.orders = orders;
	}

	@OneToMany(cascade={CascadeType.ALL}, mappedBy = "drId")
	private Set<SpecificDr> specDr;

	
	public String getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}

	public void setPurchaseOrderNumber(String poNumber) {
		this.purchaseOrderNumber = poNumber;
	}

	public String getOutlet() {
		return outlet;
	}

	public void setOutlet(String outlet) {
		this.outlet = outlet;
	}

	public String getDeliveryReceiptNumber() {
		return deliveryReceiptNumber;
	}

	public void setDeliveryReceiptNumber(String deliveryReceiptNumber) {
		this.deliveryReceiptNumber = deliveryReceiptNumber;
	}


	public Date getDateToday() {
		return dateToday;
	}

	public void setDateToday(java.util.Date dt) {
		this.dateToday = (Date) dt;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getDateDelivery() {
		return dateDelivery;
	}

	public void setDateDelivery(java.util.Date dd) {
		this.dateDelivery = (Date) dd;
	}

	public boolean checkDRNumber(String deliveryReceiptNumber){
		return deliveryReceiptNumber.equals(this.deliveryReceiptNumber);
	}

	public Set<SpecificDr> getSpecDr() {
		return specDr;
	}

	public void setSpecDr(Set<SpecificDr> specDr) {
		this.specDr = specDr;
	}

	
}