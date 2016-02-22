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
public class SpecificDr implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long id;
	
	@JoinColumn(name="book_id")
	@ManyToOne(fetch=FetchType.LAZY)
	private Book bookId;
	
	@JoinColumn(name="dr_id")
	@ManyToOne(fetch=FetchType.LAZY)
	private DeliveryReceipt drId;
		
	private int quantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Book getBookId() {
		return bookId;
	}

	public void setBookId(Book bookId) {
		this.bookId = bookId;
	}

	public DeliveryReceipt getDrId() {
		return drId;
	}

	public void setDrId(DeliveryReceipt drId) {
		this.drId = drId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}	

}
