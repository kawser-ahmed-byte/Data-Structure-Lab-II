import java.util.*;
import java.lang.*;
import java.io.*;
class Dp_Coin_Change
{
    public static void dpCoinChange(int M, int coins[], int numberOfCoinType){
        int mnc[] = new int[M+1];
        int cc[] = new int[M+1];
        mnc[0] = 0;
        if(M==0)return;
        else{
            for(int m=1;m<=M;m++){
                mnc[m] = Integer.MAX_VALUE;
                for(int i=0;i<numberOfCoinType;i++){
                    if(coins[i]<=m){
                        int min = 1+mnc[m-coins[i]];
                        if(min<mnc[m]){
                            mnc[m] = min;
                            cc[m] = coins[i];
                        }
                    }
                }
            }
        }

        System.out.println("DP: " + mnc[M]);
        int count = M;

        System.out.print("Using coins: ");
        while(count!=0){

            System.out.print(cc[count]+ " ");
            count-=cc[count];
        }
    }

    public static int coinChangeNormalRecursive(int M, int coins[], int numberOfCoinType){
        int min = Integer.MAX_VALUE;
        if(M==0)return 0;
        else{
            for(int i=0;i<numberOfCoinType;i++){
                if(coins[i]<=M){
                    int numberOfCoins = coinChangeNormalRecursive(M-coins[i],coins,numberOfCoinType);
                    if(min>numberOfCoins+1){
                        min = numberOfCoins+1;
                    }
                }
            }
        }
        return min;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);
        int M,numberOfCoinType;
        M = scanner.nextInt();
        numberOfCoinType = scanner.nextInt();
        int coins[] = new int[numberOfCoinType];
        for(int i=0;i<numberOfCoinType;i++){
            coins[i] = scanner.nextInt();
        }
        System.out.println(coinChangeNormalRecursive(M,coins,numberOfCoinType));
        dpCoinChange(M,coins,numberOfCoinType);
    }
}

//Input
//26
//3
//1 4 9

//Output
//4
//DP: 4
//Using coins: 1 1 1 9