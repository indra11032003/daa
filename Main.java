import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Item {
    int value, weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

class Solution {
    // Comparator function to sort items according to value/weight ratio
    private static Comparator<Item> comp = new Comparator<Item>() {
        public int compare(Item a, Item b) {
            double r1 = (double) a.value / (double) a.weight;
            double r2 = (double) b.value / (double) b.weight;
            if (r1 > r2) return -1;
            if (r1 < r2) return 1;
            return 0;
        }
    };

    // Function to return maximum value we can get
    public double fractionalKnapsack(int W, Item arr[], int n) {
        // Sort items by value/weight ratio
        Arrays.sort(arr, comp);

        int curWeight = 0;
        double finalValue = 0.0;

        for (int i = 0; i < n; i++) {
            if (curWeight + arr[i].weight <= W) {
                curWeight += arr[i].weight;
                finalValue += arr[i].value;
            } else {
                int remain = W - curWeight;
                finalValue += ((double) arr[i].value / (double) arr[i].weight) * (double) remain;
                break;
            }
        }

        return finalValue;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = sc.nextInt();

        System.out.print("Enter the capacity of the knapsack: ");
        int W = sc.nextInt();

        Item[] arr = new Item[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter value and weight for item " + (i + 1) + ": ");
            int value = sc.nextInt();
            int weight = sc.nextInt();
            arr[i] = new Item(value, weight);
        }

        Solution obj = new Solution();
        double ans = obj.fractionalKnapsack(W, arr, n);
        System.out.printf("The maximum value is %.2f", ans);

        sc.close();
    }
}
