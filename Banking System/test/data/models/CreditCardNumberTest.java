package data.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardNumberTest {

    private CreditCardNumber card;
    private Account account;
    private Bank bank;

    @BeforeEach
    void setUp() {
        bank = new Bank("GTBank", "058");
        User user = new User("Chris", "chris@email.com");
        account = bank.createAccount(user);
        account.deposit(1000);
        card = new CreditCardNumber(account);
    }

    @Test
    void payReducesAccountBalance() {
        card.pay(400);
        assertEquals(600, account.getBalance());
    }

    @Test
    void payMoreThanBalanceThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> card.pay(2000));
    }
}
