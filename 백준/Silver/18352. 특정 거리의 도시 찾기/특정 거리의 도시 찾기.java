import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, X;
    static int[] distance; // 최단거리 정보 배열
    static boolean[] visited; // 노드 방문 여부 배열
    static ArrayList<Edge>[] list;
    static PriorityQueue<Edge> q = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        // 배열 크기 초기화
        distance = new int[N+1];
        visited = new boolean[N+1];
        list = new ArrayList[N+1];

        // list 초기화
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        // M개의 연결 정보 입력받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v, 1));
        }

        // 최단 거리 정보 배열 큰 값으로 초기화
        Arrays.fill(distance, Integer.MAX_VALUE);

        // 시작 노드의 distance값을 0으로 초기화 & 시작 노드 우선순위 큐에 삽입하기
        distance[X] = 0;
        q.add(new Edge(X, distance[X]));

        while(!q.isEmpty()) {
            Edge next = q.poll();
            int next_vertex = next.vertex;

            // 방문 표시하기
            if(visited[next_vertex]) continue;
            visited[next_vertex] = true;

            // 인접 노드들의 최단 거리 갱신하기
            for (Edge edge: list[next_vertex]) {
                if(distance[edge.vertex] > distance[next_vertex] + 1) {
                    distance[edge.vertex] = distance[next_vertex] + 1;
                    q.add(new Edge(edge.vertex, distance[edge.vertex]));
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if(distance[i] == K) sb.append(i + "\n");
        }
        String result = sb.toString();

        if (result.length() == 0) System.out.println(-1);
        else System.out.println(result);
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