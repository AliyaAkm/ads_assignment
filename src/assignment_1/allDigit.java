package assignment_1;

import java.util.Scanner;
public class allDigit{
    public static boolean AllDigit(String str,int idx){
        if(idx == str.length()){
            return true;
        }
        if(Character.isDigit(str.charAt(idx))){
            return AllDigit(str,idx + 1 );
        }
        return false;
    }
}
// linear - 0(N)