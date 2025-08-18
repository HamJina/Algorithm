import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static int[] friendCost;
    static int[] minCost;
    static  int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 친구 관계수
        k = Integer.parseInt(st.nextToken()); // 가지고 있는 돈

        // 친구 비 저장 배열
        friendCost = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            friendCost[i] = Integer.parseInt(st.nextToken());
        }

        // 대표 노드 저장 배열
        parent = new int[N+1];
        minCost = new int[N+1];

        // 대표 노드 저장 배열 초기화
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // 친구 관계수를 입력받고 해당 친구 번호들에 대해 union 연산을 한다.
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());

            if(f2 < f1) union(f2, f1);
            else union(f1, f2);
        }

        // 루트별 최소비 계산
        final int INF = 1_000_000_000;
        int[] minCost = new int[N + 1];
        Arrays.fill(minCost, INF);

        for (int i = 1; i <= N; i++) {
            int r = find(i); // 반드시 find로 루트 보정
            minCost[r] = Math.min(minCost[r], friendCost[i]);
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if (i == find(i) && minCost[i] != INF) sum += minCost[i]; // 대표만 합산
        }

        if (sum <= k) System.out.println(sum);
        else System.out.println("Oh no");


    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            parent[b] = a;
        }
    }

    public static int find(int a) {
        // 대표 노드 반환 함수
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }
}
