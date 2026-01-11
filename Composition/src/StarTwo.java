import java.io.IO;

public class StarTwo {
    public static void main(String[] args) {

        int star = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();

            for (int j = 1; j <= i; j++) {
                System.out.print("");
                for (int k = 1; k <= j-10; k++) {
                    System.out.print("*");
                }
            }
        }

    }
}
