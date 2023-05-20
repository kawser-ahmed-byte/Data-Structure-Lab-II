
import java.util.Scanner;

public class Online_1_Que_1
{
    public static int gcd(int x, int y)
    {
        if(x==0)
        {
            return y;
        }
        else if (y == 0)
        {
            return x;
        }
        else
        {
            if(x>y)
            {
                return gcd(y, x%y);
            }
            else
            {
                return gcd(x, y%x);
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(gcd(x,y));
    }
}
