import java.io.*;
import java.util.*;

public class Main {
    static int[][] A;
    static List<Integer> result = new ArrayList<>();
    static int count;
    static int M;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    A[j][k] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(A[i][j] == 0) {
                    count = 1;
                    DFS(i, j);
                    result.add(count);
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (Integer i : result) {
            System.out.print(i + " ");
        }
    }

    static void DFS(int i, int j) {
        if(A[i][j] == 1) {
            return;
        }

        A[i][j] = 1;

        if(i+1 < N && A[i+1][j] == 0) {
            count++;
            DFS(i+1, j);
        }
        if(i-1 >= 0 && A[i-1][j] == 0) {
            count++;
            DFS(i-1, j);
        }
        if(j+1 < M && A[i][j+1] == 0) {
            count++;
            DFS(i, j+1);
        }
        if(j-1 >= 0 && A[i][j-1] == 0) {
            count++;
            DFS(i, j-1);
        }
    }

}