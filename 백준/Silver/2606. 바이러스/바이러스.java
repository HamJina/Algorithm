import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        // A배열 초기화하기
        for (int i = 0; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        //인접리스트 채우기
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }

        DFS(1); //1부터 DFS 실행하기
        System.out.println(count - 1);
    }

    static void DFS(int v) {
        count++;

        if(visited[v]) {
           return;
        }

        visited[v] = true;
        for (Integer i : A[v]) {
            if(!visited[i]) {
                DFS(i);
            }
        }
    }
}