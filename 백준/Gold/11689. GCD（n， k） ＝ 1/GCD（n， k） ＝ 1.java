import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long result = n;

        for (long p = 2; p <= Math.sqrt(n); p++) {
            if (n % p == 0) {              // p가 n의 소인수이면
                result = result - result / p;  // 결과 업데이트
                while (n % p == 0) {
                    n /= p;               // 같은 소인수는 모두 제거
                }
            }
        }

        if (n > 1) {                       // 아직 소인수 하나가 남아 있다면
            result = result - result / n;
        }

        System.out.println(result);
    }
}