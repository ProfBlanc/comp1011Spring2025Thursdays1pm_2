module ca.georgiancollege.comp1011spring2025thursdays1pm_2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;


    opens ca.georgiancollege.comp1011spring2025thursdays1pm_2 to javafx.fxml, com.google.gson;
    exports ca.georgiancollege.comp1011spring2025thursdays1pm_2;
}