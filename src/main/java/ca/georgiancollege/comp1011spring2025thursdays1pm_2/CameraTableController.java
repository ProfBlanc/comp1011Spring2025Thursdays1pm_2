package ca.georgiancollege.comp1011spring2025thursdays1pm_2;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class CameraTableController {

    @FXML
    private TableView<CameraModel> tableView;

    @FXML
    private void initialize() {

TableColumn<CameraModel, String> columnColor = new TableColumn<>("Color Name");
columnColor.setCellValueFactory(new PropertyValueFactory<>("color"));

TableColumn<CameraModel, Double> columnResolution = new TableColumn<>("Resolution In Pixels");
columnResolution.setCellValueFactory(new PropertyValueFactory<>("resolution"));

//String color, double resolution, float weight, Brands brand, Modes mode
ArrayList<CameraModel> cameras = new ArrayList<>();
cameras.add(
        new CameraModel("Black", 1080, 250, CameraModel.Brands.FUJIFILM, CameraModel.Modes.AUTO)
);
        cameras.add(
                new CameraModel("Blue", 3000, 500, CameraModel.Brands.CANON,
                        CameraModel.Modes.MANUAL)
        );

    tableView.getColumns().add(columnColor);
    tableView.getColumns().add(columnResolution);

        tableView.getItems().addAll(cameras);

    }

}
