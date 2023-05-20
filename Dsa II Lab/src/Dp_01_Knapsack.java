import java.util.Scanner;

public class Dp_01_Knapsack {
    public static int dpKnapsack(int capacity, int n, int value[], int weight[]) {
        int[][] P = new int[n+1][capacity+1];

        for(int i=0;i<=n;i++){
            for(int w=0;w<=capacity;w++){
                if(i==0 || w==0) P[i][w] = 0;
                else if(weight[i-1] <= w){
                    if(value[i-1]+P[i-1][w-weight[i-1]] > P[i-1][w]){
                        P[i][w] = value[i-1] + P[i-1][w-weight[i-1]];
                    }
                    else{
                        P[i][w] = P[i-1][w];
                    }
                }
                else{
                    P[i][w] = P[i-1][w];
                }
            }
        }

        System.out.println("Profit: " + P[n][capacity]);

        int result=P[n][capacity];
        int w=capacity;
        System.out.println("By taking:");
        for(int i=n; i>0 && result>0; i--){
            if(result == P[i-1][w]) continue;
            else{
                System.out.println(value[i-1] + " " + weight[i-1]);
                result -= value[i-1];
                w = w-weight[i-1];
            }
        }
        return P[n][capacity];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] value = new int[n];
        int[] weight = new int[n];

        for(int i=0;i<n;i++){
            value[i] = sc.nextInt();
            weight[i] = sc.nextInt();
        }
        int capacity = sc.nextInt();

        dpKnapsack(capacity, n, value, weight);
    }
}
/*
4
16 4
9 3
18 3
16 2
5
*/