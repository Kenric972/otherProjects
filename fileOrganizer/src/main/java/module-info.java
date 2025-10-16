module org.example.fileorganizer {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.fileorganizer to javafx.fxml;
    exports org.example.fileorganizer;
}