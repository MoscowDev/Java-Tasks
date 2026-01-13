package org.Moscow.services;

import org.Moscow.data.models.Fuel;
import org.Moscow.data.models.Transaction;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FuelAttendantServiceImplTest {

    @Test
    void testAddFuelRecordsTransaction() {
        DispenserService dispenser = new DispenserServiceImpl();
        TransactionService transactions = new TransactionServiceImpl();
        FuelAttendantServiceImpl attendant =
                new FuelAttendantServiceImpl(dispenser, transactions);

        Fuel fuel = new Fuel("Petrol", 650.0, 100.0);
        attendant.addFuel(fuel);

        Fuel retrieved = dispenser.getFuel("Petrol");
        assertNotNull(retrieved);
        assertEquals("Petrol", retrieved.getFuelName());

        List<Transaction> logs = attendant.getAllTransactions();
        assertEquals(1, logs.size());
        assertEquals("AddFuel", logs.get(0).getType());
        assertEquals("Petrol", logs.get(0).getFuelName());
        assertEquals(0, logs.get(0).getLitersDispensed());
        assertEquals(0, logs.get(0).getAmountSpent());
    }

    @Test
    void testUpdatePriceRecordsTransaction() {
        DispenserService dispenser = new DispenserServiceImpl();
        TransactionService transactions = new TransactionServiceImpl();
        FuelAttendantServiceImpl attendant =
                new FuelAttendantServiceImpl(dispenser, transactions);

        Fuel fuel = new Fuel("Diesel", 800.0, 200.0);
        attendant.addFuel(fuel);

        attendant.updatePrice("Diesel", 850.0);
        assertEquals(850.0, dispenser.getFuel("Diesel").getPricePerLiter());

        List<Transaction> logs = attendant.getAllTransactions();
        assertEquals(2, logs.size());
        Transaction priceUpdate = logs.get(1);
        assertEquals("PriceUpdate", priceUpdate.getType());
        assertEquals("Diesel", priceUpdate.getFuelName());
        assertEquals(0, priceUpdate.getLitersDispensed());
        assertEquals(850.0, priceUpdate.getAmountSpent());
    }

    @Test
    void testRestockFuelRecordsTransaction() {
        DispenserService dispenser = new DispenserServiceImpl();
        TransactionService transactions = new TransactionServiceImpl();
        FuelAttendantServiceImpl attendant =
                new FuelAttendantServiceImpl(dispenser, transactions);

        Fuel fuel = new Fuel("Petrol", 650.0, 50.0);
        attendant.addFuel(fuel);

        attendant.restockFuel("Petrol", 30.0);
        assertEquals(80.0, dispenser.getFuel("Petrol").getQuantity());

        List<Transaction> logs = attendant.getAllTransactions();
        assertEquals(2, logs.size());
        Transaction restock = logs.get(1);
        assertEquals("Restock", restock.getType());
        assertEquals("Petrol", restock.getFuelName());
        assertEquals(30.0, restock.getLitersDispensed());
        assertEquals(0, restock.getAmountSpent());
    }

    @Test
    void testDispenseByLiters() {
        DispenserService dispenser = new DispenserServiceImpl();
        TransactionService transactions = new TransactionServiceImpl();
        FuelAttendantServiceImpl attendant = new FuelAttendantServiceImpl(dispenser, transactions);

        Fuel fuel = new Fuel("Diesel", 850.0, 100.0);
        attendant.addFuel(fuel);

        boolean result = attendant.dispenseByLiters("Diesel", 40.0);
        assertTrue(result);
        assertEquals(60.0, dispenser.getFuel("Diesel").getQuantity());

        List<Transaction> logs = attendant.getAllTransactions();
        Transaction dispense = logs.get(1);
        assertEquals("DispenseLiters", dispense.getType());
        assertEquals("Diesel", dispense.getFuelName());
        assertEquals(40.0, dispense.getLitersDispensed());
        assertEquals(34000.0, dispense.getAmountSpent());
    }

    @Test
    void testDispenseByAmount() {
        DispenserService dispenser = new DispenserServiceImpl();
        TransactionService transactions = new TransactionServiceImpl();
        FuelAttendantServiceImpl attendant = new FuelAttendantServiceImpl(dispenser, transactions);

        Fuel fuel = new Fuel("Petrol", 650.0, 100.0);
        attendant.addFuel(fuel);

        boolean result = attendant.dispenseByAmount("Petrol", 1300.0);
        assertTrue(result);
        assertEquals(98.0, dispenser.getFuel("Petrol").getQuantity());

        List<Transaction> logs = attendant.getAllTransactions();
        Transaction dispenseAmount = logs.get(1);
        assertEquals("DispenseAmount", dispenseAmount.getType());
        assertEquals("Petrol", dispenseAmount.getFuelName());
        assertEquals(2.0, dispenseAmount.getLitersDispensed());
        assertEquals(1300.0, dispenseAmount.getAmountSpent());
    }

    @Test
    void testDispenseFailsIfNotEnoughFuel() {
        DispenserService dispenser = new DispenserServiceImpl();
        TransactionService transactions = new TransactionServiceImpl();
        FuelAttendantServiceImpl attendant = new FuelAttendantServiceImpl(dispenser, transactions);

        Fuel fuel = new Fuel("Diesel", 850.0, 10.0);
        attendant.addFuel(fuel);

        boolean result = attendant.dispenseByLiters("Diesel", 20.0);
        assertFalse(result);
        assertEquals(10.0, dispenser.getFuel("Diesel").getQuantity());
    }
}
