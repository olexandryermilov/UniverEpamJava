package vehiclesworld.Fabrics;

import vehiclesworld.MyRandom;
import vehiclesworld.vehicles.Batmobile;
import vehiclesworld.vehicles.CShip;
import vehiclesworld.vehicles.CVehicle;
import vehiclesworld.vehicles.Swimable;

public class CShipFabric{
    private final static MyRandom random = MyRandom.getInstance();
    public static CShip getNewCShip(){
        return new CShip(2000000-random.nextInt(1000000),600-random.nextInt(300),
                2017-random.nextInt(10),350-random.nextInt(100),"Odessa");
    }
}
