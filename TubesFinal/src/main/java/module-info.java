module com.example.tubesfinal {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tubesfinal to javafx.fxml;
    exports com.example.tubesfinal;
}