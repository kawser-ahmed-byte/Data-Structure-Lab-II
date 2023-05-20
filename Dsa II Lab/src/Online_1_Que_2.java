
import java.util.Scanner;

public class Online_1_Que_2
{
    public static boolean divisibleBy11(int x)
    {
        if(x%11==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static int sumOfGoodNum(int Arr[], int key, int n)
    {
        if(key == n)
        {
            if(divisibleBy11(Arr[n]))
            {
                return Arr[n];
            }
            else return 0;
        }
        else
        {
            int mid = (key+n)/2;
            int x = sumOfGoodNum(Arr, key, mid);
            int y = sumOfGoodNum(Arr, mid+1, n);
            return x+y;
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []Arr = new int[n];
        for(int i=0; i<n; i++)
        {
            Arr[i]=sc.nextInt();
        }
        int res = sumOfGoodNum(Arr, 0, n-1);
        System.out.println(res);
    }
}

/*
5
11 0 1 5 22
 */
