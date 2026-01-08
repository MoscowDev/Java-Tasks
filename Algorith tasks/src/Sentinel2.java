import java.util.Scanner;
public class Sentinel2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        int count = 1;
        int sum = 0;

        while(count <= 10) {
            System.out.print("Enter Your Grade: ");
            int grade = input.nextInt();
            count++;
            sum += grade;

        }
        int avg = sum/count;
        System.out.println("Grade Sum is " + sum);
        System.out.println("Grade Average is " + avg);


    }
}
