public class fiboITE {
    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        long fib0 = 0;
        long fib1 = 1;
        long fibN = 0;

        for (int i = 2; i <= n; i++) {
            fibN = fib0 + fib1;
            fib0 = fib1;
            fib1 = fibN;
        }

        return fibN;
    }

    public static void main(String[] args) {
        int n = 5; // Example: Calculate 10th Fibonacci number
        System.out.println("Fibonacci(" + n + ") = " + fibonacci(n));
    }
}
