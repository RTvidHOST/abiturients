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

public class updateController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    private Button updateBut;

    @FXML
    void initialize() {
        DbHandler dbhandler = new DbHandler();
        updateBut.setOnAction(event -> {
            dbhandler.updateAb(family.getText(), name.getText(), dad.getText(),
                    dateR.getValue(), form.getText(), att.getText());
            updateBut.getScene().getWindow().hide();
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
