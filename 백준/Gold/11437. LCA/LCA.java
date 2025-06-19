import java.util.*;

public class Main {
    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            tree[a].add(b);
            tree[b].add(a);
        }

        depth = new int[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        BFS(1);  // 1번 노드를 루트로 하여 BFS 실행

        int M = sc.nextInt();  // 질의 수
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int LCA = executeLCA(a, b);
            System.out.println(LCA);
        }
    }

    // 두 노드의 LCA를 구하는 함수
    static int executeLCA(int a, int b) {
        // depth[b]가 더 크도록 설정
        if (depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        // depth를 같게 맞추기
        while (depth[a] < depth[b]) {
            b = parent[b];
        }

        // 같은 조상이 나올 때까지 위로 이동
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }

    // BFS를 통해 parent와 depth 배열을 채움
    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        int level = 1;
        int now_size = 1;
        int count = 0;

        while (!queue.isEmpty()) {
            int now_node = queue.poll();

            for (int next : tree[now_node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    parent[next] = now_node; // 부모 설정
                    depth[next] = level;     // 깊이 설정
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