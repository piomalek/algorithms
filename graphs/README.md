# Topological Sort

After [wiki](https://en.wikipedia.org/wiki/Topological_sorting):
>*In computer science, a topological sort or topological ordering of a directed graph is a
>linear ordering of its vertices such that for every directed edge uv from vertex u to vertex v,
>u comes before v in the ordering.*
>
>*For instance, the vertices of the graph may represent tasks to be performed, and the edges may
>represent constraints that one task must be performed before another; in this application,
>a topological ordering is just a valid sequence for the tasks.
>A topological ordering is possible if and only if the graph has no directed cycles, that is,
>if it is a directed acyclic graph (DAG). Any DAG has at least one topological ordering, and algorithms
>are known for constructing a topological ordering of any DAG in linear time.*

Here I implemented two ways of doing that one using in degree hashmap (counting number of incoming edges per vertex)
and dfs using stack.

**Indegree algorigthm:**
- Initialize a queue, Q to keep a track of all the nodes in the graph with 0 in-degree.
 - Iterate over all the edges in the input and create an graph and also a map of node v/s in-degree.
 - Add all the nodes with 0 in-degree to Q.
 - The following steps are to be done until the Q becomes empty.
   - Pop a node from the Q. Let's call this node, N.
   - For all the neighbors of this node, N, reduce their in-degree by 1. If any of the nodes' in-degree reaches 0, add it to the Q.
   - Add the node N to the list maintaining topologically sorted order.

**DFS algorithm:**
- Initialize a stack S that will contain the topologically sorted order of the vertices in our graph.
  - Construct the graph using the edge pairs given in the input.
  - For each of the nodes in our graph, we will run a depth first search in case that node was not already visited in some other node's DFS traversal.
  - Suppose we are executing the depth first search for a node N. We will recursively traverse all of the neighbors of node N which have not been processed before.
  - Once the processing of all the neighbors is done, we will add the node N to the stack. We are making use of a stack to simulate the ordering we need. When we add the node N to the stack, all the nodes that require the node N as a prerequisites (among others) will already be in the stack.
  - Once all the nodes have been processed, we will simply return the nodes as they are present in the stack from top to bottom.

Coding problem with detailed description: [https://leetcode.com/problems/course-schedule-ii](https://leetcode.com/problems/course-schedule-ii)

# Dijkstra
Coding problem with detailed description: [https://leetcode.com/articles/the-maze-ii/](https://leetcode.com/articles/the-maze-ii/)

# Euler Path

Description: https://math.stackexchange.com/questions/1871065/euler-path-for-directed-graph
Coding problem: https://leetcode.com/problems/reconstruct-itinerary/