package com.example.project_db1.Controller;

import com.example.project_db1.DAO;
import com.example.project_db1.Entities.Coach;
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

public class CoachController implements Initializable {

    @FXML
    private TextField txtIdCoach;
    @FXML
    private TextField txtTeamName;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtRole;
    @FXML
    private TableColumn<Coach, Integer> idCoachColumn;
    @FXML
    private TableColumn<Coach, Integer> teamNameColumn;
    @FXML
    private TableColumn<Coach, String> firstNameColumn;
    @FXML
    private TableColumn<Coach, String> lastNameColumn;
    @FXML
    private TableColumn<Coach, String> roleColumn;

    @FXML
    private TableView<Coach> coachTable = new TableView<>();

    @FXML
    private void insertTrener(){
        try {
            DAO.add("coach", txtIdCoach.getText(), txtFirstName.getText(), txtLastName.getText(), txtRole.getText(), txtTeamName.getText());
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idCoachColumn.setCellValueFactory(new PropertyValueFactory<>("idCoach"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
        teamNameColumn.setCellValueFactory(new PropertyValueFactory<>("teamName"));
        ObservableList<Coach> coachList;
        try {
            coachList = DAO.getAllTrenerRecords();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        coachTable.setItems(coachList);
    }

    public void switchToApp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
