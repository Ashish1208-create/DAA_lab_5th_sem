import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // V = number of vertices
        // E = number of edges
        int V = sc.nextInt();
        int E = sc.nextInt();

        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Input edges: u v weight
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int wt = sc.nextInt();

            graph.get(u).add(new int[]{v, wt});
            graph.get(v).add(new int[]{u, wt});
        }

        // Source
        int src = sc.nextInt();

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) ->
                Integer.compare(a[1], b[1]));

        dist[src] = 0;
        pq.offer(new int[]{src, 0});

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int node = curr[0];
            int d = curr[1];

            // Ignore outdated entry
            if (d > dist[node]) {
                continue;
            }

            for (int[] edge : graph.get(node)) {

                int next = edge[0];
                int wt = edge[1];

                // Relaxation
                if (d + wt < dist[next]) {

                    dist[next] = d + wt;

                    pq.offer(new int[]{
                        next,
                        dist[next]
                    });
                }
            }
        }

        // Print shortest distances
        for (int i = 0; i < V; i++) {
            System.out.print(dist[i] + " ");
        }

        sc.close();
    }
}