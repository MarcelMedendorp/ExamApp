package nl.programit.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.programit.domain.Question;

@Component
public interface QuestionRepository extends CrudRepository<Question, Integer> {
	
	//Question findOne(int questionId);
	
	//find last
	List<Question> findTop1ByOrderByQuestionIDDesc();
		

}

