import java.util.Scanner;
public class Sentinel3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

//        System.out.print("Enter Your Grade: ");
//        int grade = input.nextInt();

        int count = 1;
        int pass = 0;
        int fail = 0;
        while (count <= 10) {
            System.out.print("Enter Your Grade: ");
            int grade = input.nextInt();

            if (grade == 1) {
                pass = pass + 1;
            }
            else {
                fail = fail + 1;
            }
            count =  count + 1;

        }
        System.out.println( pass);
        System.out.println(fail);
            if(pass > 8) {
                System.out.println("bonus to instructor is good");
            }
    }
    }