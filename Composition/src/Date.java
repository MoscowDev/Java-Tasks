import java.text.DateFormat;

public class Date {
    private int day;
    private int month;
    private int year;

    private static final int[] daysPerMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


    public Date(int day, int month, int year) {
        if (month > 12 || month < 1) {
            throw new IllegalArgumentException("Invalid month");
        }
        if (day <= 0 || day > daysPerMonth[month - 1] && !(month == 2 && day == 29)) {
            throw new IllegalArgumentException("Invalid month");
        }

        if(month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0 || (year % 400 == 0 && year % 100 != 0)))) {
            throw new IllegalArgumentException("Invalid month");
        }
        this.day = day;
        this.month = month;
        this.year = year;

        System.out.println(this.day + " " + this.month + " " + this.year);




    }
    public String toString() {
        return day + " " + month + " " + year;
    }


}
