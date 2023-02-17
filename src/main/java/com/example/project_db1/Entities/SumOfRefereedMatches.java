package com.example.project_db1.Entities;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SumOfRefereedMatches {

    private final IntegerProperty sum;
    private final StringProperty firstName;
    private final StringProperty lastName;

    public IntegerProperty sumProperty() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum.set(sum);
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

    public SumOfRefereedMatches(){
        this.firstName = new SimpleStringProperty();
        this.lastName = new SimpleStringProperty();
        this.sum = new SimpleIntegerProperty();
    }
}
