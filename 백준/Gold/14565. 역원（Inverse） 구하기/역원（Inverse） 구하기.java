import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    // 확장 유클리드 알고리즘
    public static BigInteger multiplicativeInverse(BigInteger a, BigInteger n) {
        BigInteger[] result = extendedGCD(a, n);
        BigInteger gcd = result[0];
        BigInteger x = result[1];

        // 역원이 존재하지 않음
        if (!gcd.equals(BigInteger.ONE)) {
            return BigInteger.valueOf(-1);
        }

        // x가 음수일 경우 양수로 바꿔줌
        return x.mod(n);
    }

    // 확장 유클리드 알고리즘: gcd(a, b) = x * a + y * b
    public static BigInteger[] extendedGCD(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            return new BigInteger[]{a, BigInteger.ONE, BigInteger.ZERO};
        }
        BigInteger[] vals = extendedGCD(b, a.mod(b));
        BigInteger d = vals[0];
        BigInteger x1 = vals[2];
        BigInteger y1 = vals[1].subtract(a.divide(b).multiply(vals[2]));
        return new BigInteger[]{d, x1, y1};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger N = sc.nextBigInteger();
        BigInteger A = sc.nextBigInteger();

        // 덧셈 역: (N - A) % N
        BigInteger additiveInverse = N.subtract(A).mod(N);

        // 곱셈 역: 확장 유클리드 알고리즘 사용
        BigInteger multiplicativeInverse = multiplicativeInverse(A, N);

        System.out.println(additiveInverse + " " + multiplicativeInverse);
        sc.close();
    }
}
