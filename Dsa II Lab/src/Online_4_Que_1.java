
import java.util.*;
class Online_4_Que_1 {
    static class Edges{
        int u,v;
    }
    static void make_set(int p[], int x){
        p[x] = x;
// System.out.println("making a one-element set of "+x);
    }

    static int find_set(int p[], int x){
        if (x!=p[x])
            return find_set(p, p[x]);
        return p[x];
    }

    static void _union(int p[], int x, int y){
        int a = find_set(p, x);
        int b = find_set(p, y);
        p[a] = b;
        // System.out.println("union "+a+" and "+b);
    }

    static void connectedComponents(int p[], int v, Vector<Edges> edges){
        for(int i=0;i<v;i++)make_set(p,i);

        for(int i=0;i<edges.size();i++){
            if(find_set(p,edges.get(i).u)!=find_set(p,edges.get(i).v)){
                _union(p,edges.get(i).u,edges.get(i).v);
            }
        }
    }

    static boolean sameComponent(int p[],int u, int v){
        if(find_set(p,p[u])==find_set(p,p[v])) return true;
        else return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v,e;
        v = sc.nextInt();
        e = sc.nextInt();
        int p[] = new int[v];

        Vector<Edges> vv = new Vector<>();
        for(int i=0;i<e;i++){
            Edges ee = new Edges();
            ee.u = sc.nextInt();
            ee.v = sc.nextInt();
            vv.add(ee);
        }

        connectedComponents(p,v,vv);

        int verticePair;
        verticePair = sc.nextInt();
        for(int i=0;i<verticePair;i++){
            int a,b;
            a = sc.nextInt();
            b = sc.nextInt();
            if(sameComponent(p,a,b)){
                System.out.println(a+" and "+b+" are in the same component");
            }
            else
                System.out.println(a+" and "+b+" are not in the same component");
        }
    }
}