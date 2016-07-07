package nl.programit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.programit.domain.ExamView;
import nl.programit.repository.ExamViewsRepository;

@Service
@Transactional
public class ExamViewsService {

	@Autowired
	private ExamViewsRepository examViewsRepository;

	public ExamView findById(int examviewId) {
		return examViewsRepository.findOne(examviewId);
	}

	public Iterable<ExamView> findAll() {
		return examViewsRepository.findAll();
	}

	public ExamView saveExamViews(ExamView examViews) {
		return examViewsRepository.save(examViews);

	}

}
