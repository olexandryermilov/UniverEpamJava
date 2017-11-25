package vehiclesworld.Fabrics;

import vehiclesworld.MyRandom;
import vehiclesworld.vehicles.*;

public class BatmobileFabric  {
    private final static MyRandom random = MyRandom.getInstance();
    public static Batmobile getNewBatmobile(){
        return new Batmobile(100000-random.
                nextInt(10000),350-random.nextInt(100),2017-random.nextInt(5));
    }
}
