package jdbctask.processor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private final String url = "jdbc:mysql://localhost:3306/railway?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static Connection connection;
    private final String user="root";

    public DatabaseConnector() throws IOException, SQLException {
        if(connection ==null)connection= DriverManager.getConnection(url,user,
                new BufferedReader(new FileReader("pass.txt")).readLine());
    }
    public Connection getConnection() {
        return connection;
    }
}
