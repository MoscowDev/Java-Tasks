package org.Moscow.services;

import org.Moscow.data.models.Fuel;

public class FuelServiceImpl implements FuelService {

    private final Fuel fuel;

    public FuelServiceImpl(Fuel fuel) {
        this.fuel = fuel;
    }

    @Override
    public double restock(double stockQuantity) {
        fuel.setQuantity(fuel.getQuantity() + stockQuantity);
        return fuel.getQuantity();
    }

    @Override
    public double getQuantity() {
        return fuel.getQuantity();
    }

    @Override
    public String getFuelName() {
        return fuel.getFuelName();
    }

    @Override
    public double getPricePerLiter() {
        return fuel.getPricePerLiter();
    }

    @Override
    public boolean dispense(double liters) {

        if (liters <= 0) {
            return false;
        }
        if (fuel.getQuantity() >= liters) {
            fuel.setQuantity(fuel.getQuantity() - liters);
            return true;
        }
        return false;
    }

    @Override
    public void setPricePerLiter(double price) {
        fuel.setPricePerLiter(price);
    }
}
