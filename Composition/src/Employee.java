public class Employee {
    private static int count = 0;



    private String firstName;
    private String lastName;
    private Date hireDate;
    private Date birthDate;

    public Employee(String firstName, String lastName, Date hireDate, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hireDate = hireDate;
        this.birthDate = birthDate;
        count++;

    }

    public static int getCount() {
        return count;
    }

    public void sumUp(int count) {
        return birthDate * count;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String toString() {
        return firstName + " " + lastName + " Birthed on " + hireDate + " Hired on " + birthDate;
    }
}
