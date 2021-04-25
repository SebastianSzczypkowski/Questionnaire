package pl.szczypkowski.questionnaire.Questionnaire;


import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class QuestionnaireMenager {

    private QuestionnaireRepo questionnaireRepo;

    public QuestionnaireMenager(QuestionnaireRepo questionnaireRepo) {
        this.questionnaireRepo=questionnaireRepo;
    }

   public Optional<Questionnaire> findById(Long id)
   {
       return questionnaireRepo.findById(id);
   }
   public Iterable<Questionnaire> findAll()
   {
       return questionnaireRepo.findAll();
   }
   public Questionnaire save(Questionnaire questionnaire)
   {
       return questionnaireRepo.save(questionnaire);
   }
   public void deleteQuestionnaire(Long id)
   {
       questionnaireRepo.deleteById(id);
   }
   @EventListener(ApplicationReadyEvent.class)
    public void fillDB()
   {
       save(new Questionnaire("Sebastian","Szczypkowski",LocalDate.of(1998,5,5)));
       save(new Questionnaire("Kuba","Tarka",LocalDate.of(1997,6,5)));
   }


}
