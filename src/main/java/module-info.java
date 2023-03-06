module com.example.abiturients {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.abiturients to javafx.fxml;
    exports com.example.abiturients;
}