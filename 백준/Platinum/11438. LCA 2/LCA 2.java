import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] tree;
    static int[][] parent;
    static int[] depth;
    static boolean[] visited;
    static int kmax;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 노드 수
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<Integer>();
        }

        // 인접 리스트에 그래프 데이터 저장
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree[s].add(e);
            tree[e].add(s);
        }

        depth = new int[N + 1];
        visited = new boolean[N + 1];
        int temp = 1;
        kmax = 0;
        while (temp <= N) {
            temp <<= 1;
            kmax++;
        }

        parent = new int[kmax + 1][N + 1];
        BFS(1); // depth를 BFS로 구하기

        // DP로 전체 부모 관계 구하기
        for (int k = 1; k <= kmax; k++) {
            for (int n = 1; n <= N; n++) {
                parent[k][n] = parent[k - 1][parent[k - 1][n]];
            }
        }

        int M = Integer.parseInt(br.readLine()); // 질의 수
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int LCA = executeLCA(a, b);
            System.out.println(LCA);
        }
    }

    static int executeLCA(int a, int b) {
        // 더 깊은 쪽을 b로 설정
        if (depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        // depth 맞추기
        for (int k = kmax; k >= 0; k--) {
            if (Math.pow(2, k) <= depth[b] - depth[a]) {
                if (depth[a] <= depth[parent[k][b]]) {
                    b = parent[k][b];
                }
            }
        }

        // 조상이 같으면 반환
        if (a == b) return a;

        // 조상이 다르면 동시에 위로 올라감
        for (int k = kmax; k >= 0; k--) {
            if (parent[k][a] != parent[k][b]) {
                a = parent[k][a];
                b = parent[k][b];
            }
        }

        // 공통 부모 반환
        return parent[0][a];
    }

    // BFS로 depth와 parent[0] 채우기
    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        int level = 1;
        int count = 0;
        int now_size = 1;

        while (!queue.isEmpty()) {
            int now_node = queue.poll();
            for (int next : tree[now_node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    parent[0][next] = now_node; // 부모 저장
                    depth[next] = level; // 깊이 저장
                }
            }
            count++;
            if (count == now_size) {
                count = 0;
                now_size = queue.size();
                level++;
            }
        }
    }
}