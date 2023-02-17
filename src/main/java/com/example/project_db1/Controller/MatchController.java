package com.example.project_db1.Controller;

import com.example.project_db1.DAO;
import com.example.project_db1.Entities.Match;
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

public class MatchController implements Initializable {
    @FXML
    private TextField txtStadiumName;
    @FXML
    private TextField txtIdMatch;
    @FXML
    private TextField txtScore;
    @FXML
    private TextField txtDate;
    @FXML
    private TextField txtHostsTeam;
    @FXML
    private TextField txtAwayTeam;

    @FXML
    private TableColumn<Match, Integer> stadiumNameColumn;
    @FXML
    private TableColumn<Match, Integer> idMatchColumn;
    @FXML
    private TableColumn<Match, String> scoreColumn;
    @FXML
    private TableColumn<Match, String> dateColumn;
    @FXML
    private TableColumn<Match, String> hostsTeamColumn;
    @FXML
    private TableColumn<Match, String> awayTeamColumn;

    @FXML
    private TableView<Match> matchTable;

    @FXML
    private void insertMecz(){
        try {
            DAO.add("match", txtIdMatch.getText(), txtScore.getText(), txtDate.getText(), txtStadiumName.getText(), txtHostsTeam.getText(), txtAwayTeam.getText());
            System.out.println("Udalo sie");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        stadiumNameColumn.setCellValueFactory(new PropertyValueFactory<>("stadiumName"));
        idMatchColumn.setCellValueFactory(new PropertyValueFactory<>("idMatch"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        hostsTeamColumn.setCellValueFactory(new PropertyValueFactory<>("hostsTeam"));
        awayTeamColumn.setCellValueFactory(new PropertyValueFactory<>("awayTeam"));
        ObservableList<Match> meczList;
        try {
            meczList = DAO.getAllMatchRecords();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        matchTable.setItems(meczList);
    }

    public void switchToApp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
