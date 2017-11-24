package vehiclesworld;

import vehiclesworld.vehicles.*;

import java.util.Date;
import java.util.Random;

public class VehiclesFabric {
    private final static Random random = new Random(new Date().getTime());
    public static CVehicle nextCVehicle(){
        int x = Math.abs(random.nextInt())%5;
        switch(x){
            case 0: return new CCar(20000-random.nextInt()%10000,250-random.nextInt()%100,2017-random.nextInt()%20);
            case 1: return new CPlane(2000000-random.nextInt()%1000000,900-random.nextInt()%300,
                    2017-random.nextInt()%10,250-random.nextInt()%100,11000-random.nextInt()%4000);
            case 2: return new CShip(2000000-random.nextInt()%1000000,600-random.nextInt()%300,
                    2017-random.nextInt()%10,350-random.nextInt()%100,"Odessa");
            case 3: return new Batmobile(100000-random.nextInt()%10000,350-random.nextInt()%100,2017-random.nextInt()%5);
            case 4: return new Amphibia(80000-random.nextInt()%20000,300-random.nextInt()%100,2017-random.nextInt()%10);
            default:return null;
        }
    }
}
