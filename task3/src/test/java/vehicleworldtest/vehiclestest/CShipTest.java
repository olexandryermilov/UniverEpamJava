package vehicleworldtest.vehiclestest;

import org.junit.BeforeClass;
import org.junit.Test;
import vehiclesworld.Fabrics.CShipFabric;
import vehiclesworld.vehicles.CShip;
import vehiclesworld.vehicles.CVehicle;
import vehiclesworld.vehicles.Swimable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CShipTest{
    static CShip cShip;
    @BeforeClass
    public static void initialize(){
        cShip = CShipFabric.getNewCShip();
    }
    @Test
    public void swim_ReturnsSpeed(){
        assertEquals(cShip.getSpeed(),cShip.swim());
    }
    @Test
    public void speed_goodRange(){
        assertTrue(cShip.getSpeed()>=300&&cShip.getSpeed()<=600);
    }
    @Test
    public void cost_goodRange(){
        assertTrue(cShip.getCost()>=1000000&&cShip.getCost()<=2000000);
    }
    @Test
    public void year_goodRange(){
        assertTrue(cShip.getYear()>=2007&&cShip.getYear()<=2017);
    }
    @Test
    public void passengers_goodRange(){
        assertTrue(cShip.getPassengers()>=250&&cShip.getPassengers()<=350);
    }
}
