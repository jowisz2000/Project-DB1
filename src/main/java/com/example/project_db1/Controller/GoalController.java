package com.example.project_db1.Controller;

import com.example.project_db1.DAO;
import com.example.project_db1.Entities.Goal;
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

public class GoalController implements Initializable {
    @FXML
    private TextField txtIdPlayer;
    @FXML
    private TextField txtIdMatch;
    @FXML
    private TextField txtIdGoal;
    @FXML
    private TextField txtMinute;

    @FXML
    private TableColumn<Goal, Integer> idPlayerColumn;
    @FXML
    private TableColumn<Goal, Integer> idMatchColumn;
    @FXML
    private TableColumn<Goal, Integer> idGoalColumn;
    @FXML
    private TableColumn<Goal, Integer> minuteColumn;
    @FXML
    private TableView<Goal> goalTable;

    @FXML
    private void insertGol(){
        try {
            DAO.add("goal", txtIdGoal.getText(), txtIdMatch.getText(), txtIdPlayer.getText(), txtMinute.getText());
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        idGoalColumn.setCellValueFactory(new PropertyValueFactory<>("idGoal"));
        idMatchColumn.setCellValueFactory(new PropertyValueFactory<>("idMatch"));
        idPlayerColumn.setCellValueFactory(new PropertyValueFactory<>("idPlayer"));
        minuteColumn.setCellValueFactory(new PropertyValueFactory<>("minute"));
        ObservableList<Goal> goalList;
        try {
            goalList = DAO.getAllGoalRecords();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        goalTable.setItems(goalList);
    }

    public void switchToApp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
