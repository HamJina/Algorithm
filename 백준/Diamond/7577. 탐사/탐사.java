import java.util.*;

public class Main {
    static class Edge {
        int from, to, weight;
        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    static int k, n;
    static List<Edge> edges = new ArrayList<>();
    static long[] dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int r = sc.nextInt();
            // Add both directions
            edges.add(new Edge(x - 1, y, r));
            edges.add(new Edge(y, x - 1, -r));
        }

        // Add default constraints: ai <= ai+1 and ai+1 <= ai + 1
        for (int i = 1; i <= k; i++) {
            edges.add(new Edge(i - 1, i, 1));   // ai+1 <= ai + 1
            edges.add(new Edge(i, i - 1, 0));   // ai <= ai+1
        }

        dist = new long[k + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        if (!bellmanFord()) {
            System.out.println("NONE");
        } else {
            StringBuilder ans = new StringBuilder();
            for (int i = 1; i <= k; i++) {
                if (dist[i] != dist[i - 1]) {
                    ans.append("#");
                } else {
                    ans.append("-");
                }
            }
            System.out.println(ans);
        }
    }

    static boolean bellmanFord() {
        dist[0] = 0;
        for (int i = 0; i <= k; i++) {
            boolean updated = false;
            for (Edge edge : edges) {
                if (dist[edge.from] != Long.MAX_VALUE && dist[edge.to] > dist[edge.from] + edge.weight) {
                    dist[edge.to] = dist[edge.from] + edge.weight;
                    updated = true;
                    if (i == k) return false; // Negative cycle detected
                }
            }
            if (!updated) break;
        }
        return true;
    }
}
