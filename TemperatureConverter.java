//Christopher George
//6/6/2026
//Comp 167-02
//Mp1 degree temp converter

import java.util.Scanner;

public class TemperatureConverter {

    public static double convertTemperature(double temperature, String unit) {
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
//user prompts
            System.out.print("Enter a temperature or type stop to quit: ");
            input = scnr.next();

            if (input.equalsIgnoreCase("stop")) {
                System.out.println("Program ended.");
            }//error handling
            else if (!isNumeric(input)) {
                System.out.println("Error: Temperature must be a number.");
            }
            else {
                double temperature = Double.parseDouble(input);

                System.out.print("Enter unit (C or F): ");
                String unit = scnr.next();

                if (!unit.equalsIgnoreCase("C") &&
                        !unit.equalsIgnoreCase("F")) {

                    System.out.println("Error: Unit must be C or F.");
                }
                else {

                    double converted =
                            convertTemperature(temperature, unit);
//output conversion if things go well(C or F dependent)
                    if (unit.equalsIgnoreCase("C")) {
                        System.out.printf("%.2f°C is equal to  %.2f°F%n",
                                temperature,
                                converted);
                    }
                    else {
                        System.out.printf("%.2f°F is equal to  %.2f°C%n",
                                temperature,
                                converted);
                    }
                }
            }
        }
    }

    public static boolean isNumeric(String str) {
        int start = 0;

        if (str.length() == 0) {
            return false;
        }

        if (str.charAt(0) == '-') {
            start = 1;
        }
//
        boolean decimalFound = false;

        for (int i = start; i < str.length(); i++) {

            if (str.charAt(i) == '.') {
                if (decimalFound) {
                    return false;
                }
                decimalFound = true;
            }
            else if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}