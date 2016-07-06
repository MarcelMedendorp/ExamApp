package nl.programit.service;

import nl.programit.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.programit.domain.ExamResults;
import nl.programit.repository.ExamResultRepository;

@Service
public class ExamResultService {
	
	@Autowired
	private ExamResultRepository examResultRepository;

	public ExamResults saveTestResult(ExamResults testResult) {
		return examResultRepository.save(testResult);
	}

	
	public Iterable<ExamResults> findAll() {
		return this.examResultRepository.findAll();
	}

	public ExamResults findById(int examID) {
		
		return this.examResultRepository.findOne(examID);
	}

	public Iterable<ExamResults> findByUser(User user) {
		return examResultRepository.findByUser(user);
	}
}
