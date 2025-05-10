import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] distance;
    static boolean[] visited;
    static ArrayList<Edge>[] list; // 인접 리스트(양방향)
    static PriorityQueue<Edge> q = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        distance = new int[N+1];
        visited = new boolean[N+1];
        list = new ArrayList[N+1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A_i = Integer.parseInt(st.nextToken());
            int B_i = Integer.parseInt(st.nextToken());
            int C_i = Integer.parseInt(st.nextToken());

            list[A_i].add(new Edge(B_i, C_i));
            list[B_i].add(new Edge(A_i, C_i));
        }

        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[1] = 0;
        q.add(new Edge(1, 0));

        while(!q.isEmpty()) {
            Edge next = q.poll();
            int n_v = next.vertex;

            if(visited[n_v]) continue;
            visited[n_v] = true;

            for (Edge edge : list[n_v]) {
                int e_v = edge.vertex;
                if(distance[e_v] > distance[n_v] + edge.value) {
                    distance[e_v] = distance[n_v] + edge.value;
                    q.add(new Edge(e_v, distance[e_v]));
                }
            }
        }

        System.out.println(distance[N]);
    }
}

class Edge implements Comparable<Edge>{
    int vertex;
    int value;

    public Edge(int vertex, int value) {
        this.vertex = vertex;
        this.value = value;
    }

    @Override
    public int compareTo(Edge o) {
        return this.value - o.value;
    }
}