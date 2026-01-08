import java.util.Scanner;

public class MinMax2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter 10 numbers: ");
      int num1 = input.nextInt();


        int max = num1;
        int min = num1;
        int sum = 0;
        int sum2 = 0;
        for (int i = 1; i < 10; i++) {
             num1 = input.nextInt();
            if(num1 > max){
                max = num1;
            }
            if(num1< min ){
                min = num1;

            }
            if(num1 <= 30){
                sum2 += num1;
            }

            sum = min + max;

        }
        System.out.println(sum2);
        System.out.println("The maximum number is: " + max);
        System.out.println("The minimum number is: " + min);
        System.out.println("The sum is: " + sum);

    }

}
