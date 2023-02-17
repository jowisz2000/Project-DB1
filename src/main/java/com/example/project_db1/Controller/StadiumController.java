package com.example.project_db1.Controller;

import com.example.project_db1.DAO;
import com.example.project_db1.Entities.Stadium;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class StadiumController implements Initializable {

    @FXML
    private TextField txtCity;
    @FXML
    private TextField txtCapacity;
    @FXML
    private TextField txtName;
    @FXML
    private TableColumn<Stadium, String> cityColumn;
    @FXML
    private TableColumn<Stadium, Integer> capacityColumn;
    @FXML
    private TableColumn<Stadium, String> nameColumn;
    @FXML
    private TableView<Stadium> stadiumTable;

    @FXML
    private void insertStadium(){
        try {
            DAO.add("stadium", txtName.getText(), txtCity.getText(), txtCapacity.getText());
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        cityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        capacityColumn.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("stadiumName"));
        ObservableList<Stadium> stadionList;
        try {
            stadionList = DAO.getAllStadiumRecords();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        stadiumTable.setItems(stadionList);
    }

    public void switchToApp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
