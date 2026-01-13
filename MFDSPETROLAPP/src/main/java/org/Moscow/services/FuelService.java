package org.Moscow.services;

public interface FuelService {

    public double restock(double quantity);

    double getQuantity();

    String getFuelName();

    double getPricePerLiter();

    boolean dispense(double liters);

    void setPricePerLiter(double price);
}
