import java.util.ArrayList;

public class StockAnalyzer {

    // Method to calculate the average stock price
    public static float calculateAveragePrice(float[] prices) {
        float sum = 0;
        for (float price : prices) {  // Iterating through each element in the prices array
            sum += price;             // Adding each price to the sum
        }
        return sum / prices.length;   // Calculating and returning the average by dividing the sum by the number of prices
    }

    // Method to find the maximum stock price
    public static float findMaximumPrice(float[] prices) {
        float maxPrice = prices[0];     // Initialize maxPrice with the first element of the array
        for (float price : prices) {    // Iterate through each element in the prices array
            if (price > maxPrice) {     // Compare the current price with maxPrice
                maxPrice = price;       // If the current price is greater, update maxPrice
            }
        }
        return maxPrice;                // Return the maximum price found
    }

    // Method to count the occurrences of a specific price
    public static int countOccurrences(float[] prices, float targetPrice) {
        int count = 0;                         // Initialize the counter
        for (float price : prices) {           // Iterate through each element in the prices array
            if (price == targetPrice) {        // Check if the current price matches the target price
                count++;                       // Increment the counter if there is a match
            }
        }
        return count;                          // Return the count of occurrences
    }

    // Method to compute the cumulative sum of stock prices
    public static ArrayList<Float> computeCumulativeSum(ArrayList<Float> prices) {
        ArrayList<Float> cumulativeSum = new ArrayList<>();   // Create a new ArrayList to store the cumulative sum
        float sum = 0;                        // Initialize the sum variable
        for (float price : prices) {          // Iterate through each element in the prices ArrayList
            sum += price;                    // Add each price to the sum
            cumulativeSum.add(sum);          // Add the cumulative sum to the cumulativeSum ArrayList
        }
        return cumulativeSum;                // Return the ArrayList containing the cumulative sum
    }

    public static void main(String[] args) {
        // Example usage
        float[] stockPricesArray = {60.5f, 101.7f, 150.2f, 50.5f, 85.0f, 92.5f, 70.5f, 120.5f, 80.2f, 135.5f};  // Sample array of stock prices
        ArrayList<Float> stockPricesList = new ArrayList<>();  // Create an ArrayList to store the stock prices
        for (float price : stockPricesArray) {                 // Loop through each element in the stockPricesArray
            stockPricesList.add(price);                         // Add each element to the ArrayList
        }

        // Printing the results of the analysis
        System.out.println("Average Stock Price: " + calculateAveragePrice(stockPricesArray));  // Calculate and print the average stock price
        System.out.println("Maximum Stock Price: " + findMaximumPrice(stockPricesArray));       // Find and print the maximum stock price
        System.out.println("Occurrences of 10.5: " + countOccurrences(stockPricesArray, 10.5f));  // Count and print the occurrences of a specific price
        System.out.println("Cumulative Sum: " + computeCumulativeSum(stockPricesList));          // Compute and print the cumulative sum of stock prices
    }
}
