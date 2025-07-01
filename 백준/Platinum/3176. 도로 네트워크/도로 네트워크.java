import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int node;
        int weight;

        Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static ArrayList<Node>[] tree;
    static int[] depth;
    static int[][] parent;
    static int[][] minLength;
    static int[][] maxLength;
    static boolean[] visited;
    static int N, K, kMax;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        N = Integer.parseInt(br.readLine());

        // 트리 초기화
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        depth = new int[N + 1];
        visited = new boolean[N + 1];

        // kMax 계산 (log2(N))
        int temp = 0;
        while ((1 << temp) <= N) temp++;
        kMax = temp;

        parent = new int[kMax][N + 1];
        minLength = new int[kMax][N + 1];
        maxLength = new int[kMax][N + 1];

        // 간선 입력
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree[a].add(new Node(b, weight));
            tree[b].add(new Node(a, weight));
        }

        // BFS로 depth, parent[0], min/maxLength[0] 초기화
        bfs(1);

        // DP로 parent, min/maxLength 채우기
        for (int k = 1; k < kMax; k++) {
            for (int n = 1; n <= N; n++) {
                int mid = parent[k - 1][n];
                if (mid != 0) {
                    parent[k][n] = parent[k - 1][mid];
                    minLength[k][n] = Math.min(minLength[k - 1][n], minLength[k - 1][mid]);
                    maxLength[k][n] = Math.max(maxLength[k - 1][n], maxLength[k - 1][mid]);
                }
            }
        }

        // 쿼리 수 입력
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            executeLCA(d, e);
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);
        depth[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (Node next : tree[current]) {
                if (!visited[next.node]) {
                    visited[next.node] = true;
                    depth[next.node] = depth[current] + 1;
                    parent[0][next.node] = current;
                    minLength[0][next.node] = next.weight;
                    maxLength[0][next.node] = next.weight;
                    queue.offer(next.node);
                }
            }
        }
    }

    static void executeLCA(int a, int b) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // 깊이 맞추기
        if (depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (int k = kMax - 1; k >= 0; k--) {
            if (depth[b] - depth[a] >= (1 << k)) {
                min = Math.min(min, minLength[k][b]);
                max = Math.max(max, maxLength[k][b]);
                b = parent[k][b];
            }
        }

        // 같은 노드면 종료
        if (a == b) {
            System.out.println(min + " " + max);
            return;
        }

        // LCA를 향해 올라가며 거리 비교
        for (int k = kMax - 1; k >= 0; k--) {
            if (parent[k][a] != 0 && parent[k][a] != parent[k][b]) {
                min = Math.min(min, Math.min(minLength[k][a], minLength[k][b]));
                max = Math.max(max, Math.max(maxLength[k][a], maxLength[k][b]));
                a = parent[k][a];
                b = parent[k][b];
            }
        }

        // 마지막 1단계 조상 처리
        min = Math.min(min, Math.min(minLength[0][a], minLength[0][b]));
        max = Math.max(max, Math.max(maxLength[0][a], maxLength[0][b]));

        System.out.println(min + " " + max);
    }
}
