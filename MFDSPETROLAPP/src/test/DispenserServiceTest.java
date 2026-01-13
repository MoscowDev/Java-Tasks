import org.Moscow.data.models.Dispenser;
import org.Moscow.data.models.Fuel;
import org.Moscow.services.DispenserService;
import org.Moscow.services.DispenserServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class DispenserServiceTest {

    @Test
    void testAddFuel() {
        DispenserServiceImpl service = new DispenserServiceImpl();

        Fuel fuel = new Fuel("Petrol", 650.0, 100.0);
        service.addFuel(fuel);

        assertNotNull(service.getFuel("Petrol"));
    }

    @Test
    void testGetFuelByName() {
        DispenserServiceImpl service = new DispenserServiceImpl();

        service.addFuel(new Fuel("Diesel", 850.0, 200.0));

        Fuel fuel = service.getFuel("Diesel");
        assertEquals("Diesel", fuel.getFuelName());
    }

    @Test
    void testGetAllFuels() {
        DispenserServiceImpl service = new DispenserServiceImpl();

        service.addFuel(new Fuel("Petrol", 650.0, 100.0));
        service.addFuel(new Fuel("Diesel", 850.0, 200.0));

        Collection<Fuel> fuels = service.getAllFuels();
        assertEquals(2, fuels.size());
    }

    @Test
    void testAddDuplicateFuelOverrides() {
        DispenserServiceImpl service = new DispenserServiceImpl();

        service.addFuel(new Fuel("Petrol", 650.0, 100.0));
        service.addFuel(new Fuel("Petrol", 700.0, 200.0));

        Fuel fuel = service.getFuel("Petrol");
        assertEquals(700.0, fuel.getPricePerLiter());
        assertEquals(200.0, fuel.getQuantity());
    }

    @Test
    void testGetNonExistingFuelReturnsNull() {
        DispenserServiceImpl service = new DispenserServiceImpl();

        Fuel fuel = service.getFuel("Gas");
        assertNull(fuel);
    }

    @Test
    void testFuelLookupIsCaseInsensitive() {
        DispenserServiceImpl service = new DispenserServiceImpl();

        service.addFuel(new Fuel("Petrol", 650.0, 100.0));

        assertNotNull(service.getFuel("petrol"));
        assertNotNull(service.getFuel("PETROL"));
    }
}
