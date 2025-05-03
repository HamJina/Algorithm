import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parent;
    static int[] travel;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 도시 수
        int M = Integer.parseInt(br.readLine()); // 여행 계획에 속한 도시들의 수

        parent = new int[N+1];
        travel = new int[M];

        // parent 초기화
        for (int i = 1; i < N; i++) {
            parent[i] = i;
        }

        // 연결 관계
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // i가 누구랑 연결된건지 확인
            for (int j = 1; j <= N; j++) {
                int target = Integer.parseInt(st.nextToken());
                if(target == 1) union(i, j);
            }
        }

        // 여행 계획 입력받기 (여행 계획 숫자들의 대표 노드가 모두 같아야 함)
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            travel[i] = Integer.parseInt(st.nextToken());
        }

        if(checkSame(travel)) System.out.println("YES");
        else System.out.println("NO");
    }

    static void union(int i, int j) {
        i = find(i);
        j = find(j);

        if(i != j) {
            parent[j] = i;
        }
    }

    static int find(int a) {
        if(parent[a] == a) // a의 대표노드가 자기자신이면 a값 return
            return a;
        else return parent[a] = find(parent[a]);
    }

    static boolean checkSame(int[] travel) {
        boolean isPossible = true;
        int value = parent[travel[0]];
        for (int i : travel) {
            if (find(i) != value) {
                isPossible = false;
            }
            value = parent[i];
        }

        return isPossible;
    }
}