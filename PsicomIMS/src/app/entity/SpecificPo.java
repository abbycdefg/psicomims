package app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SpecificPo implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long id;
	
	@JoinColumn(name="book_id")
	@ManyToOne(fetch=FetchType.LAZY)
	private Book bookId;
	
	@JoinColumn(name="po_id")
	@ManyToOne(fetch=FetchType.LAZY)
	private PurchaseOrder poId;
	
	private int quantity;
	
	@Column
	private String status;

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Book getBookId() {
		return bookId;
	}
	public void setBookId(Book bookId) {
		this.bookId = bookId;
	}
	public PurchaseOrder getPoId() {
		return poId;
	}
	public void setPoId(PurchaseOrder poId) {
		this.poId = poId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
