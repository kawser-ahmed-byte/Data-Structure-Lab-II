ĺimport java.util.*;

class DSU {

    private int[] parent;
    private int[] rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int findSet(int x) {
        if (parent[x] != x) {
            parent[x] = findSet(parent[x]); // path compression
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);
        if (px == py) {
            return;
        }
        if (rank[px] > rank[py]) {
            parent[py] = px;
        } else if (rank[px] < rank[py]) {
            parent[px] = py;
        } else {
            parent[px] = py;
            rank[py]++;
        }
    }

}

public class Assignment_Four_Que_1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = input.nextInt();
        DSU dsu = new DSU(n);
        while (true) {
            System.out.println("1. Find set representative");
            System.out.println("2. Check if two elements belong to the same set");
            System.out.println("3. Merge two sets");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            if (choice == 1) {
                System.out.print("Enter the element to find its set representative: ");
                int x = input.nextInt();
                System.out.println("Set representative of " + x + " is " + dsu.findSet(x));
            } else if (choice == 2) {
                System.out.print("Enter two elements to check if they belong to the same set: ");
                int x = input.nextInt();
                int y = input.nextInt();
                if (dsu.findSet(x) == dsu.findSet(y)) {
                    System.out.println(x + " and " + y + " belong to the same set.");
                } else {
                    System.out.println(x + " and " + y + " do not belong to the same set.");
                }
            } else if (choice == 3) {
                System.out.print("Enter two elements to merge their sets: ");
                int x = input.nextInt();
                int y = input.nextInt();
                dsu.union(x, y);
                System.out.println("Sets merged.");
            } else {
                break;
            }
        }
    }

}
