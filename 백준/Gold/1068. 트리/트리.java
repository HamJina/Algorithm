import java.util.*;

public class Main {
    static int N; // 노드 개수
    static ArrayList<Integer>[] tree;// 인접 리스트
    static int[] parent;
    static boolean[] deleted;// 삭제 여부

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        deleted = new boolean[N];
        parent = new int[N];
        tree = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
            parent[i] = -1;
        }

        for (int i = 0; i < N; i++) {
            int m = sc.nextInt();
            parent[i] = m;
            if (m != -1) {
                tree[m].add(i);
            }
        }

        int D = sc.nextInt();

        // 삭제 노드가 루트이면 트리가 완전히 삭제되는 경우
        if (D == 0 && parent[D] == -1) {
            System.out.println(0);
            return;
        }

        // 삭제 노드가 부모의 자식 리스트에 있으면 삭제
        int p = parent[D];
        if (p != -1) {
            tree[p].remove((Integer) D);
        }

        // 삭제 노드 및 자식 노드 삭제
        DFS(D);

        int result = 0;
        for (int i = 0; i < N; i++) {
            if (!deleted[i]) {
                if (tree[i].isEmpty()) result++;
            }
        }

        System.out.println(result);
    }

    static void DFS(int node) {
        deleted[node] = true;

        for (int child : tree[node]) {
            DFS(child);
        }
        // 삭제 노드 자식 리스트 초기화(안 해도 결과에 영향 없지만 깔끔)
        tree[node].clear();
    }
}
