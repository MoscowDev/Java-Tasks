package org.Moscow.data.models;

import java.time.LocalDateTime;

public class Transaction {

    private final String fuelName;
    private final double litersDispensed;
    private final double amountSpent;
    private final LocalDateTime timestamp;
    private final String type;

    public Transaction(String fuelName, double litersDispensed, double amountSpent, String type) {
        this.fuelName = fuelName;
        this.litersDispensed = litersDispensed;
        this.amountSpent = amountSpent;
        this.type = type;
        this.timestamp = LocalDateTime.now();
    }

    public String getFuelName() {
        return fuelName;
    }

    public double getLitersDispensed() {
        return litersDispensed;
    }

    public double getAmountSpent() {
        return amountSpent;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        switch (type) {
            case "DispenseLiters":
                return String.format("[%s] Dispensed %.2f liters of %s", timestamp, litersDispensed, fuelName);
            case "DispenseAmount":
                return String.format("[%s] Dispensed %.2f liters of %s for ₦%.2f", timestamp, litersDispensed, fuelName, amountSpent);
            case "Restock":
                return String.format("[%s] Restocked %.2f liters of %s", timestamp, litersDispensed, fuelName);
            case "PriceUpdate":
                return String.format("[%s] Updated price of %s to ₦%.2f", timestamp, fuelName, amountSpent);
            case "AddFuel":
                return String.format("[%s] Added new fuel: %s", timestamp, fuelName);
            default:
                return String.format("[%s] Transaction on %s", timestamp, fuelName);
        }
    }
}
