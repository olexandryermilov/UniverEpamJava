package vehicleworldtest;

import org.junit.Test;
import vehiclesworld.Fabrics.VehiclesFabric;

import static org.junit.Assert.assertTrue;

public class VehiclesFabricTest {
    @Test
    public void NextVehicle_GeneratesVehicle_NotNull(){
        assertTrue(VehiclesFabric.nextCVehicle() != null);
    }
}
