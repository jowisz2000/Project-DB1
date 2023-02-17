package com.example.project_db1.Controller;

import com.example.project_db1.DAO;
import com.example.project_db1.Entities.SumOfRefereedMatches;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class sumOfRefereedMatchesController implements Initializable {
    @FXML
    private TableColumn<SumOfRefereedMatches, Integer> sumColumn;
    @FXML
    private TableColumn<SumOfRefereedMatches, String> firstNameColumn;
    @FXML
    private TableColumn<SumOfRefereedMatches, String> lastNameColumn;
    @FXML
    private TableView<SumOfRefereedMatches> sumOfRefereedMatchesTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sumColumn.setCellValueFactory(new PropertyValueFactory<>("sum"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        ObservableList<SumOfRefereedMatches> sumOfRefereedMatchesList;
        try {
            sumOfRefereedMatchesList = DAO.getAllSedziaSumaMeczowRecords();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        sumOfRefereedMatchesTable.setItems(sumOfRefereedMatchesList);
    }

    public void switchToApp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
