package nl.programit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.programit.domain.ExamView;

@Component
public interface TestViewsRepository extends CrudRepository<ExamView, Integer> {
	
}