package vehiclesworld.Fabrics;

import vehiclesworld.MyRandom;
import vehiclesworld.vehicles.Amphibia;
import vehiclesworld.vehicles.CVehicle;
import vehiclesworld.vehicles.Moveable;
import vehiclesworld.vehicles.Swimable;

import java.util.Random;

public class AmphibiaFabric {
    private final static MyRandom random = MyRandom.getInstance();
    public static Amphibia getNewAmphibia(){
        return new Amphibia(80000-random.nextInt(20000),300-random.nextInt(100),2017-random.nextInt(10));
    }

}
