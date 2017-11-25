package vehicleworldtest.vehiclestest;

import org.junit.BeforeClass;
import org.junit.Test;
import vehiclesworld.Fabrics.CPlaneFabric;
import vehiclesworld.vehicles.CPlane;
import vehiclesworld.vehicles.CVehicle;
import vehiclesworld.vehicles.Flyable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CPlaneTest {
    static CPlane cPlane;
    @BeforeClass
    public static void initialize(){
        cPlane = CPlaneFabric.getNewCPlane();
    }
    @Test
    public void fly_ReturnsSpeed(){
        assertEquals(cPlane.getSpeed(),cPlane.fly());
    }

    @Test
    public void speed_goodRange(){
        assertTrue(cPlane.getSpeed()>=600&&cPlane.getSpeed()<=900);
    }
    @Test
    public void cost_goodRange(){
        assertTrue(cPlane.getCost()>=1000000&&cPlane.getCost()<=2000000);
    }
    @Test
    public void year_goodRange(){
        assertTrue(cPlane.getYear()>=2007&&cPlane.getYear()<=2017);
    }
    @Test
    public void passengers_goodRange(){
        assertTrue(cPlane.getPassengers()>=150&&cPlane.getPassengers()<=250);
    }
    @Test
    public void height_goodRange(){
        assertTrue(cPlane.getHeight()>=7000&&cPlane.getHeight()<=11000);
    }
}
