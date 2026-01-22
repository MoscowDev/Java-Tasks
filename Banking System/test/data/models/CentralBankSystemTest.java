package data.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CentralBankSystemTest {

    private Bank bankA;
    private Bank bankB;
    private Account sender;
    private Account receiver;

    @BeforeEach
    void setUp() {
        bankA = new Bank("Bank A", "111");
        bankB = new Bank("Bank B", "222");

        User user1 = new User("Moses", "moses@email.com");
        User user2 = new User("Ada", "ada@email.com");

        sender = bankA.createAccount(user1);
        receiver = bankB.createAccount(user2);

        sender.deposit(1000);
    }

    @Test
    void interBankTransferMovesMoneyBetweenDifferentBanks() {
        CentralBankSystem.interBankTransfer(sender, receiver, 400);

        assertEquals(600, sender.getBalance());
        assertEquals(400, receiver.getBalance());
    }

    @Test
    void interBankTransferBetweenSameBankThrowsException() {
        Account sameBankReceiver = bankA.createAccount(
                new User("John", "john@email.com")
        );

        assertThrows(IllegalArgumentException.class, () ->
                CentralBankSystem.interBankTransfer(
                        sender,
                        sameBankReceiver,
                        200
                )
        );
    }

    @Test
    void interBankTransferWithInsufficientFundsThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                CentralBankSystem.interBankTransfer(
                        sender,
                        receiver,
                        5000
                )
        );
    }
}
