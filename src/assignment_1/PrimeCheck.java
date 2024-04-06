package assignment_1;

import java.util.Scanner;
public class PrimeCheck{
    public static boolean isPrime(int n,int divisor){
        if (n <= 1){
            return false;
        }
        if (divisor == 1){
            return true;
        }
        if (n % divisor == 0){
            return false;
        }
        return isPrime(n,divisor - 1);
    }
}
