import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T, N;
    static ArrayList<Integer>[] tree;
    static int[] depth; // 노드의 깊이 정보 저장
    static int[] parent; // 노드의 부모노드 정보 저장
    static boolean[] visited; // 노드 탐색시 방문여부 저장
    static int root; // 최상위 노드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int i = 0; i < T; i++) { // 테스트 케이스 개수만큼 반복
            N = Integer.parseInt(br.readLine()); // 노드 개수

            // 배열 초기화
            depth = new int[N+1];
            parent = new int[N+1];
            visited = new boolean[N+1];
            tree = new ArrayList[N+1];

            for (int j = 0; j <= N; j++) {
                tree[j] = new ArrayList<Integer>();
            }

            for (int j = 0; j < N - 1; j++) { // N-1개의 간선 정보 입력받기
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()); // 부모
                int b = Integer.parseInt(st.nextToken()); // 자식

                // 일단 a로 초기화, 단 a가 누군가의 자식으로 나오면 그 부모가 최상위 노드로 업데이트 된다.
                if(j == 0 || root == b) root = a;

                parent[b] = a; // b의 부모는 a이다.
                tree[a].add(b);
            }

            BFS(root); // root 노드에서 시작하여 각 노드의 depth 채우기

            // 테스트 마지막줄에 LCA 구하기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 부모
            int b = Integer.parseInt(st.nextToken()); // 자식
            System.out.println(executeLCA(a, b));
        }

    }

    // LCA 구현 함수
    public static int executeLCA(int a, int b) {
        if(depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        // depth 맞추기
        while(depth[a] < depth[b]) {
            b = parent[b];
        }

        // 깊이를 맞춘후 같이 위로 올라가면서 처음으로 같아지는게 최소 공통 조상
        while(a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }

    public static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        depth[node] = 0; // 루트 노드의 깊이는 0

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int child : tree[current]) {
                if (!visited[child]) {
                    visited[child] = true;
                    parent[child] = current;
                    depth[child] = depth[current] + 1;
                    queue.add(child);
                }
            }
        }
    }
}
