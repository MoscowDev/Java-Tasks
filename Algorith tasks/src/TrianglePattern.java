public class TrianglePattern{

    public static void main(String[] args) {

        for (int row = 1; row <= 5; row++) {


            for (int col = 1; col <= row; col++) {
                System.out.print('*');
            }
            for (int space = row; space < 5; space++) {
                System.out.print(' ');
            }

            System.out.print(' ');


            for (int col = 5; col >= row; col--) {
                System.out.print('*');
            }
            for (int space = 1; space < row; space++) {
                System.out.print(' ');
            }

            System.out.print(' ');

            for (int space = 5; space > row; space--) {
                System.out.print(' ');
            }
            for (int col = 1; col <= row; col++) {
                System.out.print('*');
            }

            System.out.print(' ');


            for (int space = 1; space < row; space++) {
                System.out.print(' ');
            }
            for (int col = 5; col >= row; col--) {
                System.out.print('*');
            }

            System.out.println();
        }
    }
}
