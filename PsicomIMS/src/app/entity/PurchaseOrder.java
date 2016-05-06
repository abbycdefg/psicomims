package app.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class PurchaseOrder implements Serializable{
	
	
	@Id
	@Column
	@Size(min=1, max=9)
	private String purchaseOrderNumber;

	@Column	
	private Date dateToday;
	
	@Column	
	@Size(min=2, max=30)
	private String contactPerson;
	
	@Column
	@Size(min=2, max=30)
	private String outlet;
	
	@OneToMany(cascade={CascadeType.ALL}, mappedBy = "poId")
	private Set<SpecificPo> specPo;
	
	@Column
	private String poStatus;	
	
	@Column
	private int counter;
	
	
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public String getPoStatus() {
		return poStatus;
	}
	public void setPoStatus(String poStatus) {
		this.poStatus = poStatus;
	}
	public Set<SpecificPo> getSpecPo() {
		return specPo;
	}
	public void setSpecPo(Set<SpecificPo> specPo) {
		this.specPo = specPo;
	}

	public String getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}
	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
	}

	public Date getDateToday() {
		return dateToday;
	}
	public void setDateToday(Date dateToday) {
		this.dateToday = dateToday;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getOutlet() {
		return outlet;
	}
	public void setOutlet(String outlet) {
		this.outlet = outlet;
	}
	
	public boolean checkPONumber(String purchaseOrderNumber){
		return purchaseOrderNumber.equals(this.purchaseOrderNumber);
	}
	

}
