package vehicleworldtest.vehiclestest;

import org.junit.BeforeClass;
import org.junit.Test;
import vehiclesworld.Fabrics.BatmobileFabric;
import vehiclesworld.vehicles.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BatmobileTest {
    static Batmobile batMobile;
    @BeforeClass
    public static void initialize(){
        batMobile = BatmobileFabric.getNewBatmobile();
    }
    @Test
    public void move_ReturnsSpeed(){
        assertEquals(batMobile.getSpeed(),batMobile.move());
    }
    @Test
    public void swim_ReturnsSpeed(){
        assertEquals(batMobile.getSpeed(),batMobile.swim());
    }
    @Test
    public void fly_ReturnsSpeed(){
        assertEquals(batMobile.getSpeed(),batMobile.fly());
    }
    @Test
    public void speed_goodRange(){
        assertTrue(batMobile.getSpeed()>=250&&batMobile.getSpeed()<=350);
    }
    @Test
    public void cost_goodRange(){
        assertTrue(batMobile.getCost()>=90000&&batMobile.getCost()<=100000);
    }
    @Test
    public void year_goodRange(){
        assertTrue(batMobile.getYear()>=2012&&batMobile.getYear()<=2017);
    }
}
