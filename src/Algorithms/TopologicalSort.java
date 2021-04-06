package Algorithms;

import java.util.*;

public class TopologicalSort {
    int V;// No. of vertices

    //An Array of List which contains
    //references to the Adjacency List of
    //each vertex
    List<Integer> adj[];
    public TopologicalSort(int V)// Constructor
    {
        this.V = V;
        adj = new ArrayList[V];
        for(int i = 0; i < V; i++)
            adj[i]=new ArrayList<Integer>();
    }

    // function to add an edge to graph
    public void addEdge(int u,int v)
    {
        adj[u].add(v);
    }
    // prints a Topological Sort of the complete graph
    public void topologicalSort()
    {
        // Create a array to store indegrees of all
        // vertices. Initialize all indegrees as 0.
        int indegree[] = new int[V];

        // Traverse adjacency lists to fill indegrees of
        // vertices. This step takes O(V+E) time
        for(int i = 0; i < V; i++)
        {
            ArrayList<Integer> temp = (ArrayList<Integer>) adj[i];
            for(int node : temp)
            {
                indegree[node]++;
            }
        }

        // Create a queue and enqueue all vertices with
        // indegree 0
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0;i < V; i++)
        {
            if(indegree[i]==0)
                q.add(i);
        }

        // Initialize count of visited vertices
        int cnt = 0;

        // Create a vector to store result (A topological
        // ordering of the vertices)
        Vector<Integer> topOrder=new Vector<Integer>();
        while(!q.isEmpty()) {
            // Extract front of queue (or perform dequeue)
            // and add it to topological order
            int u = q.poll();
            topOrder.add(u);

            // Iterate through all its neighboring nodes
            // of dequeued node u and decrease their in-degree
            // by 1
            for (int node : adj[u]) {
                // If in-degree becomes zero, add it to queue
                if (--indegree[node] == 0)
                    q.add(node);
            }
            cnt++;
        }
        if (cnt != V) {
            System.out.println("A cycle detected!");
            return;
        }


        // Print topological order
        for(int i : topOrder)
        {
            System.out.print(i+" ");
        }

        System.out.println();
    }

    //The function is helper method of topologicalSortStack
    void topologicalSortStackHelper(int v, boolean[] visited, Stack<Integer> stack)
    {
        visited[v] = true;
        int i;
        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i])
                topologicalSortStackHelper(i, visited, stack);
        }
        stack.push(v);
    }


    //Using the topologicalSortStackHelper method, it makes topological sort.
    void topologicalSortStack()
    {
        Stack<Integer> stack = new Stack<Integer>();

        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;
        for (int i = 0; i < V; i++)
            if (!visited[i])
                topologicalSortStackHelper(i, visited, stack);
        while (!stack.empty())
            System.out.print(stack.pop() + " ");
    }
}
