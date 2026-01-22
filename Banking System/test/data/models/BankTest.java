package data.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    private Bank bank;
    private User user1;
    private User user2;
    private Account account1;
    private Account account2;

    @BeforeEach
    void setUp() {
        bank = new Bank("Test Bank", "123");
        user1 = new User("Moses", "moses@email.com");
        user2 = new User("Ada", "ada@email.com");

        account1 = bank.createAccount(user1);
        account2 = bank.createAccount(user2);

        account1.deposit(1000);
    }

    @Test
    void createAccountGeneratesValidNuban() {
        assertNotNull(account1.getNuban());
        assertEquals(10, account1.getNuban().length());
    }

    @Test
    void createAccountLinksAccountSuccessfully() {
        assertDoesNotThrow(() ->
                bank.findAccount(account1.getNuban())
        );
    }

    @Test
    void findAccountWithInvalidNubanThrowsException() {
        assertThrows(RuntimeException.class, () ->
                bank.findAccount("0000000000")
        );
    }

    @Test
    void intraBankTransferMovesMoneyCorrectly() {
        bank.intraBankTransfer(
                account1.getNuban(),
                account2.getNuban(),
                400
        );

        assertEquals(600, account1.getBalance());
        assertEquals(400, account2.getBalance());
    }

    @Test
    void intraBankTransferWithSameAccountThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                bank.intraBankTransfer(
                        account1.getNuban(),
                        account1.getNuban(),
                        200
                )
        );
    }

    @Test
    void intraBankTransferWithInsufficientFundsThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                bank.intraBankTransfer(
                        account1.getNuban(),
                        account2.getNuban(),
                        5000
                )
        );
    }
}
