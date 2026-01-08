public class PopulationGrowth {
    public static void main(String[] args) {

        double currentPopulation = 8_000_000_000.0;
        double growthRate = 0.01;

        double initialPopulation = currentPopulation;
        double doublePopulation = initialPopulation * 2;
        int doubleYear = -1;

        System.out.printf("%-5s %-20s %-20s%n",
                "Year", "Population", "Increase");

        for (int year = 1; year <= 75; year++) {

            double increase = currentPopulation * growthRate;
            currentPopulation += increase;

            System.out.printf("%-5d %-20.0f %-20.0f%n",
                    year, currentPopulation, increase);

            if (doubleYear == -1 && currentPopulation >= doublePopulation) {
                doubleYear = year;
            }
        }

        if (doubleYear != -1) {
            System.out.println("\nPopulation doubles in year: " + doubleYear);
        } else {
            System.out.println("\nPopulation does not double within 75 years.");
        }
    }
}
