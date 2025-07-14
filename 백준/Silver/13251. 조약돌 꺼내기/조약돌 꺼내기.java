import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static double combination(int n, int k) {
        if (k > n) return 0.0;
        if (k == 0 || k == n) return 1.0;

        // 팩토리얼 대신 곱셈 나눗셈으로 직접 계산 (오버플로 방지)
        double result = 1.0;
        for (int i = 1; i <= k; i++) {
            result *= (n - i + 1);
            result /= i;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int M = Integer.parseInt(br.readLine());
        int[] colors = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int total = 0;
        for (int i = 0; i < M; i++) {
            colors[i] = Integer.parseInt(st.nextToken());
            total += colors[i];
        }

        int K = Integer.parseInt(br.readLine());

        double totalComb = combination(total, K);
        double favorable = 0.0;

        for (int i = 0; i < M; i++) {
            if (colors[i] >= K) {
                favorable += combination(colors[i], K);
            }
        }

        double probability = favorable / totalComb;
        System.out.println(probability);
    }
}
