package ca.georgiancollege.comp1011spring2025thursdays1pm_2;

import java.util.ArrayList;
import java.util.Arrays;

public class Question {
    private String text;
    private int correctAnswer;
    private ArrayList<QuestionOption> options = new ArrayList<>();

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public ArrayList<QuestionOption> getOptions() {
        return options;
    }

    public void setOptions(QuestionOption ...options) {

        this.options.clear();
        this.options.addAll(Arrays.asList(options));

    }
    public Question(String text, QuestionOption ...options) {
        setText(text);
        setOptions(options);
        setCorrectAnswer(0);
    }
}
