import java.util.Arrays;

// Purpose of the union find algorithm is to find sets of joint or disjoint objects quickly,
// without caring how exactly they are connected
public class UnionFind {
    // id table - node i and j are connected if their ids, or their parent node ids are the same
    // initially in empty graph, all nodes have id equal to the node number id[node] = node
    // after each union, which reflects connecting two nodes, one of the nodes points to the other id
    // so for example in graph with three nodes initially id table looks as follows: [0, 1, 2].
    // after union(0, 1) -> it becomes [1, 1, 2]
    private static int[] id;

    //initializes the id structure, and sets id[node] = node
    public static void init(int n) {
        id = new int[n];
        for(int i = 0; i < n; ++i) {
            id[i] = i;
        }
    }

    // connects root of one tree to the other tree
    public static void union(int source, int target) {
        id[root(source)] = root(target);
    }

    // returns true if source and target are connected
    public static boolean find(int source, int target) {
        return root(source) == root(target);
    }

    // looks for the root of the id tree and additionally does path compression,
    // so the height of the tree is minimal
    private static int root(int n) {
        while(id[n] != n) {
            id[n] = id[id[n]];  // path compression (it flattens out the tree)
            n = id[n];
        }

        return n;
    }

    public static void main(String[] args) {
        init(10);
        System.out.println(String.format("init(%d), %s", 10, Arrays.toString(id)));
        union(1,2);
        System.out.println(String.format("union(%d, %d), %s", 1, 2, Arrays.toString(id)));
        union(3, 4);
        System.out.println(String.format("union(%d, %d), %s", 3, 4, Arrays.toString(id)));

        System.out.println(String.format("find(%d, %d) = %b, %s", 1, 3, find(1,3), Arrays.toString(id)));

        union(2,3);
        System.out.println(String.format("union(%d, %d), %s", 2, 3, Arrays.toString(id)));

        union(1,3);
        System.out.println(String.format("union(%d, %d), %s", 1, 3, Arrays.toString(id)));

        System.out.println(String.format("find(%d, %d) = %b, %s", 1, 3, find(1,3), Arrays.toString(id)));

        union(0,1);
        System.out.println(String.format("union(%d, %d), %s", 0, 1, Arrays.toString(id)));
        union(5,6);
        System.out.println(String.format("union(%d, %d), %s", 5, 6, Arrays.toString(id)));
        union(7,8);
        System.out.println(String.format("union(%d, %d), %s", 7, 8, Arrays.toString(id)));
        union(8,9);
        System.out.println(String.format("union(%d, %d), %s", 8, 9, Arrays.toString(id)));
        union(6,7);
        System.out.println(String.format("union(%d, %d), %s", 6, 7, Arrays.toString(id)));
        System.out.println(String.format("find(%d, %d) = %b, %s", 5, 9, find(5,9), Arrays.toString(id)));
        System.out.println(String.format("find(%d, %d) = %b, %s", 1, 9, find(1,9), Arrays.toString(id)));
    }


}
