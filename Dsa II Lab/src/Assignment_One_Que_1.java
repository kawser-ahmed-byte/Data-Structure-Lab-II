import java.util.*;
import java.lang.*;
import java.io.*;

class Assignment_One_Que_1
{
    public static boolean isPrime(int x){
        if(x<=1)return false;
        for(int i=2;i<=x/2;i++){
            if(x%i==0)return false;
        }
        return true;
    }

    public static void printPrime(int arr[],int n){
        if(n==0){
            if(isPrime(arr[n]))System.out.print(arr[n] + " ");
            return;
        }
        else{
            printPrime(arr,n-1);
            if(isPrime(arr[n]))System.out.print(arr[n] + " ");
        }
    }

    public static int countPrime(int arr[],int n){
        if(n==0){
            if(isPrime(arr[n]))return 1;
            return 0;
        }
        else{
            int c1 = isPrime(arr[n]) ? 1 : 0;
            int c2 = countPrime(arr,n-1);
            return c1+c2;
        }
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);
        int n;
        n = scanner.nextInt();
        int A[] = new int[n];
        for(int i=0;i<n;i++){
            A[i] = scanner.nextInt();
        }
        printPrime(A,n-1);
        System.out.println("\n#primes=" + countPrime(A,n-1));
    }
}

//Input
//10
//1 2 3 4 5 6 7 8 9 10

//Output
//2 3 5 7
//#primes=4
