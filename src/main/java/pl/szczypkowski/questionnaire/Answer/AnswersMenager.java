package pl.szczypkowski.questionnaire.Answer;


import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswersMenager {

    private AnswersRepo answersRepo;

    public AnswersMenager(AnswersRepo answersRepo)
    {
        this.answersRepo=answersRepo;
    }
    public Optional<Answers> findById(Long id)
    {
        return answersRepo.findById(id);
    }
    public Iterable<Answers> findAll()
    {
        return answersRepo.findAll();
    }
    public Answers save (Answers answers)
    {
        return answersRepo.save(answers);
    }
    public void deleteAnswer(Long id)
    {
        answersRepo.deleteById(id);
    }
    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        save(new Answers("Tak","wszystko działa jak należy",""));
        save(new Answers("Nie","usługa nie jest dostępna lub nie działa w weekendy","polepszyć jakość usługi w moim regionie"));
    }


}
