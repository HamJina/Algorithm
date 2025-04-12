import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 예시 8 8
1 7
3 7
4 7
3 4
4 6
3 5
0 4
2 7*/

public class Main {
    static ArrayList<Integer>[] A; //그래프 데이터 저장 인접 리스트
    static boolean visited[]; //방문 기록 저장 배열
    static int depth = 0;

    public static void main(String[] args) throws IOException {
        //노드 개수 N, 친구관계수 M을 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //A와 visited배열 초기화하기
        A = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<>();
        }

        //M만큼 반복하면서 친구관계 인접 리스트에 저장하기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            A[S].add(E);
            A[E].add(S);
        }

        //0~N-1번 요소에 대해 반복문을 돌면서 DFS실행 만약 어느 요소에서 깊이가 5까지 진행되었다면 멈추고 1을 출력
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited, false); // 매 DFS 시작 전에 방문 배열 초기화
            DFS(i, 1);
            if (depth == 5) break;
        }


        if(depth >= 5) System.out.println(1);
        else System.out.println(0);

    }

    //DFS에 대한 코드
    static void DFS(int v, int currentDepth) {
        if (currentDepth == 5) {
            depth = 5;
            return;
        }

        visited[v] = true;

        for (Integer i : A[v]) {
            if (!visited[i]) {
                DFS(i, currentDepth + 1);
                if (depth == 5) return; // 깊이 5 찾았으면 바로 return
            }
        }

        visited[v] = false; // 백트래킹을 위해 방문 표시 해제
    }

}