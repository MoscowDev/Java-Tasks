import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number;

        while (true) {
            System.out.print("Enter a five-digit integer: ");
            number = input.nextInt();

            // Check if number is five digits
            if (number >= 10000 && number <= 99999) {
                break;
            } else {
                System.out.println("Error: Number must be exactly five digits.");
            }
        }


        int digit1 = number / 10000;
        int digit2 = (number / 1000) % 10;
        int digit4 = (number / 10) % 10;
        int digit5 = number % 10;

        if (digit1 == digit5 && digit2 == digit4) {
            System.out.println(number + " is a palindrome.");
        } else {
            System.out.println(number + " is not a palindrome.");
        }

        input.close();
    }
}
