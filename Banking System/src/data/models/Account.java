package data.models;

public class Account {
    private final String nuban;
    private int balance;
    private final User owner;
    private final Bank bank;

    public Account(String nuban, User owner, Bank bank) {
        this.nuban = nuban;
        this.owner = owner;
        this.bank = bank;
    }

    public void deposit(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Invalid amount");
        balance += amount;
    }

    public void withdraw(int amount) {
        if (amount > balance) throw new IllegalArgumentException("Insufficient funds");
        balance -= amount;
    }

    public String getNuban() {
        return nuban;
    }

    public int getBalance() {
        return balance;
    }
    public Bank getBank() {
        return bank;
    }
}
