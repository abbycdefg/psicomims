package app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	
    private List<Book> bookTitles;

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

	public List<Book> getBookTitles() {
		return bookTitles;
	}

	public void setBookTitles(List<Book> bookTitles) {
		this.bookTitles = bookTitles;
	}

	
}
