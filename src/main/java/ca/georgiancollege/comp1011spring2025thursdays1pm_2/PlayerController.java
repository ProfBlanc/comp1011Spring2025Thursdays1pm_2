package com.example.demo5;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlayerController {

    @FXML private TableView<Player> table;
    @FXML private TableColumn<Player, Integer> colId;
    @FXML private TableColumn<Player, String> colName;
    @FXML private TableColumn<Player, String> colPosition;
    @FXML private TextField searchField;

    private List<Player> allPlayers = new ArrayList<>();

    @FXML
    public void initialize() {
        // Use PropertyValueFactory for simple getters
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("full_name"));
        colPosition.setCellValueFactory(new PropertyValueFactory<>("position"));

        // Set double-click on row to open details
        table.setRowFactory(tv -> {
            TableRow<Player> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getClickCount() == 2) {
                    Player clickedPlayer = row.getItem();
                    showDetail(clickedPlayer);
                }
            });
            return row;
        });

        // Search filter
        searchField.textProperty().addListener((obs, oldValue, newValue) -> filterPlayers(newValue));


            try {
                List<Player> fetchedPlayers = new PlayerAPI().fetchAll(100);
                allPlayers.addAll(fetchedPlayers);
                javafx.application.Platform.runLater(() -> table.getItems().setAll(allPlayers));
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

    }

    private void filterPlayers(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            table.getItems().setAll(allPlayers);
            return;
        }
        String lowerKeyword = keyword.toLowerCase();
        List<Player> filtered = new ArrayList<>();
        for (Player p : allPlayers) {
            String fullName = p.getFull_name().toLowerCase();
            if (fullName.contains(lowerKeyword)) {
                filtered.add(p);
            }
        }
        table.getItems().setAll(filtered);
    }

    private void showDetail(Player player) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("To Be Implemented");
        alert.setHeaderText("Your turn");
        alert.setContentText("Attempt to set player details on another screen. Open and display this new scene");
        alert.showAndWait();

    }
}
