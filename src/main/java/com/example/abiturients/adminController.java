package com.example.abiturients;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class adminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button abiturients;

    @FXML
    private Button addModer;

    @FXML
    private Button deleteModer;

    @FXML
    private TableColumn<tablemoder, Integer> id;

    @FXML
    private TableColumn<tablemoder, String> login;

    @FXML
    private TableColumn<tablemoder, String> password;

    @FXML
    private TableView<tablemoder> tableAd;

    @FXML
    private Text text;

    Integer index;

    public static String data;

    DbHandler dbHandler = new DbHandler();

    ObservableList<tablemoder> tableModer = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        abiturients.setOnAction(event -> {
            abiturients.getScene().getWindow().hide();
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

        addModer.setOnAction(event -> {
            addModer.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("addModer.fxml"));
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

        deleteModer.setOnAction(event -> {
            DbHandler dbHandler = new DbHandler();
            dbHandler.deleteModer(login.getText(), password.getText());
        });

        moderInf();
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        login.setCellValueFactory(new PropertyValueFactory<>("login"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        tableAd.setItems(tableModer);
    }

    private void moderInf() {
        ResultSet moder = dbHandler.tableModer();
        try {
            while (moder.next()) {
                tablemoder tablemoder1 = new tablemoder(moder.getInt(1), moder.getString(2), moder.getString(3));
                tableModer.add(tablemoder1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void getID(javafx.scene.input.MouseEvent mouseEvent) {
        index = tableAd.getSelectionModel().getSelectedIndex();

        if (index <= -1){
            return;
        }
        id.setText(id.getCellData(index).toString());
        text.setText(data);
        text.setText(id.getCellData(index).toString());
    }
}
