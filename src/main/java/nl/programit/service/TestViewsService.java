package nl.programit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.programit.domain.ExamView;
import nl.programit.repository.TestViewsRepository;

@Service
@Transactional
public class TestViewsService {

	@Autowired
	private TestViewsRepository testViewsRepository;

	public ExamView findById(int testviewId) {
		return testViewsRepository.findOne(testviewId);
	}

	public Iterable<ExamView> findAll() {
		return testViewsRepository.findAll();
	}

	public ExamView saveTestViews(ExamView testViews) {
		return testViewsRepository.save(testViews);

	}

}
