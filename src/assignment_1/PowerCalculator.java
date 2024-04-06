package assignment_1;

public class PowerCalculator {
    public static long calculatePower(int n, int a) {
        if (n == 0) {
            return 1;
        } else {
            return a * calculatePower(n - 1, a);
        }
    }
}
// linear - O(n)