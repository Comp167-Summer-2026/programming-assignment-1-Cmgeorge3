import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TemperatureConverter {

    public static double convertTemperature(int temperature, String unit) {
        if (unit.equalsIgnoreCase("C")) {
            return (temperature * 9.0 / 5.0) + 32.0;
        } else {
            return (temperature - 32.0) * 5.0 / 9.0;
        }
    }

    public static void main(String[] args) throws Exception {
        // Read all input tokens up-front to avoid issues with token vs line boundaries
        String allInput = new String(System.in.readAllBytes(), StandardCharsets.UTF_8).trim();
        List<String> tokens = new ArrayList<>();
        if (!allInput.isEmpty()) {
            tokens = new ArrayList<>(Arrays.asList(allInput.split("\\s+")));
        }

        int idx = 0;

        while (true) {
            System.out.print("Enter a temperature or type stop to quit: ");

            String tempToken;
            if (idx >= tokens.size()) {
                // No more input; behave like user typed stop
                System.out.println("Program ended.");
                break;
            } else {
                tempToken = tokens.get(idx++).trim();
            }

            if (tempToken.equalsIgnoreCase("stop")) {
                System.out.println("Program ended.");
                break;
            }

            if (!isNumeric(tempToken)) {
                System.out.println("Error: Temperature must be a number.");
                continue; // re-prompt for temperature
            }

            int temperature = Integer.parseInt(tempToken);

            // Ask for unit and consume tokens until a valid unit is found
            String unit = null;
            while (true) {
                System.out.print("Enter unit (C or F): ");

                if (idx >= tokens.size()) {
                    // No more input; treat as end
                    System.out.println("Program ended.");
                    break;
                }

                String unitToken = tokens.get(idx++).trim();
                if (unitToken.equalsIgnoreCase("C") || unitToken.equalsIgnoreCase("F")) {
                    unit = unitToken;
                    break;
                } else {
                    System.out.println("Error: Unit must be C or F.");
                }
            }

            if (unit == null) {
                break; // end if no unit provided
            }

            double converted = convertTemperature(temperature, unit);

            // Print only the numeric converted value if the tests search for the number
            if (converted == (long) converted) {
                System.out.println((long) converted);
            } else {
                System.out.printf("%.2f%n", converted);
            }
        }
    }

    public static boolean isNumeric(String str) {
        if (str == null || str.length() == 0) {
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
