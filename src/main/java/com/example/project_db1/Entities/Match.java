package com.example.project_db1.Entities;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Match {

    private final IntegerProperty idMatch;
    private final StringProperty score;
    private final StringProperty date;
    private final StringProperty stadiumName;
    private final StringProperty hostsTeam;
    private final StringProperty awayTeam;

    public IntegerProperty idMatchProperty() {
        return idMatch;
    }

    public void setIdMatch(int idMatch) {
        this.idMatch.set(idMatch);
    }

    public StringProperty scoreProperty() {
        return score;
    }

    public void setScore(String score) {
        this.score.set(score);
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public StringProperty stadiumNameProperty() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName.set(stadiumName);
    }
    public StringProperty hostsTeamProperty() {
        return hostsTeam;
    }

    public void setHostsTeam(String hostsTeam) {
        this.hostsTeam.set(hostsTeam);
    }

    public StringProperty awayTeamProperty() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam.set(awayTeam);
    }

    public Match(){
        this.idMatch = new SimpleIntegerProperty();
        this.stadiumName = new SimpleStringProperty();
        this.date = new SimpleStringProperty();
        this.score = new SimpleStringProperty();
        this.awayTeam = new SimpleStringProperty();
        this.hostsTeam = new SimpleStringProperty();
    }
}
