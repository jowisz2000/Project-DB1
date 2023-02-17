package com.example.project_db1.Controller;

import com.example.project_db1.DAO;
import com.example.project_db1.Entities.Team;
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

public class TeamController implements Initializable {

    @FXML
    private TextField txtFoundationYear;
    @FXML
    private TextField txtName;
    @FXML
    private TableColumn<Team, String> nameColumn;
    @FXML
    private TableColumn<Team, Integer> foundationYearColumn;
    @FXML
    private TableView<Team> teamTable = new TableView<>();

    @FXML
    private void insertTeam(){
        try {
            DAO.add("team", txtName.getText(), txtFoundationYear.getText());
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        foundationYearColumn.setCellValueFactory(new PropertyValueFactory<>("foundationYear"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ObservableList<Team> listaDruzyn;
        try {
            listaDruzyn = DAO.getAllTeamRecords();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        teamTable.setItems(listaDruzyn);
    }

    public void switchToApp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
