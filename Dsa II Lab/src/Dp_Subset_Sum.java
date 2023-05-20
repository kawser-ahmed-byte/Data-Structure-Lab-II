import java.util.*;
import java.lang.*;
import java.io.*;

class MaDp_Subset_Sumin
{
    //Naive recursion
    public static boolean sumofsubsetNaiveREC(int A[],int n,int sum)
    {
        if(n==0)return false;
        if(sum==0)return true;
        if(A[n-1]>sum)
            return sumofsubsetNaiveREC(A,n-1,sum);
        else
            return sumofsubsetNaiveREC(A,n-1,sum) || sumofsubsetNaiveREC(A,n-1,sum-A[n-1]);
    }

    //DP
    public static void sumofsubset(int A[],int n,int sum)
    {
        boolean p[][] = new boolean[n+1][sum+1];
        for(int i=0; i<=n; i++)
            p[i][0]=true;
        for(int j=1; j<=sum; j++)
            p[0][j]=false;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                if(j<A[i-1]) p[i][j]=p[i-1][j];
                else p[i][j] = p[i-1][j] || p[i-1][j-A[i-1]];
            }
        }
        if(p[n][sum])
        {
            System.out.println(sum+" is the subset ");
            ArrayList<Integer> v=new ArrayList<Integer>();
            int i=n,j=sum;
            while(p[i][j]!=false)
            {
                if(i==0 && j==0)break;
                else
                {
                    if(p[i][j]!=p[i-1][j])
                    {
                        v.add(A[i-1]);
                        j=j-A[i-1];
                        i--;
                    }
                    else
                        i--;
                }
            }
            int size=v.size();
            for(i=0; i<v.size(); i++)
            {
                if(i==size-1)System.out.print(v.get(i));
                else System.out.print(v.get(i)+"+");
            }
            System.out.println("="+sum);
        }
        else
            System.out.println(sum+" is not the subset");
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);
        int n;
        n = scanner.nextInt();
        int A[] = new int[n];
        for(int i=0; i<n; i++)
        {
            A[i] = scanner.nextInt();
        }
        int N;
        N = scanner.nextInt();//Target

        //function call for DP
        sumofsubset(A,n,N);

        //function call for naive recursion
        if(sumofsubsetNaiveREC(A,n,N))
            System.out.println(N+" is the subset(NaiveRecursion) ");
        else
            System.out.println(N+" is not the subset(NaiveRecursion)");
    }
}

//Input
//5
//2 4 6 5 8
//15

//Output
//15 is the subset
//4+6+5=15
//15 is the subset(NaiveRecursion)
