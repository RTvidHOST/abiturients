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

public class signUpModerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button admin;

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
                loginModer(loginText, passwordText);
            } else
                System.out.println("ERROR");
        });
        admin.setOnAction(event -> {
            admin.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("adminSignUp.fxml"));
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

    private void loginModer(String loginText, String passwordText) {
        DbHandler dbHandler = new DbHandler();
        Moder moder = new Moder();
        moder.setLogin(loginText);
        moder.setPassword(passwordText);
        dbHandler.getModer(moder);
        ResultSet result = dbHandler.getModer(moder);
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

}
