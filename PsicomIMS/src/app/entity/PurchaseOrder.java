package app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PurchaseOrder implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long id;

	@Column
	private String purchaseOrderNumber;

	@Column	
	private String dateToday;
	
	@Column	
	private String contactPerson;
	
	@Column
	private String outlet;
	
	@OneToMany(cascade={CascadeType.ALL}, mappedBy="po")
    private List<Book> bookTitles;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	public String getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}
	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
	}
	public String getDateToday() {
		return dateToday;
	}
	public void setDateToday(String dateToday) {
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
	public List<Book> getBookTitle() {
		return bookTitles;
	}
	public void setBookTitle(List<Book> bookTitles) {
		this.bookTitles = bookTitles;
	}
	
	public boolean checkPONumber(String purchaseOrderNumber){
		return purchaseOrderNumber.equals(this.purchaseOrderNumber);
	}
	
    public void addBooks(Book b){
    	b.setPurchaseOrder(this);
    	bookTitles.add(b);
    }
}
