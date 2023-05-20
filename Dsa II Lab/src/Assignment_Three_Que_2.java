import java.util.Scanner;
public class Assignment_Three_Que_2
{
    public static int slicedCakeUsingNaiveRecursion(int[] price, int n)
    {
        if (n == 0)
        {
            return 0;
        }
        int MaxIncome = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
        {
            MaxIncome = Math.max(MaxIncome, price[i] + slicedCakeUsingNaiveRecursion(price, n - i - 1));
        }
        return MaxIncome;
    }
    public static int slicedCakeUsingTabulationMethod(int[] price, int n)
    {
        int[] dpTable = new int[n+1];
        dpTable[0] = 0;
        int[] income = new int[n+1];
        for(int j=1;j<=n;j++)
        {
            int maxIncome = Integer.MIN_VALUE;
            for(int i=0;i<j;i++)
            {
                if(maxIncome<price[i]+dpTable[j-i-1])
                {
                    maxIncome = price[i]+dpTable[j-i-1];
                    income[j] = i+1;
                }
            }
            dpTable[j]=maxIncome;
        }
        int currLength=n;
        while(currLength!=0)
        {
            int piece = income[currLength];
            System.out.println(piece + " pieces together " + price[piece-1] + " taka" + "(tabulation method)");
            currLength-=piece;
        }
        return dpTable[n];
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] price = new int[n];
        for(int i=0; i<n; i++)
        {
            price[i] = sc.nextInt();
        }
        System.out.println("income: " + slicedCakeUsingNaiveRecursion(price,n) + " taka" + "(naive recursive)");
        System.out.println();
        slicedCakeUsingTabulationMethod(price, n);
        sc.close();
    }
}
/*
5
2 6 9 10 12
*/
