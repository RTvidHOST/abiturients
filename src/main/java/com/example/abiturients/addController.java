package com.example.abiturients;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class addController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addBut;

    @FXML
    private TextField att;

    @FXML
    private Button back;

    @FXML
    private TextField dad;

    @FXML
    private DatePicker dateR;

    @FXML
    private TextField family;

    @FXML
    private TextField form;

    @FXML
    private TextField name;

    @FXML
    void initialize() {
        DbHandler dbhandler = new DbHandler();
        addBut.setOnAction(event -> {
            dbhandler.addAb(family.getText(), name.getText(), dad.getText(),
                    dateR.getValue(), form.getText(), att.getText());
            addBut.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = fxmlLoader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }
}