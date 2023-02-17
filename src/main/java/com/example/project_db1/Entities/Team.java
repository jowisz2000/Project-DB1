package com.example.project_db1.Entities;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Team {

    private final IntegerProperty foundationYear;
    private final StringProperty name;

    public IntegerProperty foundationYearProperty() {
        return foundationYear;
    }

    public void setFoundationYear(int foundationYear) {
        this.foundationYear.set(foundationYear);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public Team(){
        this.foundationYear = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
    }
}
