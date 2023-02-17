package com.example.project_db1.Entities;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Sponsor {
    private final StringProperty sponsorName;
    private final StringProperty support;

    public StringProperty sponsorNameProperty() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName.set(sponsorName);
    }

    public StringProperty supportProperty() {
        return support;
    }

    public void setSupport(String support) {
        this.support.set(support);
    }

    public Sponsor(){
        this.sponsorName = new SimpleStringProperty();
        this.support = new SimpleStringProperty();
    }
}
