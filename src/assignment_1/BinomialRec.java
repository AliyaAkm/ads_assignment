package assignment_1;

import java.util.Scanner;
public class BinomialRec {
    public static int binomial(int n, int k) {
        if (k == 0 || k == n) {
        return 1;        }
        return binomial(n - 1, k - 1) + binomial(n - 1, k);
    }
}
