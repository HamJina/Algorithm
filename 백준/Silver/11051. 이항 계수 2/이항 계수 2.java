import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        if (K > N) {
            System.out.println(0);
            return;
        }

        int[][] dp = new int[N + 1][K + 1];

        for (int n = 0; n <= N; n++) {
            for (int k = 0; k <= Math.min(n, K); k++) {
                if (k == 0 || k == n) {
                    dp[n][k] = 1;
                } else {
                    dp[n][k] = (dp[n - 1][k - 1] + dp[n - 1][k]) % MOD;
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
