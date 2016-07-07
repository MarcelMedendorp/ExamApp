package nl.programit.controller;
//Remond

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nl.programit.domain.Answer;
import nl.programit.domain.Category;
import nl.programit.domain.ExamView;
import nl.programit.domain.Question;
import nl.programit.service.AnswerService;
import nl.programit.service.CategoryService;
import nl.programit.service.QuestionService;



@Controller//zorgt ervoor dat Java deze class automatisch runt en zo de pagina's hier beneden in de gaten houd
public class WebController {
	
	private static String toTheCreateNewCategoryPage = "category";
	private static String toTheLoginPage = "login";
	private static String toTheIndexPage = "index";
	private static String toTheNextQuestionOfTheExamPage = "redirect:/loadExamQuestion";
	private static String toTheAddAnswersToTheQuestionPage = "vraag";
	private static String toTheAddExamToTheDatabasePage = "addExam";

    @Autowired//zorgt ervoor dat java zelf uitzoekt hoe die onderstaand object koppelt
    CategoryService categoryService;

    @Autowired
    QuestionService questionService;
    
    @Autowired
    AnswerService answerService;

    @RequestMapping("/")//zodra je naar pagina localhost:8888/ gaat voert die automatisch deze methode uit
    public String start(){
        return toTheLoginPage;
    }

    @RequestMapping("/login")
    public String login (){
        return toTheLoginPage;
    }

    @RequestMapping("/index")
    public String index (){
        return toTheIndexPage;
    }

//onderstaande methode zorgt voor het volgende:
//als je na de pagina localhost:8888/vraag gaat, dan handeld deze methode het af en geeft aan de pagina via de variable model
//gegevens mee aan de webpagina deze kunnen vervolgens door thymeleaf worden gebruikt, hij geeft dus een leeg object van 
//Question mee, zodat alle velden hiervan beschikbaar zijn voor de pagina tevens haalt die alle categorien op voor het pulldown
//menu op de pagina, zodat die is geveld met alle categorien die op dat moment in de database zitten.

    @RequestMapping("/vraag")
    public String createQuestion(Model model){
        model.addAttribute("question", new Question());
        model.addAttribute("categories", categoryService.findAll());
        return toTheAddAnswersToTheQuestionPage;
    }
  //onderstaande methode zorgt voor het volgende:
  //als je na de pagina localhost:8888/createexam gaat, dan handeld deze methode het af en geeft aan de pagina via de variable model
  //gegevens mee aan de webpagina deze kunnen vervolgens door thymeleaf worden gebruikt, hij geeft dus een leeg object van 
  //ExamView mee, zodat alle velden hiervan beschikbaar zijn voor de pagina op te roepen via de variablee testviews in de pagina zelf
  //Als die klaar is gaat die naar de pagina addExam
    @RequestMapping("/createexam")
    public String createExam(Model model) {
        model.addAttribute("testviews", new ExamView());

        return toTheAddExamToTheDatabasePage;
    }
  //onderstaande methode zorgt voor het volgende:
  //als je na de pagina localhost:8888/categorysave gaat, kun je via de variable category in thymeleaf de variabelen van Category
  //bereiken en vullen als je die vervolgens op de pagina submit, dan zorgt de pagina category ervoor dat deze worden opgeslagen in de database 
    @RequestMapping("/categorysave")
    public String createCategory(Model model){
        model.addAttribute("category", new Category());
        return toTheCreateNewCategoryPage;
    }

  //onderstaande methode zorgt voor het volgende:
  //als je na de pagina localhost:8888/registerQuestion gaat, geeft het POST aan dat die daar invoer verwacht
  //op de pagina laat die alle antwoorden zien die bij de vraag horen die die via het model reeds binnen krijgt
    @RequestMapping(value = "/registerQuestion", method = RequestMethod.POST)
    String saveQuestion(Model model, @ModelAttribute("answers") ArrayList<Answer> answers){
        for(Answer x:answers) {
            System.out.println(x);
        }
        return toTheNextQuestionOfTheExamPage;
    }


    @Autowired
    private ErrorAttributes errorAttributes;

    @Bean
    public AppErrorController appErrorController(){
    	return new AppErrorController(errorAttributes);
    }


}

