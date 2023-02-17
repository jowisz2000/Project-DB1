package com.example.project_db1.Controller;

import com.example.project_db1.DAO;
import com.example.project_db1.Entities.SumOfGoals;
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

public class SumOfGoalsController implements Initializable {
    @FXML
    private TableColumn<SumOfGoals, Integer> sumColumn;
    @FXML
    private TableColumn<SumOfGoals, String> teamNameColumn;
    @FXML
    private TableView<SumOfGoals> sumOfGoalsTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        sumColumn.setCellValueFactory(new PropertyValueFactory<>("sum"));
        teamNameColumn.setCellValueFactory(new PropertyValueFactory<>("teamName"));
        ObservableList<SumOfGoals> sumaDochodowList;
        try {
            sumaDochodowList = DAO.getAllSumOfGoalsRecords();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        sumOfGoalsTable.setItems(sumaDochodowList);
    }

    public void switchToApp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
