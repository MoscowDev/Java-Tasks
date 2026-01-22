package data.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private final String name;
    private final String email;
    private final String bvn;
    private final List<Account> accounts = new ArrayList<>();

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.bvn = generateBVN();
    }

    private String generateBVN() {
        return UUID.randomUUID().toString().substring(0,11);
    }

    public String getBvn() {
        return bvn;
    }

    public void linkAccount(Account account) {
        accounts.add(account);
    }
}
