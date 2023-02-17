package com.example.project_db1.Controller;

import com.example.project_db1.DAO;
import com.example.project_db1.Entities.SponsorTeam;
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

public class SponsorTeamController implements Initializable {
    @FXML
    private TextField txtTeamName;
    @FXML
    private TextField txtSponsorName;
    @FXML
    private TextField txtFee;
    @FXML
    private TableColumn<SponsorTeam, Integer> sponsorNameColumn;
    @FXML
    private  TableColumn<SponsorTeam, Integer> teamNameColumn;
    @FXML
    private TableColumn<SponsorTeam, Integer> feeColumn;

    @FXML
    private TableView<SponsorTeam> sponsorTeamTable = new TableView<>();
    @FXML
    private void insertSponsorTeam(){
        try {
            DAO.add("sponsor_team", txtSponsorName.getText(), txtTeamName.getText(), txtFee.getText());
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        sponsorNameColumn.setCellValueFactory(new PropertyValueFactory<>("sponsorName"));
        feeColumn.setCellValueFactory(new PropertyValueFactory<>("fee"));
        teamNameColumn.setCellValueFactory(new PropertyValueFactory<>("teamName"));
        ObservableList<SponsorTeam> sponsorTeamList;
        try {
            sponsorTeamList = DAO.getAllSponsorTeamRecords();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        sponsorTeamTable.setItems(sponsorTeamList);
    }

    public void switchToApp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
