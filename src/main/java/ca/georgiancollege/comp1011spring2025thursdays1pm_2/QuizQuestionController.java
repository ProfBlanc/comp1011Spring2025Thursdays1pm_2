package ca.georgiancollege.comp1011spring2025thursdays1pm_2;

import javafx.scene.image.Image;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;

public class QuizQuestionController {

    @FXML
    private Button btnSubmit;

    @FXML
    private ImageView imgAvatar;

    @FXML
    private RadioButton rbOption1, rbOption2, rbOption3, rbOption4;

    @FXML
    private Label txtCorrectAnswers, txtNickname, txtQuestion, txtQuestionsRemaining, txtTotalQuestions;

    private Participant participant;

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    @FXML
    private void initialize() {

        txtNickname.setText(participant.getName());
        imgAvatar.setImage(participant.getAvatar());


    }
}
