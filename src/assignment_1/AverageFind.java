package assignment_1;

import java.util.Scanner;

public class AverageFind {
    public static double FindAverage(int[] arr, int n) {
        if (n == arr.length) {
            return 0;
        }
        double sum = arr[n] + FindAverage(arr, n + 1);
        return sum / arr.length;
    }
}
//linear - 0(N)