package nl.programit.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Answer implements Serializable {
	private static final long serialVersionUID = 8261990086527443473L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@ManyToOne
	@JoinColumn(name="questionID")
	private Question question;
	
	
	@Override
	public String toString() {
		return "Answer [question=" + question + "]";
	}
	
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
