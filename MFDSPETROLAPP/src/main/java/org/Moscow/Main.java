package org.Moscow;

import org.Moscow.data.models.Fuel;
import org.Moscow.data.models.Transaction;
import org.Moscow.services.DispenserServiceImpl;
import org.Moscow.services.FuelAttendantServiceImpl;
import org.Moscow.services.TransactionServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DispenserServiceImpl dispenserService = new DispenserServiceImpl();
        TransactionServiceImpl transactionService = new TransactionServiceImpl();

        FuelAttendantServiceImpl attendantService =
                new FuelAttendantServiceImpl(dispenserService, transactionService);

        attendantService.addFuel(new Fuel("Petrol", 650.0, 100.0));
        attendantService.addFuel(new Fuel("Diesel", 850.0, 100.0));
        attendantService.addFuel(new Fuel("Gasoline", 100.0, 200.0));
        attendantService.addFuel(new Fuel("Kerosene", 200.0, 300.0));

        Scanner scanner = new Scanner(System.in);
        boolean continueApp = true;

        while (continueApp) {
            System.out.println("\nAvailable Fuels:");
            dispenserService.getAllFuels().forEach(f ->
                    System.out.println(f.getFuelName() + " - ₦" +
                            f.getPricePerLiter() + " per liter, " +
                            f.getQuantity() + " liters available")
            );

            System.out.print("Choose fuel type: ");
            String fuelType = scanner.nextLine().trim();

            Fuel selectedFuel = dispenserService.getFuel(fuelType);
            if (selectedFuel == null) {
                System.out.println("Fuel not available. Try again.");
                continue;
            }

            System.out.print("Do you want to enter (1) Liters or (2) Amount? ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {
                System.out.print("Enter liters to buy (1–50): ");
                double liters = Double.parseDouble(scanner.nextLine());

                if (liters < 1 || liters > 50) {
                    System.out.println("Invalid liters.");
                    continue;
                }

                if (attendantService.dispenseByLiters(fuelType, liters)) {
                    double totalCost = liters * selectedFuel.getPricePerLiter();
                    System.out.println("Purchase successful! Cost: ₦" + totalCost);
                } else {
                    System.out.println("Not enough fuel available.");
                }

            } else if (choice.equals("2")) {
                System.out.print("Enter amount (₦): ");
                double amount = Double.parseDouble(scanner.nextLine());

                if (amount < selectedFuel.getPricePerLiter()) {
                    System.out.println("Amount too low.");
                    continue;
                }

                if (attendantService.dispenseByAmount(fuelType, amount)) {
                    double liters = amount / selectedFuel.getPricePerLiter();
                    System.out.println("Purchase successful! Liters: " + liters);
                } else {
                    System.out.println("Not enough fuel available.");
                }

            } else {
                System.out.println("Invalid choice.");
                continue;
            }

            System.out.print("Do you want to buy more fuel? (yes/no): ");
            continueApp = scanner.nextLine().trim().equalsIgnoreCase("yes");
        }

        System.out.println("\n--- Transactions ---");
        List<Transaction> transactions = attendantService.getAllTransactions();
        if (transactions.isEmpty()) {
            System.out.println("No transactions recorded.");
        } else {
            transactions.forEach(t ->
                    System.out.println(
                            t.getType() +
                                    " | Fuel: " + t.getFuelName() +
                                    " | Liters: " + t.getLitersDispensed() +
                                    " | Amount: ₦" + t.getAmountSpent()
                    )
            );
        }

        scanner.close();
    }
}
