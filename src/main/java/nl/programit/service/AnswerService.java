package nl.programit.service;

import nl.programit.domain.Answer;
import nl.programit.domain.Question;
import nl.programit.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    @Autowired
    AnswerRepository answerRepository;

    public Answer saveAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    public Iterable<Answer> findAllByQuestion(Question question) {
        Iterable<Answer> itr = answerRepository.findAllByQuestion(question);

        return itr ;
    }

    public Answer findOne(int id){
        return answerRepository.findOne(id);
    }
}
