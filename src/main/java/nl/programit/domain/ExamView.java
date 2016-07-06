package nl.programit.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Entity
public class ExamView implements Serializable {

	private static final long serialVersionUID = 6392649144473391793L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String description;
	private String examType;			// Exam, subject, ...
	
	@OneToMany (mappedBy = "testView")
	private List<ExamViewsContent> examViewsList;

	/****** Local Vars        ******************************************************/

	@Transient
	private int questionNr;
	
	@Transient
	private List<ExamViewsContent> sortedExamViewsList;

	/****** Methods           ******************************************************/
	
	public void startTest(){
		// sort questions on order nr
		sortedExamViewsList = new ArrayList<>(examViewsList);
		sortedExamViewsList.sort(new Comparator<ExamViewsContent>() {
			public int compare(ExamViewsContent a, ExamViewsContent b){
				return Integer.compare(a.orderNr, b.orderNr);
			}
		});
		// start with question nr 1 (questionNr is index thus starts with 0)
		questionNr = 0;
	}

	public ExamViewsContent getNextQuestion(){
		if (questionNr <sortedExamViewsList.size()-1) questionNr++; // no next question if already at last
		System.out.println("getNextQuestion - sortedTestViewsList.size: " + sortedExamViewsList.size());
		System.out.println("getNextQuestion - sortedTestViewsListIndex: " + questionNr);
		return sortedExamViewsList.get(questionNr);
	}

	public ExamViewsContent getPrevQuestion(){
		if (questionNr > 0) questionNr--; // no previous question if already at 1
		return sortedExamViewsList.get(questionNr);
	}

	// Set current question to index and return its value in table sortedTestViewsList 
//	public TestViewsContent getQuestionNr(int index) {
//		if (index >= 0 && index < sortedTestViewsList.size()) questionNr = index;
//		else questionNr = 0;
//		return sortedTestViewsList.get(questionNr);
//	}

	public ExamViewsContent getCurrentQuestion() {
		return sortedExamViewsList.get(questionNr);	
	}
	
	public int getNrOfQuestions() {
		return sortedExamViewsList.size();
	}

	/****** Getters & Setters ******************************************************/
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getExamType() {
		return examType;
	}
	public void setExamType(String testType) {
		this.examType = testType;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<ExamViewsContent> getTestViewsList() {
		return examViewsList;
	}

	public void setTestViewsList(List<ExamViewsContent> testViewsList) {
		this.examViewsList = testViewsList;
	}

	public int getQuestionNr() {
		return questionNr;
	}

	public void setQuestionNr(int questionNr) {
		this.questionNr = questionNr;
	}

	public List<ExamViewsContent> getSortedTestViewsList() {
		return sortedExamViewsList;
	}

	@Override
	public String toString() {
		return "TestViews{" +
				"id=" + id +
				", description='" + description + '\'' +
				", testType='" + examType + '\'' +
				", testViewsList=" + examViewsList +
				", questionNr=" + questionNr +
				", sortedTestViewsList=" + sortedExamViewsList +
				'}';
	}
}
