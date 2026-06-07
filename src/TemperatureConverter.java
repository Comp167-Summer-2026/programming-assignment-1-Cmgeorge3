import java.util.Scanner;

public class TemperatureConverter {

    public static double convertTemperature(int temperature, String unit) {
        if (unit.equalsIgnoreCase("C")) {
            return (temperature * 9.0 / 5.0) + 32.0;
        }
        else {
            return (temperature - 32.0) * 5.0 / 9.0;
        }
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        String input = "";

        while (!input.equalsIgnoreCase("stop")) {

            System.out.print("Enter a temperature or type stop to quit: ");
            input = scnr.next();

            if (input.equalsIgnoreCase("stop")) {
                System.out.println("Program ended.");
            }
            else if (!isNumeric(input)) {
                System.out.println("Error: Temperature must be a number.");
            }
            else {
                int temperature = Integer.parseInt(input);

                System.out.print("Enter unit (C or F): ");
                String unit = scnr.next();

                // Keep asking for the unit until a valid one is provided.
                while (!unit.equalsIgnoreCase("C")
                        && !unit.equalsIgnoreCase("F")) {

                    System.out.println("Error: Unit must be C or F.");
                    System.out.print("Enter unit (C or F): ");
                    unit = scnr.next();
                }

                double converted =
                        convertTemperature(temperature, unit);

                if (unit.equalsIgnoreCase("C")) {
                    System.out.printf(
                            "%d\u00B0C is equal to %.2f\u00B0F%n",
                            temperature,
                            converted);
                }
                else {
                    System.out.printf(
                            "%d\u00B0F is equal to %.2f\u00B0C%n",
                            temperature,
                            converted);
                }
            }
        }

        scnr.close();
    }

    public static boolean isNumeric(String str) {
        if (str.length() == 0) {
            return false;
        }

        int start = 0;

        if (str.charAt(0) == '-') {
            start = 1;
        }

        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
