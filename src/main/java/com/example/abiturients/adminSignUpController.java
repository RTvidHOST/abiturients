package com.example.abiturients;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class adminSignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back;

    @FXML
    private TextField login;

    @FXML
    private TextField password;

    @FXML
    private Button signUp;

    @FXML
    void initialize() {
        signUp.setOnAction(event -> {
            String loginText = login.getText().trim();
            String passwordText = password.getText().trim();
            if (!loginText.equals("") && !passwordText.equals("")) {
                loginAdmin(loginText, passwordText);
            } else
                System.out.println("ERROR");
        });
    }

    private void loginAdmin(String loginText, String passwordText) {
        DbHandler dbHandler = new DbHandler();
        Admin admin = new Admin();
        admin.setLogin(loginText);
        admin.setPassword(passwordText);
        dbHandler.getAdmin(admin);
        ResultSet result = dbHandler.getAdmin(admin);
        int counter = 0;
        while (true) {
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            counter++;
        }
        if (counter >= 1) {
            signUp.setOnAction(event -> {
                signUp.getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("adminAddAb.fxml"));
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
}
