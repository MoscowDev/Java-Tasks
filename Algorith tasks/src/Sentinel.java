import java.util.Scanner;
public class Sentinel {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);



        int count = 0;
        int sum = 0;

        System.out.print("Enter grade or -1 to stop: ");
        int grade = input.nextInt();

        while (grade != -1) {
            sum += grade;
            count++;

            System.out.print("Enter grade or -1 to stop: ");
            grade = input.nextInt();
        }
        if (count != 0) {


            double average = (double)sum / count;

            System.out.println("The average is: " + average);
            System.out.println("The sum is : " + sum);
        }
        else  {
            System.out.println("Grade not found");
        }




    }



}
