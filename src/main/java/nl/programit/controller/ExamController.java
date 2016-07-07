package nl.programit.controller;
//Marcel

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nl.programit.domain.Question;
import nl.programit.domain.ExamView;
import nl.programit.service.QuestionService;
import nl.programit.service.ExamViewsService;
import nl.programit.service.ExamViewsService;

@Controller
public class ExamController {


    @Autowired
    private ExamViewsService examViewsService;

    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "/examsave", method = RequestMethod.POST)
    String createExam(@ModelAttribute("testviews") ExamView examViews, Model model) {
        System.out.println("this is" + examViews);
        examViewsService.saveExamViews(examViews);
        List<ExamView> testViewses= (List<ExamView>) examViewsService.findAll();
        ExamView latestTest = testViewses.get(testViewses.size()-1);
        examViews = examViewsService.findById(latestTest.getId());
        model.addAttribute("latesttestview",examViews );
        model.addAttribute("questions", questionService.findAll());
        model.addAttribute("selectedQuestions", new ArrayList<Question>());
        
        return "addQuestToExam";
    }

    @RequestMapping(value = "/saveQuestToExam", method = RequestMethod.POST)
    public String saveQuestToExam(@ModelAttribute("selectedQuestions") ArrayList<Question> question, Model model) {

        System.out.println(question);


        return "index";
    }
}

