package dataStructure.graph;

import java.util.LinkedList;

/**
 * 图（邻接表形式）
 *
 * @author Shadowalker
 */
public class GraphDemo {
    private int size;
    private Vertex[] vertexes;
    private LinkedList<Integer> adj[];

    GraphDemo(int size) {
        this.size = size;
        // 初始化顶点和邻接矩阵
        vertexes = new Vertex[size];
        adj = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            vertexes[i] = new Vertex(i);
            adj[i] = new LinkedList();
        }
    }

    /**
     * 深度优先遍历
     */
    public static void dfs(GraphDemo graph, int start, boolean[] visited) {
        System.out.println(graph.vertexes[start].data);
        visited[start] = true;
        for (int index : graph.adj[start]) {
            if (!visited[index]) {
                dfs(graph, index, visited);
            }
        }
    }

    /**
     * 广度优先遍历
     */
    public static void bfs(GraphDemo graph, int start, boolean[] visited, LinkedList<Integer> queue) {
        queue.offer(start);
        while (!queue.isEmpty()) {
            int front = queue.poll();
            if (visited[front]) {
                continue;
            }
            System.out.println(graph.vertexes[front].data);
            visited[front] = true;
            for (int index : graph.adj[front]) {
                queue.offer(index);
            }
        }
    }

    public static void main(String[] args) {
        GraphDemo graph = new GraphDemo(6);
        graph.adj[0].add(1);
        graph.adj[0].add(2);
        graph.adj[0].add(3);

        graph.adj[1].add(0);
        graph.adj[1].add(3);
        graph.adj[1].add(4);

        graph.adj[2].add(0);

        graph.adj[3].add(0);
        graph.adj[3].add(1);
        graph.adj[3].add(4);
        graph.adj[3].add(5);

        graph.adj[4].add(1);
        graph.adj[4].add(3);
        graph.adj[4].add(5);

        graph.adj[5].add(3);
        graph.adj[5].add(4);

        System.out.println("图的深度优先遍历：");
        dfs(graph, 0, new boolean[graph.size]);

        System.out.println("图的广度优先遍历：");
        bfs(graph, 0, new boolean[graph.size], new LinkedList<Integer>());
    }
}

/**
 * 图的顶点
 */
class Vertex {

    int data;

    Vertex(int data) {
        this.data = data;
    }
}

