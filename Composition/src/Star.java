import java.io.IO;

public class Star {
    public static void main(String[] args) {

        for (int i = 0; i< 5; i++) {
            //System.out.println("M");
            for (int j = 5; j > i; j--) {
                System.out.print("M");
            }

            System.out.println();
        }

        for (int i = 0; i< 5; i++) {
            for (int j = 1; j<=i; j++) {
                IO.print("M");

            }
            System.out.println();
        }


    }
}
