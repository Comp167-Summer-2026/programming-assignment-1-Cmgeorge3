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

        while (true) {

            System.out.print("Enter a temperature or type stop to quit: ");
            String input = scnr.nextLine().trim();

            if (input.equalsIgnoreCase("stop")) {
                System.out.println("Program ended.");
                break;
            }

            if (!isNumeric(input)) {
                System.out.println("Error: Temperature must be a number.");
                continue; // re-prompt for temperature
            }

            int temperature = Integer.parseInt(input);

            // Keep asking for unit until it's valid (do NOT go back to asking for temperature)
            String unit;
            while (true) {
                System.out.print("Enter unit (C or F): ");
                String unitInput = scnr.nextLine().trim();
                if (unitInput.equalsIgnoreCase("C") || unitInput.equalsIgnoreCase("F")) {
                    unit = unitInput;
                    break;
                } else {
                    System.out.println("Error: Unit must be C or F.");
                }
            }

            double converted = convertTemperature(temperature, unit);

            if (unit.equalsIgnoreCase("C")) {
                System.out.printf("%d\u00B0C is equal to %.2f\u00B0F%n", temperature, converted);
            } else {
                System.out.printf("%d\u00B0F is equal to %.2f\u00B0C%n", temperature, converted);
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
