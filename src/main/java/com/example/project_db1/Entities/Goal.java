package com.example.project_db1.Entities;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Goal {

    private final IntegerProperty idGoal;
    private final IntegerProperty idPlayer;
    private final IntegerProperty idMatch;
    private final IntegerProperty minute;

    public IntegerProperty idGoalProperty() {
        return idGoal;
    }

    public void setIdGoal(int idGoal) {
        this.idGoal.set(idGoal);
    }

    public IntegerProperty idPlayerProperty() {
        return idPlayer;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer.set(idPlayer);
    }

    public IntegerProperty idMatchProperty() {
        return idMatch;
    }

    public void setIdMatch(int idMatch) {
        this.idMatch.set(idMatch);
    }

    public IntegerProperty minuteProperty() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute.set(minute);
    }

    public Goal(){
        this.idGoal = new SimpleIntegerProperty();
        this.idMatch = new SimpleIntegerProperty();
        this.idPlayer = new SimpleIntegerProperty();
        this.minute = new SimpleIntegerProperty();
    }
}
