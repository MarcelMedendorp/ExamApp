package nl.programit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.programit.domain.ExamResults;
import nl.programit.domain.User;

@Component
public interface ExamResultRepository extends CrudRepository<ExamResults, Integer>{

	Iterable<ExamResults> findByUser(User user);

}
