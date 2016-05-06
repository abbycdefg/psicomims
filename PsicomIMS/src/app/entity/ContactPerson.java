package app.entity;

import java.io.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class ContactPerson implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
    private Long contactPersonId;
	
	@Column
	@Size(min=2, max=30)
    private String contactPersonName;
	
	@Column
    private String dateCreated;
	

	public Long getContactPersonId() {
		return contactPersonId;
	}

	public void setContactPersonId(Long id) {
		this.contactPersonId = id;
	}

	public String getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public Object getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	
    public boolean checkContactPersonName(String contactPersonName) {
        return contactPersonName.equalsIgnoreCase(this.contactPersonName);
    }
    	
}
