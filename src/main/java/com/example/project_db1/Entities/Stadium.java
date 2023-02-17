package com.example.project_db1.Entities;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Stadium {
    private final StringProperty stadiumName;
    private final StringProperty city;
    private final IntegerProperty capacity;

    public StringProperty stadiumNameProperty() {
        return stadiumName;
    }

    public void setNazwa_stadionu(String stadiumName) {
        this.stadiumName.set(stadiumName);
    }

    public StringProperty cityProperty() {
        return city;
    }

    public void setMiasto(String city) {
        this.city.set(city);
    }

    public IntegerProperty capacityProperty() {
        return capacity;
    }

    public void setPojemnosc(int capacity) {
        this.capacity.set(capacity);
    }

    public Stadium(){
        this.stadiumName = new SimpleStringProperty();
        this.capacity = new SimpleIntegerProperty();
        this.city = new SimpleStringProperty();
    }
}
