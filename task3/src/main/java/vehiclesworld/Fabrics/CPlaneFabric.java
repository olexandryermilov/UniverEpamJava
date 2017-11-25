package vehiclesworld.Fabrics;

import vehiclesworld.MyRandom;
import vehiclesworld.vehicles.Batmobile;
import vehiclesworld.vehicles.CPlane;
import vehiclesworld.vehicles.CVehicle;
import vehiclesworld.vehicles.Flyable;

public class CPlaneFabric {
    private final static MyRandom random = MyRandom.getInstance();
    public static CPlane getNewCPlane(){
        return new CPlane(2000000-random.
                nextInt(1000000),900-random.nextInt(300),
                2017-random.nextInt(10),250-random.nextInt(100),
                11000-random.nextInt(4000));
    }
}
