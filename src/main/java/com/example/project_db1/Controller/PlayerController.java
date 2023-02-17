package com.example.project_db1.Controller;

import com.example.project_db1.DAO;
import com.example.project_db1.Entities.Player;
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

public class PlayerController implements Initializable {
    @FXML
    private TextField txtIdPlayer;
    @FXML
    private TextField txtTeamName;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtAge;
    @FXML
    private TextField txtPosition;
    @FXML
    private TableColumn<Player, Integer> idPlayerColumn;
    @FXML
    private TableColumn<Player, Integer> teamNameColumn;
    @FXML
    private TableColumn<Player, String> firstNameColumn;
    @FXML
    private TableColumn<Player, String> lastNameColumn;
    @FXML
    private TableColumn<Player, String> positionColumn;
    @FXML
    private TableColumn<Player, Integer> ageColumn;
    @FXML
    private TableView<Player> playerTable = new TableView<>();

    @FXML
    private void insertPlayer(){
        try {
            DAO.add("zawodnik", txtIdPlayer.getText(), txtTeamName.getText(), txtFirstName.getText(), txtLastName.getText(), txtPosition.getText(), txtAge.getText());
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idPlayerColumn.setCellValueFactory(new PropertyValueFactory<>("idPlayer"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        teamNameColumn.setCellValueFactory(new PropertyValueFactory<>("teamName"));
        ObservableList<Player> playerList;
        try {
            playerList = DAO.getAllPlayerRecords();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        playerTable.setItems(playerList);
    }

    public void switchToApp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
