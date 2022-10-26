import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

@SuppressWarnings("unchecked")
public class HashGraph extends Graph {

    int p; // Big Prime (for PolyHash())
    int x; // Small number (for PolyHash())

    // This is complete, no need to edit
    public HashGraph(int cap, int p, int x) {
        super(cap); // Forward the parameter to Graph's constructor
        this.p = p;
        this.x = x;
    }

    public static int polyHash(String s, int p, int x) {
        int hash = 0;
        // Do something
        for (int i = s.length() - 1; i >= 0; i--) {
            int c = s.charAt(i);
            hash = (hash * x + c) % p;
        }
        return hash;
    }

    public int getListIndex(String s) {
        int bin = polyHash(s, p, x);
        for (int k = 0; k < cap; k++) {
            bin = (bin + k) % cap;
            if (vertexList[bin] == null || vertexList[bin].strKey.equals(s))
                break;
        }
        return bin; // Fix this
    }

    public void addVertex(String key) {
        if (size == cap) {
            System.out.println("Vertex list is full. You need to recreate the Graph");
            return;
        }

        // Map the String key to the array index (use getListIndex())
        // Pls use code from the previous problem as the starter
        int idx = getListIndex(key);
        vertexList[idx] = new Vertex(key);
        vertexList[idx].strKey = String.valueOf(key);
        adjacencyList[idx] = new LinkedList<>();
    }

    public void addEdge(String source, String destination) {
        // Map String's source and destination (city name) to Integer's u, v (array
        // index)
        // You may call super.addEdge(u, v); for simpler implementation
        super.addEdge(getListIndex(source), getListIndex(destination));
    }

    public void BFS(Vertex s) {
        Queue<Vertex> queue = new LinkedList<>();
        // Set all Vertex.dist to Infinity (Use Integer.MAX_VALUE to represent Infinity)
        for (Vertex vertex : vertexList) {
            if (vertex != null)
                vertex.dist = Integer.MAX_VALUE;
        }

        // Set dist of the start vertex (s) to 0
        s.dist = 0;
        // Push the start vertex to an empty queue
        queue.add(s);
        // [*] Check if the queue is not empty
        // Pop queue and get the current vertex
        // Extract the list of all vertices that are connected to current vertex
        while (!queue.isEmpty()) {
            Vertex c = queue.remove();
            for (var idx : adjacencyList[getListIndex(c.strKey)]) {
                if (vertexList[idx].dist == Integer.MAX_VALUE) {
                    vertexList[idx].prev = c;
                    vertexList[idx].dist = c.dist + 1;
                    queue.add(vertexList[idx]);
                }
            }
        }

        // Traverse all the list check if the dist value of anyone are still infinity or
        // not
        // If yes, set push that vertex into the queue
        // increase the dist variable of that vertex by one
        // set the prev variable of that vertex to the current vertex

        // Repeat [*]
    }

    public Stack<Vertex> getShortestPathList(Vertex S, Vertex U) {

        // Create a stack
        Stack<Vertex> stack = new Stack<>();

        // Start from city U
        // [*] push the current city into the stack
        // Go back one city using U.prev
        // Repeat [*] until you reach the city S
        Vertex c = U;
        while (c != S) {
            stack.push(c);
            c = c.prev;
        }
        stack.push(c);

        // return the stack
        return stack; // Fix this
    }

    public void printShortestPath(String s_str, String u_str) {

        // Map city names to index numbers
        // Get vertices from the vertexList
        // Run BFS() at the starting city
        // Get shortestPartList(starting city, ending city)
        // Traverse all the stack and print the city name
        BFS(vertexList[getListIndex(s_str)]);
        Stack<Vertex> path = getShortestPathList(vertexList[getListIndex(s_str)], vertexList[getListIndex(u_str)]);
        while (!path.empty()) {
            System.out.print(path.pop().strKey + " -> ");
        }
        System.out.println();
    }

    // This function is complete, no need to edit
    public void showVertexList() {
        for (int i = 0; i < vertexList.length; i++) {
            if (vertexList[i] != null)
                System.out.println("vertexList[" + i + "] contains " + vertexList[i].strKey);
            else
                System.out.println("vertexList[" + i + "] null");
        }
    }

    // This is editable test case, but no need to edit
    public static HashGraph constructGraph() {

        int p = 101111; // Big Prime (Hash key1)
        int x = 101; // Small number (Hash key2)
        HashGraph graph = new HashGraph(32, p, x);

        String[] cities = new String[] { "Dublin", "Edinburgh", "Manchester",
                "Copenhagen", "Lisbon", "London", "Berlin", "Prague", "Madrid",
                "Paris", "Vienna", "Budapest", "Geneva", "Milan", "Zurich", "Rome" };
        for (int i = 0; i < 16; i++) {
            graph.addVertex(cities[i]);
        }

        return graph;
    }

    // This is editable test case, but no need to edit
    public static HashGraph connectEdges(HashGraph graph) {
        graph.addEdge("Dublin", "Edinburgh");
        graph.addEdge("Dublin", "London");
        graph.addEdge("Dublin", "Lisbon");
        graph.addEdge("Edinburgh", "Manchester");
        graph.addEdge("Manchester", "London");
        graph.addEdge("Manchester", "Copenhagen");
        graph.addEdge("Copenhagen", "Berlin");
        graph.addEdge("Lisbon", "Madrid");
        graph.addEdge("London", "Paris");
        graph.addEdge("Berlin", "Prague");
        graph.addEdge("Berlin", "Vienna");
        graph.addEdge("Berlin", "Paris");
        graph.addEdge("Prague", "Zurich");
        graph.addEdge("Madrid", "Paris");
        graph.addEdge("Madrid", "Milan");
        graph.addEdge("Madrid", "Geneva");
        graph.addEdge("Vienna", "Zurich");
        graph.addEdge("Budapest", "Rome");
        graph.addEdge("Milan", "Zurich");
        graph.addEdge("Zurich", "Rome");
        return graph;
    }
}
