package pl.szczypkowski.questionnaire.Questionnaire;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.szczypkowski.questionnaire.Answer.Answers;
import pl.szczypkowski.questionnaire.Answer.AnswersMenager;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class
QuestionnaireController {

    private QuestionnaireMenager questionnaireMenager;
    private AnswersMenager answersMenager;
    @Autowired
    public QuestionnaireController(QuestionnaireMenager questionnaireMenager,AnswersMenager answersMenager)
    {
        this.questionnaireMenager=questionnaireMenager;
        this.answersMenager=answersMenager;
    }

    @GetMapping("/questionnaire/all")
    public Iterable<Questionnaire> getAll(){
        return questionnaireMenager.findAll();
    }
    @GetMapping("/questionnaire/byId")
    public Optional<Questionnaire> getByID(@RequestParam Long index)
    {
        return questionnaireMenager.findById(index);
    }


    @GetMapping("/questionnaire")
    public String get(Model model)
    {
        List<Answers> answersList = (List<Answers>) answersMenager.findAll();

        model.addAttribute("answers",answersList);
        model.addAttribute("newquestionnaire",new Questionnaire());
        return "questionnaire";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute("newquestionnaire") @Valid UserForm userForm, BindingResult bindingResult)
    {
        Questionnaire questionnaireNew = new Questionnaire(userForm.getName(), userForm.getSurname(),userForm.getBirthday() );

        if(bindingResult.hasErrors())
        {
            return "questionnaire";
        }
        else {
            questionnaireMenager.save(questionnaireNew);
            return "redirect:/answers";
        }

    }
    @PutMapping
    public Questionnaire updateQuestionnaire(@RequestBody Questionnaire questionnaire)
    {
        return questionnaireMenager.save(questionnaire);
    }
    @DeleteMapping
    public void  deleteQuestionnaire(Long index)
    {
        questionnaireMenager.deleteQuestionnaire(index);
    }


}
