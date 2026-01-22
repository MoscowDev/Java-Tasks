package data.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    private Account account;
    private User user;
    private Bank bank;

    @BeforeEach
    void setUp() {
        user = new User("Moses", "moses@email.com");
        bank = new Bank("Test Bank", "123");
        account = bank.createAccount(user);
    }

    @Test
    void depositIncreasesBalance() {
        account.deposit(500);
        assertEquals(500, account.getBalance());
    }

    @Test
    void depositWithInvalidAmountThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0));
    }

    @Test
    void withdrawReducesBalance() {
        account.deposit(1000);
        account.withdraw(400);
        assertEquals(600, account.getBalance());
    }

    @Test
    void withdrawMoreThanBalanceThrowsException() {
        account.deposit(200);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(500));
    }

    @Test
    void getNubanReturnsCorrectValue() {
        assertNotNull(account.getNuban());
        assertEquals(10, account.getNuban().length());
    }
}
