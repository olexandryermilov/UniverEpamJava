package vehicleworldtest.vehiclestest;

import org.junit.BeforeClass;
import org.junit.Test;
import vehiclesworld.Fabrics.CCarFabric;
import vehiclesworld.vehicles.CCar;
import vehiclesworld.vehicles.CVehicle;
import vehiclesworld.vehicles.Moveable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CCarTest{
    static CCar cCar;
    @BeforeClass
    public static void initialize(){
        cCar = CCarFabric.getNewCCar();
    }
    @Test
    public void move_ReturnsSpeed(){
        assertEquals(cCar.getSpeed(),cCar.move());
    }
    @Test
    public void speed_goodRange(){
        assertTrue(cCar.getSpeed()>=150&&cCar.getSpeed()<=250);
    }
    @Test
    public void cost_goodRange(){
        assertTrue(cCar.getCost()>=10000&&cCar.getCost()<=20000);
    }
    @Test
    public void year_goodRange(){
        assertTrue(cCar.getYear()>=1997&&cCar.getYear()<=2017);
    }
}
