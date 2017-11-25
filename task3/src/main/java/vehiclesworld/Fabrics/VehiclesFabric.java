package vehiclesworld.Fabrics;

import vehiclesworld.MyRandom;
import vehiclesworld.vehicles.*;

public class VehiclesFabric {
    private final static MyRandom random = MyRandom.getInstance();
    public static CVehicle nextCVehicle(){
        int x = Math.abs(random.nextInt(5));
        switch(x){
            case 0: return CCarFabric.getNewCCar();
            case 1: return CPlaneFabric.getNewCPlane();
            case 2: return CShipFabric.getNewCShip();
            case 3: return BatmobileFabric.getNewBatmobile();
            case 4: return AmphibiaFabric.getNewAmphibia();
            default:return null;
        }
    }
}
