import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.io.*;

class Assignment_One_Que_2
{
    public static boolean is_palindrome(String arr, int track){
        int firstIndex = track;
        int lastIndex = arr.length()-1-track;
        if(firstIndex>=lastIndex){
            return true;
        }
        else{
            char firstChar=arr.charAt(firstIndex);
            char lastChar=arr.charAt(lastIndex);
            if(firstChar==lastChar){
                return is_palindrome(arr,track+1);
            }
            else return false;
        }
    }

    public static int sum_palindrome(int palindromes[], int n){
        if(n==0)return palindromes[0];
        else{
            return palindromes[n] + sum_palindrome(palindromes,n-1);
        }
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);
        int X,Y;
        X = scanner.nextInt();
        Y = scanner.nextInt();
        int palindromes[] = new int[Y-X+1];
        int k=0;
        for(int i=X;i<=Y;i++){
            String temp = Integer.toString(i);

            if(is_palindrome(temp,0)){
                palindromes[k] = Integer.parseInt(temp);
                System.out.print(palindromes[k] + " ");
                k++;
            }
        }
        System.out.println("\nsum " + sum_palindrome(palindromes,k-1));
    }
}

//Input
//10 100

//Output
//11 22 33 44 55 66 77 88 99
//sum 495