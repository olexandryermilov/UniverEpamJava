package vehicleworldtest;

import org.junit.Before;
import org.junit.Test;
import vehiclesworld.VehiclesFabric;
import vehiclesworld.vehicles.CVehicle;

import static org.junit.Assert.assertTrue;

public class VehiclesFabricTest {
    @Test
    public void NextVehicle_GeneratesVehicle_NotNull(){
        assertTrue(VehiclesFabric.nextCVehicle() != null);
    }
}
