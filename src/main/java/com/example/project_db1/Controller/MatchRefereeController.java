package com.example.project_db1.Controller;

import com.example.project_db1.DAO;
import com.example.project_db1.Entities.MatchReferee;
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

public class MatchRefereeController implements Initializable {
    @FXML
    private TextField txtIdMatch;
    @FXML
    private TextField txtIdReferee;


    @FXML
    private TableColumn<MatchReferee, Integer> idRefereeColumn;
    @FXML
    private TableColumn<MatchReferee, Integer> idMatchColumn;

    @FXML
    private TableView<MatchReferee> matchRefereeTable;

    @FXML
    private void insertMatchReferee(){
        try {
            DAO.add("match_referee", txtIdMatch.getText(), txtIdReferee.getText());
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        idRefereeColumn.setCellValueFactory(new PropertyValueFactory<>("idReferee"));
        idMatchColumn.setCellValueFactory(new PropertyValueFactory<>("idMatch"));
        ObservableList<MatchReferee> matchRefereeList;
        try {
            matchRefereeList = DAO.getAllMatchRefereeRecords();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        matchRefereeTable.setItems(matchRefereeList);
    }

    public void switchToApp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
