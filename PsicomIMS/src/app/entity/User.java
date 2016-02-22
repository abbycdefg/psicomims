package app.entity;

import java.io.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class User implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
    private Long id;

	@Column
	@NotNull
    private String username;
	
	@Column
	@NotNull
    private String password;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
 
    public boolean checkUsername(String username) {
        return username.equals( this.username );
    }

	
}
