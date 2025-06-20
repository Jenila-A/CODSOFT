import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {

    // Sample exchange rates (base: USD)
    static HashMap<String, Double> exchangeRates = new HashMap<>();

    static {
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("INR", 83.12);
        exchangeRates.put("EUR", 0.92);
        exchangeRates.put("GBP", 0.78);
        exchangeRates.put("JPY", 157.45);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("💱 Welcome to the Currency Converter!");
        System.out.println("Available currencies: USD, INR, EUR, GBP, JPY");

        // Input base currency
        System.out.print("Enter base currency (e.g., USD): ");
        String base = scanner.next().toUpperCase();

        // Input target currency
        System.out.print("Enter target currency (e.g., INR): ");
        String target = scanner.next().toUpperCase();

        // Input amount
        System.out.print("Enter amount in " + base + ": ");
        double amount = scanner.nextDouble();

        // Check if both currencies are supported
        if (!exchangeRates.containsKey(base) || !exchangeRates.containsKey(target)) {
            System.out.println("❌ One or both currencies are not supported.");
        } else {
            // Convert amount
            double usdAmount = amount / exchangeRates.get(base); // convert to USD first
            double convertedAmount = usdAmount * exchangeRates.get(target);
            System.out.printf("✅ %.2f %s = %.2f %s%n", amount, base, convertedAmount, target);
        }

        scanner.close();
    }
}
