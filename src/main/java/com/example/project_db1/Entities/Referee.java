package com.example.project_db1.Entities;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Referee {
    private final IntegerProperty idReferee;
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final IntegerProperty age;

    public IntegerProperty idRefereeProperty() {
        return idReferee;
    }

    public void setIdReferee(int idReferee) {
        this.idReferee.set(idReferee);
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

    public Referee() {
        this.idReferee = new SimpleIntegerProperty();
        this.firstName = new SimpleStringProperty();
        this.lastName = new SimpleStringProperty();
        this.age = new SimpleIntegerProperty();
    }


}
