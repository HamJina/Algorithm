import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        // GCD 계산
        long gcdLength = gcd(A, B);

        // 1을 gcdLength 만큼 반복 출력
        System.out.println(changeNum(gcdLength));
    }

    private static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    private static String changeNum(long num) {
        StringBuilder sb = new StringBuilder();
        for (long i = 0; i < num; i++) {
            sb.append('1');
        }
        return sb.toString();
    }
}
