import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long A = Long.parseLong(st.nextToken());

        long addInverse = (N - A);

        if(gcd(A, N) != 1) System.out.println(addInverse + " " + -1);
        else {
            long result = multiplyInverse(A, N)[0];
            while(result < 0) {
                result += N;
            }
            System.out.println(addInverse + " " + result);
        }
    }
    
    // 곲셈역 구하기 (확장 유클리드 호제법 사용)
    private static long[] multiplyInverse(long A, long N) {
        long[] ret = new long[2]; // ret은 정수 해 x, y를 저장하는 배열
        if (N == 0) {
            ret[0] = 1;
            ret[1] = 0; // x = 1, y = 0
            return ret;
        }
        long q = A / N; // 몫
        long[] v = multiplyInverse(N, A % N);  // 재귀적으로 확장 유클리드, v는 이전 x', y'값을 저장하는 배열
        ret[0] = v[1]; // x = y'
        ret[1] = v[0] - v[1] * q; // y = x' - y' * q
        return ret;
    }

    private static long gcd(long a, long b) {
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
}