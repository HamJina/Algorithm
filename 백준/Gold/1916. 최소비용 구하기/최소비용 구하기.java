import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[] distance; // 최단 거리 저장 배열
    public static boolean[] visited; // 노드 방문 여부 표시
    public static ArrayList<Edge>[] list; // 인접리스트
    public static PriorityQueue<Edge> q = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 도시 개수
        int M = Integer.parseInt(br.readLine()); // 버스 개수

        distance = new int[N+1];
        visited = new boolean[N+1];
        list = new ArrayList[N+1];

        // 인접리스트 초기화
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        Arrays.fill(distance, Integer.MAX_VALUE);

        StringTokenizer st;
        // 버스 노선 입력받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 출발 도시
            int b = Integer.parseInt(st.nextToken()); // 도착 도시
            int cost = Integer.parseInt(st.nextToken());
            list[a].add(new Edge(b, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        distance[start] = 0;
        q.add(new Edge(start, 0));

        while (!q.isEmpty()) {
            Edge current = q.poll();
            int c_v = current.vertex;

            if(visited[c_v]) continue; // 이미 방문한 노드라면 넘어감
            visited[c_v] = true;

            for (Edge edge : list[c_v]) {
                int vertex = edge.vertex;
                int weight = edge.weight;

                if(distance[vertex] > distance[c_v] + weight) {
                    distance[vertex] = distance[c_v] + weight;
                    q.add(new Edge(vertex, distance[vertex]));
                }
            }
        }

        System.out.println(distance[end]);
    }

    static class Edge implements Comparable<Edge> {
        int vertex;
        int weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

}
