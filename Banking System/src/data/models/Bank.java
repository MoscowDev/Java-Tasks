package data.models;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final String name;
    private final String bankCode;
    private int serialCounter = 1;
    private final List<Account> accounts = new ArrayList<>();

    public Bank(String name, String bankCode) {
        this.name = name;
        this.bankCode = bankCode;
    }

    public Account createAccount(User user) {
        String serial = String.format("%09d", serialCounter++);
        int checkDigit = calculateCheckDigit(bankCode, serial);
        String nuban = serial + checkDigit;

        Account account = new Account(nuban, user, this);
        accounts.add(account);
        user.linkAccount(account);

        return account;
    }

    public void intraBankTransfer(
            String fromNuban,
            String toNuban,
            int amount
    ) {
        if (fromNuban.equals(toNuban)) {
            throw new IllegalArgumentException("Cannot transfer to same account");
        }

        Account sender = findAccount(fromNuban);
        Account receiver = findAccount(toNuban);

        sender.withdraw(amount);
        receiver.deposit(amount);
    }

    private int calculateCheckDigit(String bankCode, String serial) {
        int[] weights = {3,7,3,3,7,3,3,7,3,3,7,3};
        String combined = bankCode + serial;

        int sum = 0;
        for (int i = 0; i < combined.length(); i++) {
            int digit = Character.getNumericValue(combined.charAt(i));
            sum += digit * weights[i];
        }

        int mod = sum % 10;
        int digit = 10 - mod;
        return digit == 10 ? 0 : digit;
    }

    public Account findAccount(String nuban) {
        return accounts.stream()
                .filter(a -> a.getNuban().equals(nuban))
                .findFirst()
                .orElseThrow();
    }
}
