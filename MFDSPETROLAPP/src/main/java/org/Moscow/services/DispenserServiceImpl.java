package org.Moscow.services;

import org.Moscow.data.models.Dispenser;
import org.Moscow.data.models.Fuel;

import java.util.Collection;
public class DispenserServiceImpl implements DispenserService {

    private final Dispenser dispenser;


    public DispenserServiceImpl() {
        this.dispenser = new Dispenser();
    }

    public DispenserServiceImpl(Dispenser dispenser) {
        this.dispenser = dispenser;
    }

    @Override
    public void addFuel(Fuel fuel) {
        dispenser.addFuel(fuel);
    }

    @Override
    public Fuel getFuel(String fuelName) {
        return dispenser.getFuel(fuelName);
    }

    @Override
    public Collection<Fuel> getAllFuels() {
        return dispenser.getAllFuels();
    }
}
