import java.util.ArrayList;
        import java.util.Collections;
        import java.util.Comparator;
        import java.util.Scanner;
class Box_Item
{
    double weight, value, maximumProfit;
    String itemName;
}
class Assignment_Two_Que_1
{
    static class byValuePerWeight implements Comparator<Box_Item>
    {
        public int compare(Box_Item i1, Box_Item i2)
        {
            return Double.compare(i2.maximumProfit, i1.maximumProfit);
        }
    }
    static int fractionalKnapsack(int[] knapsackCapacity, int thiefNumber, ArrayList<Box_Item> itm)
    {
        Collections.sort(itm, new byValuePerWeight());
        int thiefCount = 0;
        for (int i = 0; i < thiefNumber; i++)
        {
            double currCapacity = knapsackCapacity[i];
            double profit = 0;
            for (Box_Item item : itm)
            {
                if (currCapacity == 0)
                {
                    break;
                }
                if (item.weight <= currCapacity)
                {
                    currCapacity -= item.weight;
                    profit += item.value;
                    System.out.printf("Taking %s: %.1f kg %.1f taka\n", item.itemName, item.weight, item.value);
                }
                else
                {
                    double frac = currCapacity / item.weight;
                    currCapacity = 0;
                    profit += frac * item.value;
                    System.out.printf("Taking %.1f kg of %s: %.1f taka\n", frac * item.weight, item.itemName, frac * item.value);
                }
            }

            if (profit > 0)
            {
                thiefCount++;
                System.out.printf("Thief %d profit: %.1f taka\n\n", i + 1, profit);
            }
        }
        System.out.printf("Total %d thieves stole from the warehouse.\n", thiefCount);
        int flag = 1;
        for (Box_Item item : itm)
        {
            if (item.weight > 0)
            {
                if (flag == 1)
                {
                    System.out.println("Still following items are left:");
                    flag = 0;
                }
                System.out.printf("\t%s\t%.1f kg %.1f taka\n", item.itemName, item.weight, item.value);
            }
        }
        return 0;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Box_Item> itm = new ArrayList<Box_Item>();
        for (int i = 0; i < n; i++)
        {
            Box_Item it = new Box_Item();
            String line = sc.next();
            it.itemName = line;
            it.value = sc.nextDouble();
            it.weight = sc.nextDouble();
            it.maximumProfit = it.value / it.weight;
            itm.add(it);
        }
        int thiefNumber = sc.nextInt();
        int thiefCapacity[] = new int[thiefNumber];
        for (int i = 0; i < thiefNumber; i++)
        {
            thiefCapacity[i] = sc.nextInt();
        }
        fractionalKnapsack(thiefCapacity, thiefNumber, itm);
    }
}