package data.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String address;
    private String phoneNumber;
    private int userId;
    private List<BookBorrowed> bookBorrowed = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<BookBorrowed> getBookBorrowed() {
        return bookBorrowed;
    }

    public void setBookBorrowed(List<BookBorrowed> bookBorrowed) {
        this.bookBorrowed = bookBorrowed;
    }
}
