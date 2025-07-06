import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        System.out.println(countAlmostPrimes(A, B)); // A와 B사이 거의 소수 갯수 출력
    }

    // 소수 판별 함수
    public static boolean isPrime(int n) {
        if (n < 2) return false; // 2보다 작은수는 소수 
        int sqrt = (int)Math.sqrt(n); // n의 제곱근
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // 거의 소수 개수 세기
    public static int countAlmostPrimes(long A, long B) {
        int count = 0;
        int maxBase = (int)Math.sqrt(B);

        for (int base = 2; base <= maxBase; base++) {
            if (isPrime(base)) {
                long power = (long)base * base;
                while (power <= B) {
                    if (power >= A) {
                        count++;
                    }
                    if (power > B / base) break; 
                    power *= base;
                }
            }
        }
        return count;
    }
}
