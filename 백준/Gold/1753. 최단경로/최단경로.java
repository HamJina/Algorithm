import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int V, E, K;
    public static int[] distance;
    public static boolean[] visited;
    public static ArrayList<Edge>[] list;
    public static PriorityQueue<Edge> q = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        distance = new int[V + 1];
        visited = new boolean[V + 1];
        list = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        Arrays.fill(distance, Integer.MAX_VALUE); // 간결하게 초기화

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v, w));
        }

        q.add(new Edge(K, 0));
        distance[K] = 0;

        while (!q.isEmpty()) {
            Edge current = q.poll();
            int c_v = current.vertex;

            if (visited[c_v]) continue;
            visited[c_v] = true;

            for (Edge tmp : list[c_v]) { // 향상된 for문
                int next = tmp.vertex;
                int value = tmp.value;

                if (distance[next] > distance[c_v] + value) {
                    distance[next] = distance[c_v] + value;
                    q.add(new Edge(next, distance[next]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }
}

// Edge 클래스를 Comparable로 수정
class Edge implements Comparable<Edge> {
    int vertex, value;

    Edge(int vertex, int value) {
        this.vertex = vertex;
        this.value = value;
    }

    @Override
    public int compareTo(Edge e) {
        return this.value - e.value; // 거리가 작은 순서대로 우선
    }
}
