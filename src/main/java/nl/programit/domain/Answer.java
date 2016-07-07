package nl.programit.domain;

import java.io.Serializable;

import javax.persistence.Column;
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
	private int answerID;
	@ManyToOne
	@JoinColumn(name="questionID")
	private Question question;
	
	@Column(columnDefinition = "TEXT")
	private String content;

	@Column(nullable = false, columnDefinition = "INT default 0")
	private boolean correct;

	@Column(columnDefinition = "TEXT")
	private String explanation;
	
	
	
	
	@Override
	public String toString() {
		return "Answer [answerID=" + answerID 
				+ ", question=" + question 
				+ ", content=" + content 
				+ ", correct="+ correct 
				+ ", explanation=" + explanation + "]";
	}

	public int getAnswerID() {
		return answerID;
	}

	public void setAnswerID(int answerID) {
		this.answerID = answerID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
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
