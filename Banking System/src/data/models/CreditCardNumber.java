package data.models;

import java.util.UUID;

public class CreditCardNumber {
    private final String cardNumber;
    private final Account account;

    public CreditCardNumber(Account account) {
        this.account = account;
        this.cardNumber = UUID.randomUUID().toString().replace("-", "").substring(0,16);
    }

    public void pay(int amount) {
        account.withdraw(amount);
    }
}
