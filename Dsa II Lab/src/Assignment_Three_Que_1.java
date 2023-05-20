import java.util.*;

public class Assignment_Three_Que_1 {

    public static boolean subsetSumRecursion(int[] A, int n, int X) {
        if (n == 0) return false;
        if (X == 0) return true;
        if (X < A[n - 1]) return subsetSumRecursion(A, n - 1, X);
        else {
            return subsetSumRecursion(A, n - 1, X) || subsetSumRecursion(A, n - 1, X - A[n - 1]);
        }
    }

    public static void subsetSumDP(int[] A, int n, int X) {
        boolean[][] p = new boolean[n + 1][X + 1];
        for (int i = 0; i <= n; i++) p[i][0] = true;
        for (int j = 1; j <= X; j++) p[0][j] = false;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= X; j++) {
                if (j < A[i - 1]) p[i][j] = p[i - 1][j];
                else p[i][j] = (p[i - 1][j - A[i - 1]]) || (p[i - 1][j]);
            }
        }
        if (p[n][X] == true) {
            int[] sums = new int[n + 1];
            int k = 0;
            int i = n, j = X;
            while (p[i][j] != false) {
                if (i == 0 && j == 0) break;
                else {
                    if (p[i][j] != p[i - 1][j]) {
                        sums[k] = A[i - 1];
                        k++;
                        j = j - A[i - 1];
                        i--;
                    } else i--;
                }
            }

            System.out.println(X + " is a subset sum");
            for (int s = 0; s < k; s++) {
                System.out.print(sums[s] + " ");
                if (s != k - 1) System.out.print("+ ");
            }
            System.out.println("= " + X);
        } else
            System.out.println(X + " is not a subset sum");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        int X = sc.nextInt();

        System.out.println("======Solved B======");
        if (subsetSumRecursion(A, n, X))
            System.out.println(X + " is a subset sum (NaiveRecursion)");
        else
            System.out.println(X + " is not a subset sum (NaiveRecursion)");

        System.out.println("\n======Solved C======");
        subsetSumDP(A, n, X);
    }
}
/*
5
2 4 6 5 8
15
*/
