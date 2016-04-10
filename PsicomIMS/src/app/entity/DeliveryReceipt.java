package app.entity;

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

@Entity
public class DeliveryReceipt {
	

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long id;
	
	@Id
	@Column
	private String deliveryReceiptNumber;

	@Column	
	private String dateToday;
	
	@Column	
	private String totalAmount;
	
	@Column
	private String dateDelivery;
	
	@Column
	private String purchaseOrderNumber;
	
	@Column
	private String orders;
	
	@Column
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeliveryReceiptNumber() {
		return deliveryReceiptNumber;
	}

	public void setDeliveryReceiptNumber(String deliveryReceiptNumber) {
		this.deliveryReceiptNumber = deliveryReceiptNumber;
	}

	public String getDateToday() {
		return dateToday;
	}

	public void setDateToday(String dateToday) {
		this.dateToday = dateToday;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getDateDelivery() {
		return dateDelivery;
	}

	public void setDateDelivery(String dateDelivery) {
		this.dateDelivery = dateDelivery;
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