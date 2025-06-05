package ca.georgiancollege.comp1011spring2025thursdays1pm_2;

import java.util.ArrayList;
import java.util.Arrays;

public class Quiz {
    private ArrayList<Question> questions = new ArrayList<>();

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Question ...questions) {
        this.questions.clear();
        this.questions.addAll(Arrays.asList(questions));
    }

    public Quiz(Question ...questions) {
        setQuestions(questions);
    }
}
