package ca.georgiancollege.comp1011spring2025thursdays1pm_2;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableIntegerValue;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

public class CameraController {

    @FXML
    private ComboBox<String> cbBrand;

    @FXML
    private ComboBox<CameraModel> cbCameraList;

    private ArrayList<CameraModel> cameraList = new ArrayList<>();

    @FXML
    private ComboBox<String> cbMode;

    @FXML
    private TextField txtColor;

    @FXML
    private TextField txtResolution;

    @FXML
    private TextField txtWeight;

    @FXML
    private TextArea output;

    @FXML
    private Slider sldPrice;

    @FXML
    private Button btnRandom;


    private CameraModel model = new CameraModel();

    @FXML
    void submitCameraChoice(ActionEvent event) {

        int index = cbCameraList.getSelectionModel().getSelectedIndex();
        output.setText(cameraList.get(index).toString());


    }

    @FXML
    private void initialize(){

//        cbBrand.getItems().addAll("Canon", "Nikon", "Sony", "FujiFilm");
//        cbBrand.getItems().add("Other");

        cbBrand.getItems().addAll(CameraModel.getAllBrands());
        cbMode.getItems().addAll(CameraModel.getAllModes());

        cbBrand.getSelectionModel().selectFirst();
        cbMode.getSelectionModel().selectFirst();

        /*
        Create a method is CameraModel return a list of brands, modes
            use this list to populate the cbBrand & cbMode

        Add these values to the cbBrand & cbMode in initialize()
         */
        ChangeListener listener = new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue <? extends Number> observable, Number oldValue, Number newValue) {

            }
        };
        sldPrice.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue <? extends Number> observable, Number oldValue, Number newValue) {}
                }
        );
//        sldPrice.valueProperty().addListener(
//
//                (observable, oldValue, newValue) ->
//                {
//            System.out.println("Old Value = " + oldValue.doubleValue());
//            System.out.println("New Value " + newValue.doubleValue());
//        }
//        );

        btnRandom.setOnAction(e -> System.out.println("Random Button Pressed")    );

    }

    @FXML
    void submitCameraForm(ActionEvent event) {
//        System.out.println(CameraModel.Brands.CANON);
//        System.out.println(txtColor.getText());
//
//        output.setText(txtResolution.getText());

        /*
            create a toString method that summarized the CameraModel instance variable objects
            in submitForm: use the setters to set each instance variable
            attempt to output the toString of model (CameraModel) to output Node
            clear the values of TextField, set ComboBoxes to first value



         */
        try{
            model.setColor(txtColor.getText());
            model.setMode(CameraModel.Modes.valueOf(cbMode.getSelectionModel().getSelectedItem()));
            model.setBrand(CameraModel.Brands.valueOf(cbBrand.getSelectionModel().getSelectedItem()));
            model.setResolution(Double.parseDouble(txtResolution.getText()));
            model.setWeight(Float.parseFloat(txtWeight.getText()));
            output.setText(model.toString());

            //add create a new CameraModel to add to the lists to avoid reference issues ()
            cameraList.add(model);
            cbCameraList.getItems().add(model);

            txtColor.clear();
            txtResolution.clear();
            txtWeight.clear();
            cbBrand.getSelectionModel().selectFirst();
            cbMode.getSelectionModel().selectFirst();

        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }


    }

    /*
            Add price attribute/instance variable to CameraModel
                double range: 100-1000 (inc)
                add getter and setter. set the restricturions in setter
     */

}