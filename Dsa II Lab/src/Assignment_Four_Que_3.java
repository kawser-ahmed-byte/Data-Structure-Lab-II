import java.util.*;
class EdgeFour {
    int src, dest, weight;
}
public class Assignment_Four_Que_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int V = scanner.nextInt(), E = scanner.nextInt();
        EdgeFour[] edgeList = new EdgeFour[E];

        for (int i = 0; i < E; i++) {
            edgeList[i] = new EdgeFour();
            edgeList[i].src = scanner.nextInt();
            edgeList[i].dest = scanner.nextInt();
            edgeList[i].weight = scanner.nextInt();
        }

        Arrays.sort(edgeList, Comparator.comparingInt(a -> a.weight));
        int[] parent = new int[V];
        for (int i = 0; i < V; i++) parent[i] = i;
        int minimumCost = 0;

        for (EdgeFour edge : edgeList) {
            int x = find(parent, edge.src);
            int y = find(parent, edge.dest);
            if (x != y) {
                System.out.println(edge.src + " - " + edge.dest);
                minimumCost += edge.weight;
                union(parent, x, y);
            }
        }

        System.out.print("Weight: " + minimumCost);

        scanner.close();
    }

    static int find(int[] parent, int i) {
        if (parent[i] != i)
            parent[i] = find(parent, parent[i]);
        return parent[i];
    }

    static void union(int[] parent, int x, int y) {
        int xRoot = find(parent, x), yRoot = find(parent, y);
        parent[xRoot] = yRoot;
    }
}