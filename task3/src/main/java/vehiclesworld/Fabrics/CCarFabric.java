package vehiclesworld.Fabrics;

import vehiclesworld.MyRandom;
import vehiclesworld.vehicles.Batmobile;
import vehiclesworld.vehicles.CCar;
import vehiclesworld.vehicles.CVehicle;
import vehiclesworld.vehicles.Moveable;

public class CCarFabric{
    private final static MyRandom random = MyRandom.getInstance();
    public static CCar getNewCCar(){
        return new CCar(20000-random.
                nextInt(10000),250-random.nextInt(100),2017-random.nextInt(20));
    }
}
