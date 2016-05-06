package app.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.validation.constraints.Size;

@Entity
public class Book implements Serializable{
	

	@Column
	@Size(min=2, max=50)
	private String title;
	
	@Id
	@Column	
	@Size(min=1, max=12)
	private String itemCode;
	
	@Column	
	private double price;
	
	@Column	
	@Size(min=2, max=30)
	private String author;
	
	@Column
	private Date releaseDate;
	
	
	@Column	
	private int threshold;
	
	@Column
	private String state;

	@OneToMany(cascade={CascadeType.ALL}, mappedBy = "bookId")
	private Set<SpecificPo> specPo;
	
	@OneToMany(cascade={CascadeType.ALL}, mappedBy = "bookId")
	private Set<SpecificDr> specDr;	

	@Column
	private int quantity;

	
	public int getThreshold() {
		return threshold;
	}
	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}
	public Set<SpecificDr> getSpecDr() {
		return specDr;
	}
	public void setSpecDr(Set<SpecificDr> specDr) {
		this.specDr = specDr;
	}

	public Set<SpecificPo> getSpecPo() {
		return specPo;
	}
	public void setSpecPo(Set<SpecificPo> specPo) {
		this.specPo = specPo;
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

	
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity1) {
		quantity = quantity1;
	}

    public boolean checkItemCode(String itemCode) {
        return itemCode.equals( this.itemCode );
    }
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
