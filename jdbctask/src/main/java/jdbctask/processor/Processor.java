package jdbctask.processor;

import jdbctask.data.Railway;
import jdbctask.data.Station;
import jdbctask.exceptions.WrongArgumentException;
import jdbctask.exceptions.WrongCommandException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/*
добавление нового объекта
 изменение параметров существующего объекта
 удаление объекта
 поиск объектов по заданным критериям и вывод информации об
объектах
 */
public class Processor {
    private final Connection connection;

    private PreparedStatement addRailwayStatement;
    private PreparedStatement addStationStatement;
    private PreparedStatement removeRailwayStatement;
    private PreparedStatement removeStationStatement;
    private final String helpMessage="Usage:\nexit to quit the app\nadd railway id name\n" +
            "add station id r_id stationname\nremove railway id\nremove station id\n"+
            "search railway [ID=id NAME=name]\nsearch station [ID=id R_ID=id STATIONNAME=stationname]";
    private void prepareStatements() throws SQLException {
        addRailwayStatement=connection.prepareStatement("INSERT INTO railway.railways VALUES (?,?)");
        addStationStatement=connection.prepareStatement("INSERT INTO railway.stations VALUES (?,?,?)");
        removeRailwayStatement=connection.prepareStatement("DELETE FROM railway.railways WHERE ID=?");
        removeStationStatement=connection.prepareStatement("DELETE FROM railway.stations WHERE ID=?");
    }
    public Processor(Connection connection) {
        this.connection = connection;
        try{
            prepareStatements();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int workWithCommand(String text) throws SQLException, WrongCommandException, WrongArgumentException {
        String[] arr = text.split(" ");
        if(arr.length==1){
            if (arr[0].equalsIgnoreCase("help")) {
                System.out.println(helpMessage);
                return 0;
            }
            if (arr[0].equalsIgnoreCase("exit")) {
                return -1;
            }
            else{
                throw new WrongCommandException();
            }
        }
        String withoutFirstWord=text.substring(arr[0].length()+1);
        if(arr[0].equalsIgnoreCase("add")){
            addObject(withoutFirstWord);
        }
        else {
            if (arr[0].equalsIgnoreCase("remove")) {
                removeObject(withoutFirstWord);

            } else if (arr[0].equalsIgnoreCase("search")) {
                searchObject(withoutFirstWord);
            } else {
                throw new WrongCommandException();
            }
        }
        return 0;

    }
    public void addObject(String text) throws SQLException, WrongArgumentException, WrongCommandException {
        String[] arr = text.split(" ");
        String withoutFirstWord=text.substring(arr[0].length()+1);
        if(arr[0].equalsIgnoreCase("railway")){
            addRailway(withoutFirstWord);
        }
        else{
            if(arr[0].equalsIgnoreCase("station")){
                addStation(withoutFirstWord);
            }
            else{
                throw new WrongArgumentException();
            }
        }
    }

    public void addRailway(String text) throws SQLException, WrongCommandException, WrongArgumentException {
        String[] arr = text.split(" ");
        if(arr.length!=2){
            throw new WrongCommandException();
        }
        int id = 1;
        try{
            id = Integer.parseInt(arr[0]);
        }
        catch (Exception e){
            throw new WrongArgumentException();
        }
        text=arr[1];
        addRailwayStatement.setInt(1,id);
        addRailwayStatement.setString(2,text);
        addRailwayStatement.executeUpdate();
    }
    public void addStation(String text) throws SQLException {
        String[] arr = text.split(" ");
        if(arr.length!=3){
            //throw
        }
        int id = 1,r_id=1;
        try{
            id = Integer.parseInt(arr[0]);
            r_id = Integer.parseInt(arr[1]);
        }
        catch (Exception e){
            //
        }
        text=arr[2];
        addStationStatement.setInt(1,id);
        addStationStatement.setInt(2,r_id);
        addStationStatement.setString(3,text);
        addStationStatement.executeUpdate();
    }
    public void removeObject(String text) throws SQLException, WrongArgumentException {
        String[] arr = text.split(" ");
        String withoutFirstWord=text.substring(arr[0].length()+1);
        if(arr[0].equalsIgnoreCase("railway")){
            removeRailway(withoutFirstWord);
        }
        else{
            if(arr[0].equalsIgnoreCase("station")){
                removeStation(withoutFirstWord);
            }
            else{
                throw new WrongArgumentException();
            }
        }
    }
    public void removeRailway(String text) throws SQLException, WrongArgumentException {
        String arr[] = text.split(" ");
        if(arr.length!=1){
            throw new WrongArgumentException();
        }
        int id = 1;
        try{
             id = Integer.parseInt(arr[0]);
        }
        catch (Exception e){
            throw new WrongArgumentException();
        }
        removeRailwayStatement.setInt(1,id);
        removeRailwayStatement.executeUpdate();
    }
    public void removeStation(String text) throws SQLException, WrongArgumentException {
        String arr[] = text.split(" ");
        if(arr.length!=1){
            throw new WrongArgumentException();
        }
        int id = 1;
        try{
            id = Integer.parseInt(arr[0]);
        }
        catch (Exception e){
            throw new WrongArgumentException();
        }
        removeStationStatement.setInt(1,id);
        removeStationStatement.executeUpdate();
    }
    public void searchObject(String text) throws SQLException, WrongArgumentException {
        String[] arr = text.split(" ");
        String withoutFirstWord=text.substring(arr[0].length()+1);
        if(arr[0].equalsIgnoreCase("railway")){
            System.out.println(searchRailway(withoutFirstWord));
        }
        else{
            if(arr[0].equalsIgnoreCase("station")){
                System.out.println(searchStation(withoutFirstWord));
            }
            else{
                throw new WrongArgumentException();
            }
        }
    }
    public ArrayList<Railway> searchRailway(String text) throws SQLException, WrongArgumentException {
        StringBuilder statement = new StringBuilder();
        statement.append("SELECT * FROM railway.railways");
        if (text.length() != 0) {
            statement.append(" WHERE ");
        }
        else{
            throw new WrongArgumentException();
        }
        String[] arr = text.split(" ");
        if (arr[0].startsWith("ID")) {
            int id = 1;
            try {
                id = Integer.parseInt(arr[0].replaceAll("ID", "").substring(1));
            } catch (Exception e) {
                throw new WrongArgumentException();
            }
            statement.append(arr[0]);
        }
        String name = null;
        if (arr[0].startsWith("NAME=")) {
            name = arr[0];
        } else {
            if (arr.length > 1) {
                if (arr[1].startsWith("NAME=")) {
                    name=arr[1];
                }
                else{
                    throw new WrongArgumentException();
                }
            }
        }
        if(name!=null){
            if(!statement.toString().endsWith("WHERE "))statement.append(" AND ");
            statement.append(name);
        }
        System.out.println(statement);
        ResultSet rs=connection.prepareStatement(statement.toString()).executeQuery();
        ArrayList<Railway> queryAnswer = new ArrayList<>();
        while(rs.next()){
            int entityId =  rs.getInt(1);
            String entityName = rs.getString(2);
            queryAnswer.add(new Railway(entityId,entityName));
        }
        return queryAnswer;
    }
    public ArrayList<Station> searchStation(String text) throws SQLException, WrongArgumentException {
        StringBuilder statement = new StringBuilder();
        statement.append("SELECT * FROM railway.stations");
        if (text.length() != 0) {
            statement.append(" WHERE ");
        }
        else{
            throw new WrongArgumentException();
        }
        String[] arr = text.split(" ");
        String id = null;
        if (arr[0].startsWith("ID")) {
            id = arr[0];
        }
        if(id!=null)statement.append(id);
        String r_id = null;
        if (arr[0].startsWith("R_ID")) {
            r_id= arr[0];
        } else {
            if (arr.length > 1) {
                if (arr[1].startsWith("R_ID")) {
                    r_id=arr[1];
                }
            }
        }
        if(r_id!=null){
            if(!statement.toString().endsWith("WHERE "))statement.append(" AND ");
            statement.append(r_id);
        }
        String name = null;
        if (arr[0].startsWith("STATIONNAME=")) {
            name = arr[0];
        } else {
            if (arr.length > 1) {
                if (arr[1].startsWith("STATIONNAME=")) {
                    name=arr[1];
                }
                else{
                    if(arr.length>2){
                        if(arr[2].startsWith("STATIONNAME=")){
                            name=arr[2];
                        }
                    }
                    else
                    {
                        throw new WrongArgumentException();
                    }
                }
            }
        }
        if(name!=null){
            if(!statement.toString().endsWith("WHERE "))statement.append(" AND ");
            statement.append(name);
        }
        System.out.println(statement);
        ResultSet rs=connection.prepareStatement(statement.toString()).executeQuery();
        ArrayList<Station> queryAnswer = new ArrayList<>();
        while(rs.next()){
            int entityId =  rs.getInt(1);
            int entityRID = rs.getInt(2);
            String entityName = rs.getString(3);
            queryAnswer.add(new Station(entityId,entityRID,entityName));
        }
        return queryAnswer;
    }
}
