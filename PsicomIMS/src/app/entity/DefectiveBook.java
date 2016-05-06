package app.entity;

import java.io.Serializable;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class DefectiveBook implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long id;

	@Column	
	@Size(min=1, max=12)
	private String itemCode;
	
	@Column
	@Size(min=2, max=50)
	private String title;
	
	@Column
	@Size(min=2, max=30)
	private String outlet;
	
	@Column
	private String state;
		
	@Column
	private int defectsQuantity;
	
	@Column
	private Date dateCreated;
	
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getOutlet() {
		return outlet;
	}
	public void setOutlet(String outlet) {
		this.outlet = outlet;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
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
	public int getDefectsQuantity() {
		return defectsQuantity;
	}
	public void setDefectsQuantity(int defectsQuantity) {
		this.defectsQuantity = defectsQuantity;
	}
}
