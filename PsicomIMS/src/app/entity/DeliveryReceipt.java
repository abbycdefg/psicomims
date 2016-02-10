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
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long id;

	@Column
	private String deliveryReceiptNumber;

	@Column	
	private String dateToday;
	
	@Column	
	private String totalAmount;
	
	@Column
	private String dateDelivery;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "specific_dr", joinColumns = {@JoinColumn(name = "dr_id")}, inverseJoinColumns = {@JoinColumn(name = "book_id")} )
	public Set<Book> books;

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
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

	
}
