package org.Moscow.services;

import org.Moscow.data.models.Fuel;

import java.util.Collection;

public interface DispenserService {
    void addFuel(Fuel fuel);

    Fuel getFuel(String fuelName);

    Collection<Fuel> getAllFuels();

}


