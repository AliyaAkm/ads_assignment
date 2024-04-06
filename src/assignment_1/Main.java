package assignment_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //Task 1
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for(int i = 0;i<n;i++){
            System.out.println("Enter the element " + (i+1)+":");
            arr[i] = scanner.nextInt();}

        int min = MinFind.findMinimum(arr,n);
        System.out.println("Find Minimum: ");
        System.out.println( min);

        //Task 2
        System.out.println("Find average: ");
        double average = AverageFind.FindAverage(arr, 0);
        System.out.println(average);

        System.out.println("Enter the number: ");
        int a = scanner.nextInt();
        //Task 3
        System.out.println("Prime Check");
        if(PrimeCheck.isPrime(a,a / 2)){
            System.out.println(a + " prime");
        }
        else{
            System.out.println(a + " composite");
        }
        //Task 4
        System.out.println("Factorial: ");
        System.out.println(FindFactorial.Factorial(a));
        //Task 5
        System.out.println("Fibonacci: ");
        int result = FibonacciRec.fibonacci(a);
        System.out.println(result);

        System.out.println("Enter the n number: ");
        int m = scanner.nextInt();
        System.out.println("Enter the a number: ");
        int b = scanner.nextInt();
        // Task 6
        System.out.println("Power: ");
        long res = PowerCalculator.calculatePower(b, m);
        System.out.println(res);
        //Task 9
        System.out.println("Binomial: ");
        int resBin = BinomialRec.binomial(b,m);
        System.out.println( resBin);
        //Task 10
        System.out.println("GCD: ");
        int gcd = GCDRec.findGCD(m, b);
        System.out.println(gcd);
        //Task 7
        System.out.println("Enter a string(for permz): ");
        scanner.nextLine();
        String input = scanner.nextLine();
        System.out.println("assignment_1.Permutations: ");
        Permutations.permute(input.toCharArray(), 0);
        //Task 8
        System.out.println("Enter the string(for all digit): ");
        String alldigit = scanner.nextLine();
        System.out.println("All digit: ");
        if(allDigit.AllDigit(alldigit,0)){
            System.out.println("Yes!");
        }
        else{
            System.out.println("No!");
        }
        scanner.close();
    }
}
