package com.example.project_db1.Entities;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Coach {
    private final IntegerProperty idCoach;
    private final StringProperty teamName;
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty role;


    public IntegerProperty idCoachProperty() {
        return idCoach;
    }

    public void setIdCoach(int idCoach) {
        this.idCoach.set(idCoach);
    }


    public StringProperty teamNameProperty() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName.set(teamName);
    }


    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }


    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }


    public StringProperty roleProperty() {
        return role;
    }

    public void setRole(String role) {
        this.role.set(role);
    }

    public Coach(){
        this.teamName = new SimpleStringProperty();
        this.idCoach = new SimpleIntegerProperty();
        this.firstName = new SimpleStringProperty();
        this.lastName = new SimpleStringProperty();
        this.role = new SimpleStringProperty();
    }
}
