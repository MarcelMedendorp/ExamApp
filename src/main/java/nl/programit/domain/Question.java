package nl.programit.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Question implements Serializable {
	private static final long serialVersionUID = 7708606312784085748L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int questionID;
	
	@Column(name = "code", columnDefinition = "TEXT")
	private String code;
	@Column(columnDefinition = "TEXT")
	private String content;
	
	private Difficulty difficulty;
	@Column(name = "is_marked", columnDefinition = "INT default 0")
	private boolean isMarked;
	private Status status;
	@Column(name = "feedback", columnDefinition = "TEXT")
	private String feedback;
	@Column(name = "has_feedback", columnDefinition = "INT default 0")
	private boolean hasFeedback;
	private String internetLink;
	// één internetlink is niet genoeg!!!
	@OneToMany(mappedBy="question")
	private List<Answer> answers;
	@ManyToOne
	@JoinColumn(name = "categoryID")
	private Category category;
	@Transient
	private boolean correct;
	//waarom staat hier een boolean correct?
		
	@Override
	public String toString() {
		return "Question [questionID=" + questionID + ", code=" + code + ", content=" + content + ", difficulty="
				+ difficulty + ", isMarked=" + isMarked + ", status=" + status + ", feedback=" + feedback
				+ ", hasFeedback=" + hasFeedback + ", internetLink=" + internetLink + ", answers=" + answers
				+ ", category=" + category + ", correct=" + correct + "]";
	}
	public int getQuestionID() {
		return questionID;
	}
	
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Difficulty getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}
	public boolean isMarked() {
		return isMarked;
	}
	public void setMarked(boolean isMarked) {
		this.isMarked = isMarked;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public boolean isHasFeedback() {
		return hasFeedback;
	}
	public void setHasFeedback(boolean hasFeedback) {
		this.hasFeedback = hasFeedback;
	}
	public String getInternetLink() {
		return internetLink;
	}
	public void setInternetLink(String internetLink) {
		this.internetLink = internetLink;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public boolean isCorrect() {
		return correct;
	}
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
