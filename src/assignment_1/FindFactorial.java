package assignment_1;

import java.util.Scanner;
public class FindFactorial{
    public static int Factorial(int n){
        if (n == 0 || n == 1){
            return 1;
        }
        return n * Factorial(n-1);
    }
}
