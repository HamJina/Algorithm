import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] graph;
    static final int INF = 1000; // 충분히 큰 값으로 초기화

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N + 1][N + 1];

        // 거리 배열 초기화
        for (int i = 1; i <= N; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }

        // 간선 입력 (무방향)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            graph[S][E] = 1;
            graph[E][S] = 1;
        }

        // Floyd-Warshall 알고리즘
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        // 케빈 베이컨 수 계산
        int answer = 0;
        int minSum = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                sum += graph[i][j];
            }
            if (sum < minSum) {
                minSum = sum;
                answer = i;
            }
        }

        // 최솟값을 갖는 사람 번호 출력
        System.out.println(answer);
    }
}
