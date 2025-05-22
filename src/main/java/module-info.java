module ca.georgiancollege.comp1011spring2025thursdays1pm_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.georgiancollege.comp1011spring2025thursdays1pm_2 to javafx.fxml;
    exports ca.georgiancollege.comp1011spring2025thursdays1pm_2;
}