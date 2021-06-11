import java.util.*;

public class StronglyConnectedComponents {
    public int V;
    public LinkedList<Integer> adj[];

    StronglyConnectedComponents(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; i++)
            adj[i] = new LinkedList();
    }


    void addEdge(int v, int w)  { adj[v].add(w); }

    List<Integer> DFS(int v,boolean visited[],List<Integer> L)
    {
        visited[v] = true;
        L.add(v);

        int n;

        Iterator<Integer> i =adj[v].iterator();
        while (i.hasNext())
        {
            n = i.next();
            if (!visited[n])
                DFS(n,visited,L);
        }
        return L;
    }

    StronglyConnectedComponents Reverse()
    {
        StronglyConnectedComponents g = new StronglyConnectedComponents(V);
        for (int v = 0; v < V; v++)
        {
            Iterator<Integer> i =adj[v].listIterator();
            while(i.hasNext())
                g.adj[i.next()].add(v);
        }
        return g;
    }

    void fillOrder(int v, boolean visited[], Stack stack)
    {

        visited[v] = true;

        Iterator<Integer> i = adj[v].iterator();
        while (i.hasNext())
        {
            int n = i.next();
            if(!visited[n])
                fillOrder(n, visited, stack);
        }

        stack.push(new Integer(v));
    }

    List<List<Integer>> SCC()
    {
        Stack stack = new Stack();
        List<List<Integer>> L1 = new ArrayList<List<Integer>>();

        boolean visited[] = new boolean[V];
        for(int i = 0; i < V; i++)
            visited[i] = false;

        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                fillOrder(i, visited, stack);

        StronglyConnectedComponents gr = Reverse();

        for (int i = 0; i < V; i++)
            visited[i] = false;


        while (stack.empty() == false)
        {
            List<Integer> L = new ArrayList<Integer>();

            int v = (int)stack.pop();

            if (visited[v] == false)
            {
                L1.add(gr.DFS(v, visited,L));

            }
        }
        return L1;
    }

    public static List<List<Integer>> scc(int students, List<List<Integer>> knows) {

        StronglyConnectedComponents g = new StronglyConnectedComponents(students);
        for (int z = 0; z<knows.size(); z++){
            g.addEdge(knows.get(z).get(0),knows.get(z).get(1));
        }

        return g.SCC();

    }
}
