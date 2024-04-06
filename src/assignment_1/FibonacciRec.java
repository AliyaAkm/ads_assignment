package assignment_1;

import java.util.Scanner;
public class FibonacciRec {
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
// exponential - O(2^n)