package pl.szczypkowski.questionnaire.Answer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.szczypkowski.questionnaire.EndController;
import pl.szczypkowski.questionnaire.Questionnaire.Questionnaire;
import pl.szczypkowski.questionnaire.Questionnaire.QuestionnaireMenager;

import java.util.List;

@Controller
public class AnswersController {

    private AnswersMenager answersMenager;
    private QuestionnaireMenager questionnaireMenager;
    @Autowired
    public AnswersController(AnswersMenager answersMenager,QuestionnaireMenager questionnaireMenager)
    {
        this.answersMenager=answersMenager;
        this.questionnaireMenager=questionnaireMenager;
    }
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AnswersController.class);

    @GetMapping("/answers")
    public String getAllAnswers(Model model)
    {
        List<Answers> answersList = (List<Answers>) answersMenager.findAll();
        List<Questionnaire> questionnaireList =(List<Questionnaire>) questionnaireMenager.findAll();


        model.addAttribute("newanswer",new Answers());
        model.addAttribute("answers",answersList);
        model.addAttribute("users",questionnaireList);
        return "answers";
    }
    @PostMapping("/add-answer")
    public String addAnswers(@ModelAttribute AnswersForm answersForm )
    {
        Answers newanswer = new Answers(answersForm.getAnswer1(),answersForm.getAnswer2(),answersForm.getAnswer3());
        answersMenager.save(newanswer);
        List<Answers> answersList = (List<Answers>) answersMenager.findAll();
        log.info("Rozxmiar: "+answersList.size());
        return "redirect:/end";
    }


}
