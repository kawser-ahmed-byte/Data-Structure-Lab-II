import java.util.*;
import java.lang.*;
import java.io.*;

class Dp_Rod_Cutting
{
    public static int rodCutting(int p[], int n){
        int r[] = new int[n+1];
        r[0] = 0;
        if(n==0)return 0;
        else{
            for(int m=1;m<=n;m++){
                int q = Integer.MIN_VALUE;
                for(int x=0;x<m;x++){
                    if(q<p[x]+r[m-x-1]){
                        q = p[x]+r[m-x-1];
                    }
                }
                r[m] = q;
            }
        }
        return r[n];
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);
        int length;
        length = scanner.nextInt();
        int price[] = new int[length];
        for(int i=0;i<length;i++){
            price[i] = scanner.nextInt();
        }
        System.out.println(rodCutting(price, length));
    }
}

//Input
//5
//5 7 9 21 23

//Output
//23
