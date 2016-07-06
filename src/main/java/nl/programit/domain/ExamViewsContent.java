package nl.programit.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*
* This table is used by table TestViews.
* Tests are defined in table TestViews. This table contains the questions of each tests.
*/

@Entity
public class ExamViewsContent implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "testViewsId")
//	int testViewsId;// Id of TestViews table for this question
	ExamView examView;	// Test in TestViews table to which this question belongs 
	
	Integer orderNr;	// defines nr of the question within the test
	Integer questionId;	// Id of question
	
	/****** Vars  NOT in DB   ******************************************************/
/*	
	@Transient
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="myQuestionId")
	private Question question;
*/	
	/****** Getters & Setters ******************************************************/
	
	public ExamView getExamViews() {
		return examView;
	}
	public void setExamViews(ExamView examView) {
		this.examView = examView;
	}
	public Integer getOrderNr() {
		return orderNr;
	}
	public void setOrderNr(Integer orderNr) {
		this.orderNr = orderNr;
	}
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "TestViewsContent{" +
				"id=" + id +
				", testView=" + examView +
				", orderNr=" + orderNr +
				", questionId=" + questionId +
				'}';
	}
}
