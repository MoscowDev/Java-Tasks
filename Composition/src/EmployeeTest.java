public class EmployeeTest {
    public static void main(String[] args) {
        Date birth = new Date(11,4,1993);
        Date hire = new Date(3,5,2025);
        System.out.println("count "+ Employee.getCount());
        Employee employee = new Employee("Mike","red",birth,hire);
        Employee employee2 = new Employee("Mike","red",birth,hire);
        Employee employee3 = new Employee("Mike","red",birth,hire);
        System.out.println(employee.getCount());
        System.out.println(employee2.getCount());
        System.out.println(employee3.getCount());

        System.out.println(employee.getCount()+" " +employee.getFirstName());
        System.out.println(employee2.getCount()+" " +employee2.getLastName());
        System.out.println(employee3.getCount()+" " +employee3.getLastName());

        System.out.println(   Employee.getCount());
    }
}
