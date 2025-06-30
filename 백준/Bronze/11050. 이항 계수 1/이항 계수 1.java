import java.util.Scanner;

public class Main {
    static int N, K;
    static int[][] D;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // n
        K = sc.nextInt(); // r

        D = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    D[i][j] = 1;
                } else {
                    D[i][j] = D[i - 1][j - 1] + D[i - 1][j];
                }
            }
        }

        System.out.println(D[N][K]);
    }
}