module com.example.project_bd1 {
    requires transitive javafx.controls;
    requires transitive javafx.graphics;
    requires transitive javafx.fxml;
    requires transitive java.sql;
    requires transitive java.sql.rowset;
    requires transitive org.postgresql.jdbc;


    opens com.example.project_db1.Controller to javafx.fxml;
    opens com.example.project_db1.Entities to javafx.fxml;
    exports com.example.project_db1;
    exports com.example.project_db1.Entities;
    opens com.example.project_db1 to javafx.fxml;
}