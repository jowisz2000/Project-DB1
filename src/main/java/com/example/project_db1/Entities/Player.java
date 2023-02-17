package com.example.project_db1.Entities;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Player {

    private final IntegerProperty idPlayer;
    private final StringProperty teamName;
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final IntegerProperty age;
    private final StringProperty position;

    public IntegerProperty idPlayerProperty() {
        return idPlayer;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer.set(idPlayer);
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

    public IntegerProperty ageProperty() {
        return age;
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public StringProperty positionProperty() {
        return position;
    }

    public void setPosition(String position) {
        this.position.set(position);
    }

    public Player(){
        this.teamName = new SimpleStringProperty();
        this.idPlayer = new SimpleIntegerProperty();
        this.firstName = new SimpleStringProperty();
        this.lastName= new SimpleStringProperty();
        this.age = new SimpleIntegerProperty();
        this.position = new SimpleStringProperty();
    }
}
