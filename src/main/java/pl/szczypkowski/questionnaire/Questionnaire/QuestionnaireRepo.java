package pl.szczypkowski.questionnaire.Questionnaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.szczypkowski.questionnaire.Questionnaire.Questionnaire;

@Repository
public interface QuestionnaireRepo extends JpaRepository<Questionnaire,Long> {

}
