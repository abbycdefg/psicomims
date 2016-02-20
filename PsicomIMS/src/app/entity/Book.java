package app.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Book implements Serializable{
	

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long id;

	@Column
	private String title;
	
	@Id
	@Column	
	private String itemCode;
	
	@Column	
	private double price;
	
	@Column	
	private String author;
	
	@Column
	private String releaseDate;
	
	@Column
	private String location;
	
<<<<<<< HEAD
	@OneToMany(cascade={CascadeType.ALL}, mappedBy = "bookId")
	private Set<SpecificPo> specPo;
	
	
=======
	@Column
>>>>>>> bb791bb21ff21383c8a5f2b3235a04558d28d89c
	private int quantity;

	private double discountedPrice;
	private double srp;
	
<<<<<<< HEAD
	
	public Set<SpecificPo> getSpecPo() {
		return specPo;
	}
	public void setSpecPo(Set<SpecificPo> specPo) {
		this.specPo = specPo;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	@JoinColumn(name="purchase_order_number")
	@ManyToOne(fetch=FetchType.LAZY)
	private PurchaseOrder po;
	

=======
>>>>>>> bb791bb21ff21383c8a5f2b3235a04558d28d89c
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

    public boolean checkItemCode(String itemCode) {
        return itemCode.equals( this.itemCode );
    }

	
}
