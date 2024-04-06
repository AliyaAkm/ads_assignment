package assignment_1;

import java.util.Scanner;
public class Permutations {
    public static void permute(char[] arr, int index) {
        if (index == arr.length - 1) {
        System.out.println(new String(arr));
        } else {
        for (int i = index; i < arr.length; i++) {
            char temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
            permute(arr, index + 1);
            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
            }
        }
    }
}
