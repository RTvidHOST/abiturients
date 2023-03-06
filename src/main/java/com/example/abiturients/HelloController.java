package com.example.abiturients;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addAb;

    @FXML
    private TableColumn<tableAd, String> att;

    @FXML
    private TableColumn<tableAd, Date> birthday;

    @FXML
    private TableColumn<tableAd, String> dad;

    @FXML
    private Button deleteAd;

    @FXML
    private TableColumn<tableAd, String> family;

    @FXML
    private TableColumn<tableAd, String> form;

    @FXML
    private TableColumn<tableAd, Integer> id;

    @FXML
    private TableColumn<tableAd, String> name;

    @FXML
    private TableView<tableAd> tableAd;

    @FXML
    private Text text;
    public static String data;

    @FXML
    private Button updateAb;

    ObservableList<tableAd> tableAds = FXCollections.observableArrayList();
    Integer index;

    DbHandler dbHandler = new DbHandler();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        updateAb.setOnAction(event -> {
            updateAb.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("update.fxml"));
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

        deleteAd.setOnAction(event -> {
            DbHandler dbHandler = new DbHandler();
            dbHandler.deleteAb(family.getText(), name.getText(), dad.getText(), LocalDate.parse(birthday.getText()), form.getText(), att.getText());
        });

        abInf();
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        family.setCellValueFactory(new PropertyValueFactory<>("family"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        dad.setCellValueFactory(new PropertyValueFactory<>("dad"));
        birthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        form.setCellValueFactory(new PropertyValueFactory<>("form"));
        att.setCellValueFactory(new PropertyValueFactory<>("att"));
        tableAd.setItems(tableAds);
    }

    private void abInf() {
        ResultSet abit = dbHandler.tableAd();
        try {
            while (abit.next()) {
                tableAd tableAd1 = new tableAd(abit.getInt(1), abit.getString(2),
                        abit.getString(3), abit.getString(4),
                        abit.getDate(5), abit.getString(6), abit.getString(7));
                tableAds.add(tableAd1);
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
