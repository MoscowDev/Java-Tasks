import org.Moscow.data.models.Fuel;
import org.Moscow.services.FuelServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FuelServiceTest {

    @Test
    void testInitialFuelDetails() {
        Fuel fuel = new Fuel("Diesel", 650.0, 100.0);
        FuelServiceImpl service = new FuelServiceImpl(fuel);

        assertEquals("Diesel", service.getFuelName());
        assertEquals(650.0, service.getPricePerLiter());
        assertEquals(100.0, service.getQuantity());
    }

    @Test
    void testUpdatePricePerLiter() {
        Fuel fuel = new Fuel("Petrol", 650.0, 100.0);
        FuelServiceImpl service = new FuelServiceImpl(fuel);

        service.setPricePerLiter(700.0);

        assertEquals(700.0, service.getPricePerLiter());
    }

    @Test
    void testRestockFuel() {
        Fuel fuel = new Fuel("Petrol", 650.0, 100.0);
        FuelServiceImpl service = new FuelServiceImpl(fuel);

        service.restock(50.0);

        assertEquals(150.0, service.getQuantity());
    }

    @Test
    void testDispenseFuelSuccess() {
        Fuel fuel = new Fuel("Petrol", 650.0, 100.0);
        FuelServiceImpl service = new FuelServiceImpl(fuel);

        boolean result = service.dispense(30.0);

        assertTrue(result);
        assertEquals(70.0, service.getQuantity());
    }

    @Test
    void testDispenseFuelFailure() {
        Fuel fuel = new Fuel("Petrol", 650.0, 20.0);
        FuelServiceImpl service = new FuelServiceImpl(fuel);

        boolean result = service.dispense(50.0);

        assertFalse(result);
        assertEquals(20.0, service.getQuantity());
    }
    @Test
    void testMultipleRestocks() {
        Fuel fuel = new Fuel("Petrol", 650.0, 100.0);
        FuelServiceImpl service = new FuelServiceImpl(fuel);

        service.restock(50.0);
        service.restock(25.0);

        assertEquals(175.0, fuel.getQuantity());
    }

    @Test
    void testDispenseExactQuantity() {

        Fuel fuel = new Fuel("Petrol", 650.0, 50.0);
        FuelServiceImpl service = new FuelServiceImpl(fuel);
        boolean result  = service.dispense(50.0);

        assertTrue(result);
        assertEquals(0.0, fuel.getQuantity());
    }

    @Test
    void testDispenseZeroLiters() {
        Fuel fuel = new Fuel("Petrol", 650.0, 0.0);
        FuelServiceImpl service = new FuelServiceImpl(fuel);

        boolean result = service.dispense(0.0);

        assertFalse(result);
        assertEquals(0.0, fuel.getQuantity());
    }

    @Test
    void testDispenseNegativeLiters() {
        Fuel fuel = new Fuel("Petrol", 650.0, 100.0);
        FuelServiceImpl service = new FuelServiceImpl(fuel);

        boolean result = service.dispense(-10.0);

        assertFalse(result);
        assertEquals(100.0, fuel.getQuantity());
    }

    @Test
    void testQuantityNeverNegative() {
        Fuel fuel = new Fuel("Petrol", 650.0, 10.0);
        FuelServiceImpl service = new FuelServiceImpl(fuel);

        service.dispense(20.0);

        assertTrue(fuel.getQuantity() >= 0);
    }





}
