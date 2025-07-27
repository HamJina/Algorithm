import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            System.out.println(combination(N, M));
        }
    }

    public static int combination(int N, int M) {
        int[][] p = new int[M+1][M+1];

        for (int i = 0; i <= M; i++) {
            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i)
                    p[i][j] = 1;
                else p[i][j] = p[i-1][j] + p[i-1][j-1];
            }
        }
        return p[M][N];
    }
}
