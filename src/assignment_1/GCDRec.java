package assignment_1;

import java.util.Scanner;
public class GCDRec {
    public static int findGCD(int a, int b) {
        if (b == 0) {
        return a;
        }else {
        return findGCD(b, a % b);
        }
    }
}
// logarithmic - O(logN)