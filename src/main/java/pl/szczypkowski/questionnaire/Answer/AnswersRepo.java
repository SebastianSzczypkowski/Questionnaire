package pl.szczypkowski.questionnaire.Answer;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.szczypkowski.questionnaire.Answer.Answers;

@Repository
public interface AnswersRepo extends JpaRepository<Answers,Long> {

}
