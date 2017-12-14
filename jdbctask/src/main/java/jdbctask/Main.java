package jdbctask;

import jdbctask.processor.DatabaseConnector;
import jdbctask.processor.Processor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection con=new DatabaseConnector().getConnection();
            Scanner in = new Scanner(System.in);
            Processor processor = new Processor(con);
            while(true){
                String line = in.nextLine();
                int response =processor.workWithCommand(line);
                if(response==-1)break;

            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
