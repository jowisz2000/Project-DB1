package com.example.project_db1.Entities;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SumOfGoals {
    private final IntegerProperty sum;
    private final StringProperty teamName;

    public IntegerProperty sumProperty() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum.set(sum);
    }

    public StringProperty teamNameProperty() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName.set(teamName);
    }

    public SumOfGoals(){
        this.sum = new SimpleIntegerProperty();
        this.teamName = new SimpleStringProperty();
    }
}
