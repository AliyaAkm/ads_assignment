package assignment_1;

import java.util.Scanner;
public class MinFind{
    public static int findMinimum(int[] arr,int n){
        if (n == 1){
            return arr[0];
        }
        int minOfRest = findMinimum(arr,n-1);
        return Math.min(minOfRest,arr[n-1]);
    }
}
// linear - 0(N)