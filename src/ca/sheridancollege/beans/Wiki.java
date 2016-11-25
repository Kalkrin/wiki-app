package ca.sheridancollege.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Wiki implements Serializable{

	@Id
	private String title;
	private String subject;
	private String text;
	private Date modified;
	private String edited; 
	private String[] subjects;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public String getEdited() {
		return edited;
	}

	public void setEdited(String edited) {
		this.edited = edited;
	}

	public String[] getSubjects() {
		return subjects;
	}

	public void setSubjects(String[] subjects) {
		this.subjects = subjects;
	}

	public Wiki() {
		this.subjects = new String[] {"History", "Science", "Math", "Literature", "Media", "Politics", "Law"};
	}

	public Wiki(String title, String subject, String text) {
		this.title = title;
		this.subject = subject;
		this.text = text;
		this.subjects = new String[] {"History", "Science", "Math", "Literature", "Media", "Politics", "Law"};
	}

}
