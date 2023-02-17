package com.example.project_db1;
import com.example.project_db1.Entities.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

    public static void add(String tableName, String... properties) throws SQLException {
        StringBuilder query = new StringBuilder("insert into " + tableName + " values ('");
            for(var i: properties){
                query.append(i).append("', '");
            }
            query.deleteCharAt(query.length()-3);
            query.deleteCharAt(query.length()-1);
            query.append(");");
        try {
            DBUtil.executeQuery(String.valueOf(query));
        }
        catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Referee> getAllRefereeRecords() throws ClassNotFoundException, SQLException{
        String query = "select id_referee as \"idReferee\", first_name as \"firstName\", last_name as \"lastName\"," +
                " age from referee";
        ObservableList<Referee> list;
        try{
            ResultSet resultSet = DBUtil.getRecords(query);
            list = getRefereeObjects(resultSet);
            return list;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static ObservableList<Team> getAllTeamRecords() throws ClassNotFoundException, SQLException{
        String query = "select team_name as \"name\", foundation_year as\"foundationYear\" from team";
        ObservableList<Team> list;
        try{
            ResultSet resultSet = DBUtil.getRecords(query);
            list = getTeamObjects(resultSet);
            return list;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static ObservableList<Coach> getAllTrenerRecords() throws ClassNotFoundException, SQLException{
        String query = "select id_coach as \"idCoach\", first_name as \"firstName\", last_name as \"lastName\"," +
                " role, team_name as \"teamName\" from coach";
        ObservableList<Coach> list;
        try{
            ResultSet resultSet = DBUtil.getRecords(query);
            list = getTrenerObjects(resultSet);
            return list;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static ObservableList<Sponsor> getAllSponsorRecords() throws ClassNotFoundException, SQLException{
        String query = "select sponsor_name as \"sponsorName\", support from sponsor";
        ObservableList<Sponsor> list;
        try{
            ResultSet resultSet = DBUtil.getRecords(query);
            list = getSponsorObjects(resultSet);
            return list;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static ObservableList<Stadium> getAllStadiumRecords() throws ClassNotFoundException, SQLException{
        String query = "select stadium_name as \"stadiumName\", city, capacity from stadium";
        ObservableList<Stadium> list;
        try{
            ResultSet resultSet = DBUtil.getRecords(query);
            list = getStadiumObjects(resultSet);
            return list;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static ObservableList<Player> getAllPlayerRecords() throws ClassNotFoundException, SQLException{
        String query = "select id_player as \"idPlayer\", team_name as \"teamName\", first_name as \"firstName\"," +
                " last_name as \"lastName\", position, age from player";
        ObservableList<Player> list;
        try{
            ResultSet resultSet = DBUtil.getRecords(query);
            list = getPlayerObjects(resultSet);
            return list;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static ObservableList<Goal> getAllGoalRecords() throws ClassNotFoundException, SQLException{
        String query = "select id_goal as \"idGoal\", id_match as \"idMatch\", id_player as \"idPlayer\"," +
                " minute from goal";
        ObservableList<Goal> list;
        try{
            ResultSet resultSet = DBUtil.getRecords(query);
            list = getGoalObjects(resultSet);
            return list;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static ObservableList<Match> getAllMatchRecords() throws ClassNotFoundException, SQLException{
        String query = "select id_match as \"idMatch\", score, date, stadium_name as\"stadiumName\", hosts_team " +
                "as \"hostsTeam\", away_team as \"awayTeam\" from match";
        ObservableList<Match> list;
        try{
            ResultSet resultSet = DBUtil.getRecords(query);
            list = getMatchObjects(resultSet);
            return list;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static ObservableList<MatchReferee> getAllMatchRefereeRecords() throws ClassNotFoundException, SQLException{
        String query = "select id_match as \"idMatch\", id_referee as\"idReferee\" from match_referee";
        ObservableList<MatchReferee> list;
        try{
            ResultSet resultSet = DBUtil.getRecords(query);
            list = getMatchRefereeObjects(resultSet);
            return list;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static ObservableList<SponsorTeam> getAllSponsorTeamRecords() throws ClassNotFoundException, SQLException{
        String query = "select sponsor_name as \"sponsorName\", team_name as \"teamName\", fee from sponsor_team";
        ObservableList<SponsorTeam> list;
        try{
            ResultSet resultSet = DBUtil.getRecords(query);
            list = getSponsorTeamObjects(resultSet);
            return list;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static ObservableList<TotalIncome> getAllTotalIncomeRecords() throws ClassNotFoundException, SQLException{
        String query = "select sum, team_name as \"teamName\" from amount_of_fee;";
        ObservableList<TotalIncome> list;
        try{
            ResultSet resultSet = DBUtil.getRecords(query);
            list = getTotalIncomeObjects(resultSet);
            return list;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static ObservableList<SumOfGoals> getAllSumOfGoalsRecords() throws ClassNotFoundException, SQLException{
        String query = "select sum, team_name as \"teamName\" from sum_of_goals";
        ObservableList<SumOfGoals> list;
        try{
            ResultSet resultSet = DBUtil.getRecords(query);
            list = getSumOfGoalsObjects(resultSet);
            return list;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static ObservableList<SumOfRefereedMatches> getAllSedziaSumaMeczowRecords() throws ClassNotFoundException, SQLException{
        String query = "select first_name as \"firstName\", last_name as \"lastName\", sum from sum_of_refereed_matches";
        ObservableList<SumOfRefereedMatches> list;
        try{
            ResultSet resultSet = DBUtil.getRecords(query);
            list = getSumOfRefereedMatches(resultSet);
            return list;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    private static ObservableList<Referee> getRefereeObjects(ResultSet resultSet) throws SQLException{

        ObservableList<Referee> refereeList = null;
        try {
            refereeList = FXCollections.observableArrayList();
            while (resultSet.next()) {
                Referee referee = new Referee();
                referee.setIdReferee(resultSet.getInt("idReferee"));
                referee.setFirstName(resultSet.getString("firstName"));
                referee.setLastName(resultSet.getString("lastName"));
                referee.setAge(resultSet.getInt("age"));
                refereeList.add(referee);
            }
            return refereeList;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return refereeList;
    }

    private static ObservableList<Team> getTeamObjects(ResultSet resultSet) throws SQLException{

        ObservableList<Team> teamList = null;
        try {
            teamList = FXCollections.observableArrayList();
            while (resultSet.next()) {
                Team team= new Team();
                team.setName(resultSet.getString("name"));
                team.setFoundationYear(resultSet.getInt("foundationYear"));
                teamList.add(team);
            }
            return teamList;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return teamList;
    }

    private static ObservableList<Coach> getTrenerObjects(ResultSet resultSet) throws SQLException{

        ObservableList<Coach> coachList = null;
        try {
            coachList = FXCollections.observableArrayList();
            while (resultSet.next()) {
                Coach coach = new Coach();
                coach.setIdCoach(resultSet.getInt("idCoach"));
                coach.setTeamName(resultSet.getString("teamName"));
                coach.setFirstName(resultSet.getString("firstName"));
                coach.setLastName(resultSet.getString("lastName"));
                coach.setRole(resultSet.getString("role"));
                coachList.add(coach);
            }
            return coachList;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return coachList;
    }

    private static ObservableList<Sponsor> getSponsorObjects(ResultSet resultSet) throws SQLException{

        ObservableList<Sponsor> sponsorList = null;
        try {
            sponsorList = FXCollections.observableArrayList();
            while (resultSet.next()) {
                Sponsor sponsor = new Sponsor();
                sponsor.setSponsorName(resultSet.getString("sponsorName"));
                sponsor.setSupport(resultSet.getString("support"));
                sponsorList.add(sponsor);
            }
            return sponsorList;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return sponsorList;
    }

    private static ObservableList<Stadium> getStadiumObjects(ResultSet resultSet) throws SQLException{

        ObservableList<Stadium> stadiumList = null;
        try {
            stadiumList = FXCollections.observableArrayList();
            while (resultSet.next()) {
                Stadium stadion = new Stadium();
                stadion.setNazwa_stadionu(resultSet.getString("stadiumName"));
                stadion.setMiasto(resultSet.getString("city"));
                stadion.setPojemnosc(resultSet.getInt("capacity"));
                stadiumList.add(stadion);
            }
            return stadiumList;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return stadiumList;
    }

    private static ObservableList<Player> getPlayerObjects(ResultSet resultSet) throws SQLException{

        ObservableList<Player> playerList = null;
        try {
            playerList = FXCollections.observableArrayList();
            while (resultSet.next()) {
                Player zawodnik = new Player();
                zawodnik.setIdPlayer(resultSet.getInt("idPlayer"));
                zawodnik.setTeamName(resultSet.getString("teamName"));
                zawodnik.setAge(resultSet.getInt("age"));
                zawodnik.setFirstName(resultSet.getString("firstName"));
                zawodnik.setLastName(resultSet.getString("lastName"));
                zawodnik.setPosition(resultSet.getString("position"));
                playerList.add(zawodnik);
            }
            return playerList;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return playerList;
    }

    private static ObservableList<Goal> getGoalObjects(ResultSet resultSet) throws SQLException{

        ObservableList<Goal> goalList = null;
        try {
            goalList = FXCollections.observableArrayList();
            while (resultSet.next()) {
                Goal goal = new Goal();
                goal.setIdPlayer(resultSet.getInt("idPlayer"));
                goal.setIdMatch(resultSet.getInt("idMatch"));
                goal.setIdGoal(resultSet.getInt("idGoal"));
                goal.setMinute(resultSet.getInt("minute"));
                goalList.add(goal);
            }
            return goalList;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return goalList;
    }

    private static ObservableList<Match> getMatchObjects(ResultSet resultSet) throws SQLException{

        ObservableList<Match> matchList = null;
        try {
            matchList = FXCollections.observableArrayList();
            while (resultSet.next()) {
                Match match = new Match();
                match.setIdMatch(resultSet.getInt("idMatch"));
                match.setScore(resultSet.getString("score"));
                match.setDate(resultSet.getString("date"));
                match.setStadiumName(resultSet.getString("stadiumName"));
                match.setHostsTeam(resultSet.getString("hostsTeam"));
                match.setAwayTeam(resultSet.getString("awayTeam"));
                matchList.add(match);
            }
            return matchList;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return matchList;
    }

    private static ObservableList<MatchReferee> getMatchRefereeObjects(ResultSet resultSet) throws SQLException{

        ObservableList<MatchReferee> matchRefereeList = null;
        try {
            matchRefereeList = FXCollections.observableArrayList();
            while (resultSet.next()) {
                MatchReferee matchReferee = new MatchReferee();
                matchReferee.setIdMatch(resultSet.getInt("idMatch"));
                matchReferee.setIdReferee(resultSet.getInt("idReferee"));
                matchRefereeList.add(matchReferee);
            }
            return matchRefereeList;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return matchRefereeList;
    }

    private static ObservableList<SponsorTeam> getSponsorTeamObjects(ResultSet resultSet) throws SQLException{

        ObservableList<SponsorTeam> sponsorDruzynaList = null;
        try {
            sponsorDruzynaList = FXCollections.observableArrayList();
            while (resultSet.next()) {
                SponsorTeam sponsorDruzyna = new SponsorTeam();
                sponsorDruzyna.setSponsorName(resultSet.getString("sponsorName"));
                sponsorDruzyna.setFee(resultSet.getInt("fee"));
                sponsorDruzyna.setTeamName(resultSet.getString("teamName"));
                sponsorDruzynaList.add(sponsorDruzyna);
            }
            return sponsorDruzynaList;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return sponsorDruzynaList;
    }

    private static ObservableList<TotalIncome> getTotalIncomeObjects(ResultSet resultSet) throws SQLException{

        ObservableList<TotalIncome> amountOfFeeList = null;
        try {
            amountOfFeeList = FXCollections.observableArrayList();
            while (resultSet.next()) {
                TotalIncome amountOfFee = new TotalIncome();
                amountOfFee.setSum(resultSet.getInt("sum"));
                amountOfFee.setTeamName(resultSet.getString("teamName"));
                amountOfFeeList.add(amountOfFee);
            }
            return amountOfFeeList;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return amountOfFeeList;
    }

    private static ObservableList<SumOfGoals> getSumOfGoalsObjects(ResultSet resultSet) throws SQLException{

        ObservableList<SumOfGoals> sumOfGoalsList = null;
        try {
            sumOfGoalsList = FXCollections.observableArrayList();
            while (resultSet.next()) {
                SumOfGoals sumOfGoals = new SumOfGoals();
                sumOfGoals.setSum(resultSet.getInt("sum"));
                sumOfGoals.setTeamName(resultSet.getString("teamName"));
                sumOfGoalsList.add(sumOfGoals);
            }
            return sumOfGoalsList;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return sumOfGoalsList;
    }

    private static ObservableList<SumOfRefereedMatches> getSumOfRefereedMatches(ResultSet resultSet) throws SQLException{

        ObservableList<SumOfRefereedMatches> sumOfRefereedMatchesList = null;
        try {
            sumOfRefereedMatchesList = FXCollections.observableArrayList();
            while (resultSet.next()) {
                SumOfRefereedMatches sumOfRefereedMatches = new SumOfRefereedMatches();
                sumOfRefereedMatches.setSum(resultSet.getInt("sum"));
                sumOfRefereedMatches.setFirstName(resultSet.getString("firstName"));
                sumOfRefereedMatches.setLastName(resultSet.getString("lastName"));
                sumOfRefereedMatchesList.add(sumOfRefereedMatches);
            }
            return sumOfRefereedMatchesList;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return sumOfRefereedMatchesList;
    }

}