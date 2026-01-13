package org.Moscow.data.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Getter
public class Dispenser {

    private final Map<String, Fuel> fuels = new HashMap<>();


    public void addFuel(Fuel fuel) {
        if (fuel == null || fuel.getFuelName() == null) {
            return;
        }
        fuels.put(normalize(fuel.getFuelName()), fuel);
    }


    public Fuel getFuel(String fuelName) {
        if (fuelName == null) {
            return null;
        }
        return fuels.get(normalize(fuelName));
    }


    public Collection<Fuel> getAllFuels() {
        return new ArrayList<>(fuels.values());
    }


    private String normalize(String name) {
        return name.trim().toLowerCase();
    }
}
