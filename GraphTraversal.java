import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;
public class GraphTraversal
{
    //PRINTING DEPTH WISE GRAPH
    public static void printDFS(int[][] edges)
    {
        boolean[] visited=new boolean[edges.length];
        for(int i=0;i<edges.length;i++)
        {
            if(!visited[i])
            {
                printHelperDFS(edges,i,visited);
            }
        }
    }
    private static void printHelperDFS(int[][] edges,int sv,boolean[] visited)
    {
        System.out.print(sv+ " ");
        visited[sv]=true;
        int n=edges.length;
        for(int i=0;i<n;i++)
        {
            if(edges[sv][i]==1 && !visited[i])
            {
                printHelperDFS(edges, i, visited);
            }
        }
    }

    //PRINTING LEVEL WISE GRAPH
    public static void printBFS(int[][] edges)
    {
        boolean[] visited=new boolean[edges.length];
        for(int i=0;i<edges.length;i++)
        {
            if(!visited[i])
            {
                printHelperBFS(edges, 0, visited);
            }
        }
        
    }
    private static void printHelperBFS(int[][] edges, int sv,boolean[] visited)
    {
        Queue<Integer> q=new LinkedList<>();
        int n=edges.length;
        q.add(sv);
        visited[sv]=true;
        while(!q.isEmpty())
        {
            int front=q.poll();
            System.out.print(front+" ");
            for(int i=0;i<n;i++)
            {
                if(edges[front][i]==1 && !visited[i])
                {
                    q.add(i);
                    visited[i]=true;
                }
            }
        }
    }

    //HAS PATH (DFS)
    public static boolean hasPathDFS(int[][] edges, int sv, int ev, boolean[] visited)
    {
        if(edges[sv][ev]==1 || sv==ev)
        {
            return true;
        }
        visited[sv]=true;
        for(int i=0;i<edges.length;i++)
        {
            if(edges[sv][i]==1 && !visited[i])
            {
                if(hasPathDFS(edges, i, ev, visited))
                {
                    return true;
                }    
            }
        }
        return false;
    }

    //GET PATH DFS
    public static ArrayList<Integer> getPathDFS(int[][] edges, int sv, int ev)
    {
        boolean[] visited =new boolean[edges.length];
        return getPathDFS(edges, visited,sv,ev );
    }
    private static ArrayList<Integer> getPathDFS(int[][] edges,boolean[] visited,int sv,int ev)
    {
        if(sv==ev)
        {
            ArrayList<Integer> ans=new ArrayList<>();
            ans.add(ev);
            visited[ev]=true;
            return ans;
        }
        visited[ev]=true;
        for(int i=0;i<edges.length;i++)
        {
            if(edges[i][ev]==1 && !visited[i])
            {
                ArrayList<Integer> ans=getPathDFS(edges, visited, sv, i);
                if(ans!=null)
                {
                    ans.add(ev);
                    return ans;
                }
            }
        }
        return null;
    }


    //GET PATH BFS
    public static ArrayList<Integer> getPathBFS(int[][] edges, int sv, int ev)
    {
        boolean[] visited =new boolean[edges.length];
        return getPathBFS(edges, visited,sv,ev );    
    }
    private static ArrayList<Integer> getPathBFS(int[][] edges,boolean[] visited,int sv,int ev)
    {
        if(sv==ev)
        {
            ArrayList<Integer> ans=new ArrayList<>();
            ans.add(sv);
            visited[sv]=true;
            return ans;
        }
        
        Queue<Integer> q=new LinkedList<>();
        HashMap<Integer,Integer> h=new HashMap<>();
        ArrayList<Integer> ans=new ArrayList<>();
        q.add(sv);
        visited[sv]=true;
        while(!q.isEmpty())
        {
            int front=q.poll();
            for(int i=0;i<edges.length;i++)
            {
                if(edges[front][i]==1 && !visited[i])
                {
                    visited[i]=true;
                    q.add(i);
                    h.put(i,front);
                    if(i==ev)
                    {
                        ans.add(i);
                        while(!ans.contains(sv))
                        {
                            int b=h.get(i);
                            ans.add(b);
                            i=b;    
                        }
                        return ans;
                    }
                }
            }
        }
        return null;
    }
public static void main(String[] args) {
    int n;
    int e;
    Scanner sc=new Scanner(System.in);
    n=sc.nextInt();
    e=sc.nextInt();
    int[][] edges=new int[n][n];
    for(int i=0;i<e;i++)
    {
        int fv=sc.nextInt();
        int sv=sc.nextInt();
        edges[fv][sv]=1;
        edges[sv][fv]=1;

    }
    System.out.print("DFS: ");
    printDFS(edges);
    System.out.println();
    System.out.print("BFS: ");
    printBFS(edges);
    System.out.println();
    //System.out.println(edges.length==n);


    // System.out.println("Has Path: ");
    // boolean[] visited=new boolean[n];  //vertex size
    // System.out.println(hasPathDFS(edges, 1, 6, visited));

    System.out.println("Get Path DFS");
    System.out.println(getPathDFS(edges, 1, 6));

    System.out.println("Get Path BFS");
    System.out.println(getPathDFS(edges, 1, 6));
    sc.close();
}
}
