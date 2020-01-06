import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {

    /**
     * Dijkstra algorithm implementation for graph with nodes called 0..N represented as
     * adjacency matrix.
     *
     * @param graph - graph[s][t] represents length of the edge from s to t. 0 represents no connection
     * @param source -> number of the starting node
     * @return - distance matrix where distance[n] represents shortest path from source to n
     */
    private static int[] dijkstra(int[][] graph, int source, int[] distance, int[] parent) {
        int N = graph.length;
        // elements -> {node, distance from source}
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        priorityQueue.offer(new int[]{source, 0});

        while(!priorityQueue.isEmpty()) {

            int[] nodeArr = priorityQueue.poll();
            int node = nodeArr[0];
            int dist = nodeArr[1];

            //System.out.println(String.format("%d->%d - dist[%d] = %d", source, node, node, dist));
            //System.out.println(Arrays.toString(distance));

            // we have already found better distance
            if(distance[node] < dist)
                continue;

            // go through nodes children, calculating min distance and adding them to the queue
            for(int i = 0; i < N; ++i) {
                //if(graph[node][i] != 0)
                //    System.out.println(String.format("\trelaxing edge %d->%d - dist[%d] = %d vs edge(%d, %d) = %d + %d",
                //        node, i, i, distance[i], node, i, graph[node][i], dist));
                if(graph[node][i] != 0 && distance[i] > graph[node][i] + dist) {
                    distance[i]  = graph[node][i] + dist;
                    parent[i] = node;
                    priorityQueue.offer(new int[]{i, distance[i]});
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        int source = 0;
        int graph[][] = new int[][] {
                { 0,  4, 0,  0,  0,  0, 0,  8, 0 },
                { 4,  0, 8,  0,  0,  0, 0, 11, 0 },
                { 0,  8, 0,  7,  0,  4, 0,  0, 2 },
                { 0,  0, 7,  0,  9, 14, 0,  0, 0 },
                { 0,  0, 0,  9,  0, 10, 0,  0, 0 },
                { 0,  0, 4, 14, 10,  0, 2,  0, 0 },
                { 0,  0, 0,  0,  0,  2, 0,  1, 6 },
                { 8, 11, 0,  0,  0,  0, 1,  0, 7 },
                { 0,  0, 2,  0,  0,  0, 6,  7, 0 }
        };
        int N = graph.length;
        // create array holding all the distances from source
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        int[] parent = new int[N];
        Arrays.fill(parent, -1);
        parent[source] = source;

        dijkstra(graph, source, distance, parent);

        // Should print: paths from node 0: [0, 4, 12, 19, 21, 11, 9, 8, 14]
        System.out.println(String.format("Paths from node %d: %s", source, Arrays.toString(distance)));
        for(int i = 0; i < N; ++i) {
            StringBuffer sb = new StringBuffer();
            int n = i;
            while(n != source) {
                sb.insert(0, "" + n);
                sb.insert(0, "->");
                n = parent[n];
            }
            sb.insert(0, "" + source);
            System.out.println(String.format("\tpath %d->%d: %s", source, i, sb.toString()));
        }

        return;
    }
}

// Should print: paths from node 0: [0, 4, 12, 19, 21, 11, 9, 8, 14]
