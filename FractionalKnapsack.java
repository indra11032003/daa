import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// Class representing an item with weight, profit, and profit-to-weight ratio
class item {
    double weight, profit, ratio;

    // Constructor to initialize an item with weight and profit, and calculate the ratio
    item(double weight, double profit) {
        this.weight = weight;
        this.profit = profit;
        this.ratio = profit / weight;
    }
}

public class FractionalKnapsack {

    // Method to calculate the maximum value that can be carried in the knapsack
    public static double getMaxValue(item[] items, double capacity) {
        
        // Sort items by their profit-to-weight ratio in descending order
       Arrays.sort(items,new Comparator<item>(){
        public int compare(item o1,item o2){
            return Double.compare(o2.ratio, o1.ratio);
        }

       });


     /*  Arrays.sort(items, new Comparator<item>() {
        public int compare(item o1, item o2) {
            return Double.compare(o2.ratio, o1.ratio);
        }
    });*/

        // Variable to keep track of the total value in the knapsack
        double totalValue = 0; 
        
        // Iterate through the sorted items
        for (item item : items) {
            if (capacity - item.weight >= 0) {
                // If the item can be completely added to the knapsack
                capacity -= item.weight;
                totalValue += item.profit;
            } else {
                // If only part of the item can be added to the knapsack
                totalValue += item.profit * (capacity / item.weight);
                break; // No more capacity left, exit the loop
            }
        }
        
        return totalValue; // Return the total value accumulated
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of items from the user
        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        // Create an array to store the items
        item[] items = new item[n];

        // Get the weight and profit for each item from the user
        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight and profit for item " + (i + 1) + ": ");
            double weight = scanner.nextDouble();
            double profit = scanner.nextDouble();
            items[i] = new item(weight, profit);
        }

        // Get the knapsack capacity from the user
        System.out.print("Enter the capacity of the knapsack: ");
        double capacity = scanner.nextDouble();

        // Calculate the maximum value that can be carried and print the result
        double maxValue = getMaxValue(items, capacity);
        System.out.println("Maximum value in knapsack: " + maxValue);

        scanner.close();
    }
}
