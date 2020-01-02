import java.util.*;

public class TopologicalSort {

    /**
     * Algorithm:
     *
     * - Initialize a stack S that will contain the topologically sorted order of the vertices in our graph.
     * - Construct the graph using the edge pairs given in the input.
     * - For each of the nodes in our graph, we will run a depth first search in case that node was
     *   not already visited in some other node's DFS traversal.
     * - Suppose we are executing the depth first search for a node N. We will recursively traverse all
     *   of the neighbors of node N which have not been processed before.
     * - Once the processing of all the neighbors is done, we will add the node N to the stack. We are making
     *   use of a stack to simulate the ordering we need. When we add the node N to the stack, all the nodes that require
     *   the node N as a prerequisites (among others) will already be in the stack.
     * - Once all the nodes have been processed, we will simply return the nodes as they are present in the stack from top to bottom.
     *
     * @param n - number of vertices
     * @param edges - list of edges, eg: [1,2], [2,3]
     * @return list of vertices sorted in topological order
     */
    public static String[] topologicalSortDfs(int n, String[][] edges) {
        return null;
    }

    /**
     * Algorithm
     *
     * - Initialize a queue, Q to keep a track of all the nodes in the graph with 0 in-degree.
     * - Iterate over all the edges in the input and create an graph and also a map of node v/s in-degree.
     * - Add all the nodes with 0 in-degree to Q.
     * - The following steps are to be done until the Q becomes empty.
     *   - Pop a node from the Q. Let's call this node, N.
     *   - For all the neighbors of this node, N, reduce their in-degree by 1.
     *     If any of the nodes' in-degree reaches 0, add it to the Q.
     *   - Add the node N to the list maintaining topologically sorted order.
     *
     * @param n - number of vertices
     * @param edges - list of edges, eg: [1,2], [2,3]
     * @return list of vertices sorted in topological order
     */
    public static String[] topologicalSortInDegree(int n, String[][] edges) {
        boolean[] visited = new boolean[n];

        Map<String, Set<String>> graph = new HashMap<>();
        Set<String> vertices = new HashSet<>();
        Map<String, Integer> incoming = new HashMap<>();

        //build graph
        for(String[] edge : edges) {
            String from = edge[1];
            String to = edge[0];
            graph.put(from, graph.computeIfAbsent(from, l -> new HashSet<String>())).add(to);
            incoming.put(to, incoming.getOrDefault(to, 0) + 1);
            vertices.add(from);
            vertices.add(to);
        }

        // Queue storing vertices with number of incoming edges == 0
        Queue<String> queue = new LinkedList<>();

        // Resulting topological order
        String[] result = new String[n];

        // for each vertex with incoming edges == 0 -> add to queue
        for(String vertex : vertices){
            if(!incoming.containsKey(vertex))
                queue.add(vertex);
        }

        // take vertex with no incoming edges and add it to the result
        // then go through its children, and decrease the edge count
        int idx = 0;
        while(!queue.isEmpty()) {
            String curr = queue.poll();
            result[idx++] = curr;
            if(graph.containsKey(curr)){
                for(String next : graph.get(curr)){
                    incoming.put(next, incoming.getOrDefault(next, 0) - 1);
                    if(incoming.get(next) == 0){
                        queue.add(next);
                    }
                }
            }
        }

        return idx == n ? result : new String[0];
    }

    public static void main(String[] args) {
        String[] path = topologicalSort(4, new String[][]{{"b","a"},{"c","a"},{"d","b"},{"d","c"}});
        System.out.println(Arrays.toString(path));
        return;
    }
}
