package data.models;

public class CentralBankSystem {


    public static void interBankTransfer(Account sender, Account receiver, int amount) {

        if (sender.getBank().equals(receiver.getBank())) {
            throw new IllegalArgumentException(
                    "Use intra-bank transfer for same bank accounts"
            );
        }
        sender.withdraw(amount);
        receiver.deposit(amount);
    }
}
