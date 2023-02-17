package com.example.project_db1.Entities;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SponsorTeam {
    private final StringProperty sponsorName;
    private final StringProperty teamName;
    private final IntegerProperty fee;

    public StringProperty sponsorNameProperty() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName.set(sponsorName);
    }

    public StringProperty teamNameProperty() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName.set(teamName);
    }

    public IntegerProperty feeProperty() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee.set(fee);
    }

    public SponsorTeam(){
        this.sponsorName = new SimpleStringProperty();
        this.teamName = new SimpleStringProperty();
        this.fee = new SimpleIntegerProperty();
    }
}
