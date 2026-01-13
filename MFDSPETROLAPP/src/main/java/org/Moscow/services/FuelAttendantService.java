package org.Moscow.services;

import org.Moscow.data.models.Fuel;
import org.Moscow.data.models.Transaction;

import java.util.List;

public interface FuelAttendantService {
    void addFuel(Fuel fuel);

    Fuel getFuel(String fuelName);

    void updatePrice(String fuelName, double newPrice);

    void restockFuel(String fuelName, double quantity);

    boolean dispenseByLiters(String fuelName, double liters);

    boolean dispenseByAmount(String fuelName, double amount);

    List<Transaction> getAllTransactions();
}
