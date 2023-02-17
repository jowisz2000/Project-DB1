package com.example.project_db1.Controller;

import com.example.project_db1.DAO;
import com.example.project_db1.Entities.Sponsor;
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

public class SponsorController implements Initializable {

    @FXML
    private TextField txtSupport;
    @FXML
    private TextField txtSponsorName;
    @FXML
    private  TableColumn<Sponsor, String> supportColumn;
    @FXML
    private TableColumn<Sponsor, String> sponsorNameColumn;

    @FXML
    private TableView<Sponsor> sponsorTable = new TableView<>();
    @FXML
    private void insertSponsor(){
        try {
            DAO.add("sponsor", txtSponsorName.getText(), txtSupport.getText());
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        sponsorNameColumn.setCellValueFactory(new PropertyValueFactory<>("sponsorName"));
        supportColumn.setCellValueFactory(new PropertyValueFactory<>("support"));
        ObservableList<Sponsor> sponsorList;
        try {
            sponsorList = DAO.getAllSponsorRecords();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        sponsorTable.setItems(sponsorList);
    }

    public void switchToApp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
