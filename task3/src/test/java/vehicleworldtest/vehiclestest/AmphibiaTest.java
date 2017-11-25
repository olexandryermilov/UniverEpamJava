package vehicleworldtest.vehiclestest;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import vehiclesworld.Fabrics.AmphibiaFabric;
import vehiclesworld.MyRandom;
import vehiclesworld.vehicles.Amphibia;
import vehiclesworld.vehicles.CVehicle;
import vehiclesworld.vehicles.Moveable;
import vehiclesworld.vehicles.Swimable;

import java.util.Date;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AmphibiaTest {
    static Amphibia amphibia;
    @BeforeClass
    public static void initialize(){
        amphibia = AmphibiaFabric.getNewAmphibia();
    }
    @Test
    public void move_ReturnsSpeed(){
        assertEquals(amphibia.getSpeed(),amphibia.move());
    }
    @Test
    public void swim_ReturnsSpeed(){
        assertEquals(amphibia.getSpeed(),amphibia.swim());
    }
    @Test
    public void speed_goodRange(){
        assertTrue(amphibia.getSpeed()>=200&&amphibia.getSpeed()<=300);
    }
    @Test
    public void cost_goodRange(){
        assertTrue(amphibia.getCost()>=60000&&amphibia.getCost()<=80000);
    }
    @Test
    public void year_goodRange(){
        assertTrue(amphibia.getYear()>=2007&&amphibia.getYear()<=2017);
    }

}
