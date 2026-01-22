package data.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void userHasBvnOnCreation() {
        User user = new User("Moses", "moses@email.com");
        assertNotNull(user.getBvn());
        assertEquals(11, user.getBvn().length());
    }

    @Test
    void linkAccountDoesNotThrowException() {
        User user = new User("Moses", "moses@email.com");
        Bank bank = new Bank("Zenith", "057");
        Account account = bank.createAccount(user);

        assertDoesNotThrow(() -> user.linkAccount(account));
    }
}
