package jdbctasktests.processor;

import jdbctask.data.Railway;
import jdbctask.data.Station;
import jdbctask.exceptions.WrongArgumentException;
import jdbctask.exceptions.WrongCommandException;
import jdbctask.processor.DatabaseConnector;
import jdbctask.processor.Processor;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ProcessorTest {
    private static Processor processor;
    private static Connection connection;
    @BeforeClass
    public static void prepare() throws IOException, SQLException {
        connection=new DatabaseConnector().getConnection();
        processor=new Processor(connection);
    }
    @Test
    public void addToRailway() throws SQLException, WrongCommandException, WrongArgumentException {
        processor.removeRailway("1000000");
        processor.workWithCommand("add railway 1000000 railway");
        ArrayList<Railway>rightAnswer = new ArrayList<>();
        rightAnswer.add(new Railway(1000000,"railway"));
        assertEquals(rightAnswer,processor.searchRailway("ID=1000000 NAME='railway'"));

    }
    @Test
    public void addToStation() throws SQLException, WrongCommandException, WrongArgumentException {
        processor.removeStation("1000000");
        processor.workWithCommand("add station 1000000 4 station");
        ArrayList<Station>rightAnswer = new ArrayList<>();
        rightAnswer.add(new Station(1000000,4,"station"));
        assertEquals(rightAnswer,processor.searchStation("ID=1000000 STATIONNAME='station'"));
    }
    @Test
    public void exit() throws SQLException, WrongCommandException, WrongArgumentException {
        assertEquals(-1,processor.workWithCommand("exit"));
    }
    @Test(expected = WrongCommandException.class)
    public void worksWithWrongCommandException() throws SQLException, WrongCommandException, WrongArgumentException {
        processor.workWithCommand("hell");
    }
    @Test(expected = WrongArgumentException.class)
    public void worksWithWrongArgumentException() throws SQLException, WrongCommandException, WrongArgumentException {
        processor.workWithCommand("search railway ID=fsdfsdf");
    }
    @Test(expected = WrongArgumentException.class)
    public void worksWithAddWrongArgumentException() throws SQLException, WrongCommandException, WrongArgumentException {
        processor.workWithCommand("add railway fsdfsdf fadfs");
    }
    @Test(expected = WrongArgumentException.class)
    public void worksWithRemoveWrongArgumentException() throws SQLException, WrongCommandException, WrongArgumentException {
        processor.workWithCommand("remove station fdsds");
    }
    @Test(expected = WrongArgumentException.class)
    public void worksWithRemoveRailwayWrongArgumentException() throws SQLException, WrongCommandException, WrongArgumentException {
        processor.workWithCommand("remove railway fdsds");
    }

}
