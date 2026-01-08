import java.util.Scanner;
public class MinMax {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

//        System.out.println("Please enter 10 numbers");
//        int num1 = input.nextInt();

        int [] fff = {10,21,3,4,5,6,50};
        int max = fff[0];
        int min = fff[0];
        int sum = 0;
        for (int i = 1; i < fff.length; i++) {
            if(fff[i] > max){
                max = fff[i];
            }
            if(fff[i]< min ){
                min = fff[i];

            }
             sum = min + max;

        }
        System.out.println("The maximum number is: " + max);
        System.out.println("The minimum number is: " + min);
        System.out.println("The sum is: " + sum);

    }
}
