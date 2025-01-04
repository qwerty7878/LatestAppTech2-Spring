module com.example.testannotation {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.testannotation to javafx.fxml;
    exports com.example.testannotation;
}