package pl.szczypkowski.questionnaire;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.szczypkowski.questionnaire.Answer.Answers;
import pl.szczypkowski.questionnaire.Answer.AnswersMenager;

import java.security.Principal;
import java.util.List;
@Controller
public class EndController {


    private AnswersMenager answersMenager;
    @Autowired
    public EndController(AnswersMenager answersMenager)
    {
        this.answersMenager=answersMenager;
    }

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(EndController.class);

    @RequestMapping(value = "/end",method = RequestMethod.GET)
    public String end(Model model)
    {

       List<Answers> answersList = (List<Answers>) answersMenager.findAll();
        log.info("TUTUTUUTUTUTUTUTU: "+answersList);
        model.addAttribute("answers",answersList);

        return "end";
    }
}
