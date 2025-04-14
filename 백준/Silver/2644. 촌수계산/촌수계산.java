import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int P1;
    static int P2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        P1 = Integer.parseInt(st.nextToken());
        P2 = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            A[S].add(E);
            A[E].add(S);
        }

        int dfs = DFS(P1, 0);
        System.out.println(dfs);

    }

    static int DFS(int p, int currentDepth) {
        visited[p] = true;

        if (p == P2) {
            return currentDepth;
        }

        for (Integer i : A[p]) {
            if (!visited[i]) {
                int result = DFS(i, currentDepth + 1);
                if (result != -1) {
                    return result;
                }
            }
        }

        return -1;
    }
}