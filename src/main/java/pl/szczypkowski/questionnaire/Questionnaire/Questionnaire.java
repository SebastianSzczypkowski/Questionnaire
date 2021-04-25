package pl.szczypkowski.questionnaire.Questionnaire;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class
Questionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min=3 ,max=25)
    private String name;
    @NotNull
    @Size(min=3 ,max=25)
    private String surname;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;


    public Questionnaire() {
    }

    public Questionnaire(String name, String surname, LocalDate birthday) {

        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Questionnaire{" +
                ", Name='" + name + '\'' +
                ", Surname='" + surname + '\'' +
                ", Birthday=" + birthday +
                '}';
    }
}
