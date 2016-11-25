package ca.sheridancollege.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User implements Serializable{

	@Id
	private String username;
	private String fName;
	private String lName;
	private String password;
	private String email;
	//private List<Wiki> articles;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/*public List<Wiki> getArticles() {
		return articles;
	}

	public void setArticles(List<Wiki> articles) {
		this.articles = articles;
	}*/

	public User() {
		super();
	}

	public User(String username, String fName, String lName, String password, String email) {
		super();
		this.username = username;
		this.fName = fName;
		this.lName = lName;
		this.password = password;
		this.email = email;
	}

}
