package com.example.project_db1.Entities;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class MatchReferee {
    private final IntegerProperty idMatch;
    private final IntegerProperty idReferee;

    public IntegerProperty idMatchProperty() {
        return idMatch;
    }

    public void setIdMatch(int idMatch) {
        this.idMatch.set(idMatch);
    }

    public IntegerProperty idRefereeProperty() {
        return idReferee;
    }

    public void setIdReferee(int idReferee) {
        this.idReferee.set(idReferee);
    }

    public MatchReferee() {
        this.idMatch = new SimpleIntegerProperty();
        this.idReferee = new SimpleIntegerProperty();
    }
}
