
import java.util.*;

class Edge{
    int u, v;
    public Edge(int u, int v){
        this.u = u;
        this.v = v;
    }
}

public class Assignment_Four_Que_2 {
    static void make_set(int p[], int x){
        p[x] = x;
        System.out.println("making a one-element set of " + x);
    }

    static int find_set(int p[], int x){
        if (x!=p[x])
            return find_set(p, p[x]);
        return p[x];
    }

    static void Union(int p[], int x, int y){
        int a = find_set(p, x);
        int b = find_set(p, y);
        p[a] = b;
        System.out.println("union "+a+ " and "+b);
    }

    static void connected_components(int p[], int V, ArrayList<Edge> edges){
        for(int i=0;i<V;i++){
            make_set(p,i);
        }
        for(int i=0;i<edges.size();i++){
            if(find_set(p,edges.get(i).u)!=find_set(p,edges.get(i).v)){
                Union(p,edges.get(i).u,edges.get(i).v);
            }
        }
    }

    static boolean same_component(int p[], int u, int v){
        if(find_set(p,u)==find_set(p,v)) return true;
        else return false;
    }
    public static void main(String args[]){
        /// This code is for an undirected graph
        Scanner sc = new Scanner(System.in);

        int V, E;
        /// take the number of vertices V and
        /// the number of edges E as input from user
        V = sc.nextInt();
        E = sc.nextInt();
        /// take the E edges as input from the user
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i=0;i<E;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            edges.add(new Edge(u, v));
        }
/// create the parent array for a disjoint set of V elements
        int p[] = new int[V];
        connected_components(p, V, edges);
/// call the function connected_components
        while(true){
            /// take an integer "option" as input.
            int option = sc.nextInt();
            /// if "option" is 1, take another integer x as input,
            /// check if x is an element of the disjoint set or not, and
            /// if it is then print the root/representative-element of x
            if (option==1){
                int x= sc.nextInt();
                boolean flag=false;
                for(int i=0;i<V;i++){
                    if(p[i]==x){
                        flag=false;break;
                    }
                }
                if(flag)System.out.println(find_set(p,x)+" is the representative element of " + x);
                else System.out.println(x+" is not an element of the disjoint set.");
            }
            /// if "option" is 2, take integers x and y as input,
            /// check if x and y are elements of the disjoint set or not, and
            /// if they are, print whether they belong to the
            /// same connected component or not
            else if (option==2){
                int x = sc.nextInt();
                int y = sc.nextInt();
                if(same_component(p,x,y))System.out.println(x+" and "+y+" are in the same component");
                else System.out.println(x+" and "+y+" are not in the same component");

            }

            /// if "option" is 3, take integers x and y as input,
            /// check if x and y are elements of the disjoint set or not, and
            /// if they are, print if there is a path from x to y or not.
            else if (option==3){
                int x = sc.nextInt();
                int y = sc.nextInt();
                if(find_set(p,x)!=find_set(p,y))System.out.println("there is no path between "+x+" and "+y);
                else System.out.println("there exists a path between "+x+" and "+y);
            }

            /// if "option" is 4, print all the roots of this disjoint set
            else if (option==4){
                System.out.println("Printing all the roots: ");
                for(int i=0;i<V;i++){
                    if(p[i]==i){
                        System.out.print(i+" ");
                    }
                }
                System.out.println();
            }

            /// if "option" is 5, print the vertices of each connected components
            /// in each line
            else if (option==5){
                ArrayList<Integer> v[] = new ArrayList[V];
                for(int i=0;i<V;i++){
                    int c = find_set(p,i);
                    if(v[c]==null){
                        v[c] = new ArrayList<>();
                    }
                    v[c].add(i);
                }
                for(int i=0;i<V;i++){
                    if(v[i]!=null && v[i].size()>0){
                        for(int m : v[i])System.out.print(m+" ");
                        System.out.println();
                    }
                }
                /// 0 1 5
                /// 2 3
                /// 4
            }

            else {
                sc.close();
                return;
            }
        }
    }
}

/*
8
5
0 1
1 2
0 3
1 3
4 5
5
1
8
1
7
2
0 4
3 0 4
4
6
 */
