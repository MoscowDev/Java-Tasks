public class ForLoop {
    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {
               for (int j = 1; j <= 10; j++) {
                      for (int k = 1; k <= 4-i; k++) {
                             System.out.print('*');
                          }

                      System.out.println();
                   }

               System.out.println();
             }

        double investmentAmount = 1000.0;
        double annualInterest = 0.05;
        double amount = investmentAmount;
        System.out.printf("%s%20s%n", "Year", "Amount on deposit");
        for(int year = 1; year <= 10; ++year) {

             amount = amount * (1.0 + annualInterest  );
            //double amount = investmentAmount * Math.pow(1.0 + annualInterest, year);
            System.out.printf("%4d%,20.2f%n", year, amount);

        }

    }
}
