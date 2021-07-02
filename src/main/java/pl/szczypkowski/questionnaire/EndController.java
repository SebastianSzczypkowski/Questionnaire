package pl.szczypkowski.questionnaire;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.szczypkowski.questionnaire.Answer.Answers;
import pl.szczypkowski.questionnaire.Answer.AnswersMenager;
import pl.szczypkowski.questionnaire.Questionnaire.Questionnaire;
import pl.szczypkowski.questionnaire.Questionnaire.QuestionnaireMenager;

import java.security.Principal;
import java.util.List;
@Controller
public class EndController {


    private AnswersMenager answersMenager;
    private QuestionnaireMenager questionnaireMenager;
    @Autowired
    public EndController(AnswersMenager answersMenager,QuestionnaireMenager questionnaireMenager)
    {
        this.answersMenager=answersMenager;
        this.questionnaireMenager=questionnaireMenager;
    }

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(EndController.class);

    @RequestMapping(value = "/end",method = RequestMethod.GET)
    public String end(Model model)
    {

       List<Answers> answersList = (List<Answers>) answersMenager.findAll();
       List<Questionnaire> questionnaires = (List<Questionnaire>) questionnaireMenager.findAll();

        log.info("Odpowiedzi: "+answersList);
        model.addAttribute("answers",answersList);
        model.addAttribute("users",questionnaires);

        return "end";
    }
}
