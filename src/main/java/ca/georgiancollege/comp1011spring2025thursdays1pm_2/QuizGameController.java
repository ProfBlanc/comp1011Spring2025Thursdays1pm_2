package ca.georgiancollege.comp1011spring2025thursdays1pm_2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.List;
import java.util.stream.Collectors;

public class QuizGameController {

    @FXML
    private Button btnSubmit;

    @FXML
    private ComboBox<String> cbNickname;

    @FXML
    private ImageView imgAvatar;

    @FXML
    private Spinner<Integer> imgSpinner;

    @FXML
    private void initialize() {

        cbNickname.getItems().addAll(Participant.listOfNames());
        cbNickname.getSelectionModel().selectFirst();

        List<Image> images;

        images = Participant.listOfAvatars().stream()
                .map(v -> new Image(getClass().getResourceAsStream(("images/avatars/" + v)))).toList();


        //set the params of the Spinner
        imgSpinner.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, images.size() - 1, 0)
        );

        //set action/behaviour when user changes spinner value
        imgSpinner.valueProperty().addListener(
(observable, oldValue, newValue)-> imgAvatar.setImage(images.get(newValue))
        );

        btnSubmit.setOnAction(event -> {

            try{

                Participant participant = new Participant(cbNickname.getValue(), imgAvatar.getImage());

                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("quiz-game-questions-view.fxml"));

                QuizQuestionController controller = new QuizQuestionController();
                controller.setParticipant(participant);
                fxmlLoader.setController(controller);

                Scene scene = new Scene(fxmlLoader.load());
                stage.setTitle("Quiz Time!");
                stage.setScene(scene);
                stage.show();


            }
            catch(Exception e) {
                System.err.println(e.getMessage());
            }

        });
    }

}
