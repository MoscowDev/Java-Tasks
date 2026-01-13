package org.Moscow.services;

import org.Moscow.data.models.Fuel;
import org.Moscow.data.models.Transaction;

import java.util.List;

public class FuelAttendantServiceImpl implements FuelAttendantService {

    private final DispenserService dispenserService;
    private final TransactionService transactionService;

    public FuelAttendantServiceImpl(DispenserService dispenserService,
                                    TransactionService transactionService) {
        this.dispenserService = dispenserService;
        this.transactionService = transactionService;
    }

    @Override
    public void addFuel(Fuel fuel) {
        dispenserService.addFuel(fuel);
        transactionService.recordTransaction(
                new Transaction(fuel.getFuelName(), 0.0, 0.0, "AddFuel")
        );
    }

    @Override
    public Fuel getFuel(String fuelName) {
        return dispenserService.getFuel(fuelName);
    }

    @Override
    public void updatePrice(String fuelName, double newPrice) {
        Fuel fuel = dispenserService.getFuel(fuelName);
        if (fuel != null) {
            fuel.setPricePerLiter(newPrice);
            transactionService.recordTransaction(
                    new Transaction(fuelName, 0.0, newPrice, "PriceUpdate")
            );
        }
    }

    @Override
    public void restockFuel(String fuelName, double quantity) {
        Fuel fuel = dispenserService.getFuel(fuelName);
        if (fuel != null) {
            fuel.setQuantity(fuel.getQuantity() + quantity);
            transactionService.recordTransaction(
                    new Transaction(fuelName, quantity, 0.0, "Restock")
            );
        }
    }

    @Override
    public boolean dispenseByLiters(String fuelName, double liters) {
        Fuel fuel = dispenserService.getFuel(fuelName);
        if (fuel != null && fuel.getQuantity() >= liters) {
            fuel.setQuantity(fuel.getQuantity() - liters);
            double amountSpent = liters * fuel.getPricePerLiter();
            transactionService.recordTransaction(
                    new Transaction(fuelName, liters, amountSpent, "DispenseLiters")
            );
            return true;
        }
        return false;
    }

    @Override
    public boolean dispenseByAmount(String fuelName, double amount) {
        Fuel fuel = dispenserService.getFuel(fuelName);
        if (fuel != null) {
            double liters = amount / fuel.getPricePerLiter();
            if (fuel.getQuantity() >= liters) {
                fuel.setQuantity(fuel.getQuantity() - liters);
                transactionService.recordTransaction(
                        new Transaction(fuelName, liters, amount, "DispenseAmount")
                );
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }
}
