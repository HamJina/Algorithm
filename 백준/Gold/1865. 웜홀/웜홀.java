import java.io.*;
import java.util.*;

public class Main {
    static int TC;
    static int N, M, W;
    static int[] distance;
    static List<Edge> edge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());

        for (int t = 0; t < TC; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            distance = new int[N + 1];
            edge = new ArrayList<>();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                edge.add(new Edge(S, E, T));
                edge.add(new Edge(E, S, T)); // 무방향 도로
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                edge.add(new Edge(S, E, -T)); // 웜홀은 단방향 + 음수
            }

            boolean hasCycle = false;
            Arrays.fill(distance, 0); // 모든 정점이 시작점이 될 수 있으므로 0

            // 벨만-포드 N-1번
            for (int i = 1; i < N; i++) {
                for (Edge e : edge) {
                    if (distance[e.E] > distance[e.S] + e.T) {
                        distance[e.E] = distance[e.S] + e.T;
                    }
                }
            }

            // N번째에도 갱신된다면 → 음수 사이클
            for (Edge e : edge) {
                if (distance[e.E] > distance[e.S] + e.T) {
                    hasCycle = true;
                    break;
                }
            }

            System.out.println(hasCycle ? "YES" : "NO");
        }
    }
}

class Edge {
    int S, E, T;

    public Edge(int s, int e, int t) {
        this.S = s;
        this.E = e;
        this.T = t;
    }
}
