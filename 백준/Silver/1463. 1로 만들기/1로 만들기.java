import java.util.Scanner;

public class Main {
    static int N;
    static int[] D;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        D = new int[N + 1];

        D[1] = 0; // 1은 이미 1이므로 연산 횟수 0

        for (int i = 2; i <= N; i++) {
            // 기본값: 1을 빼는 연산
            D[i] = D[i - 1] + 1;

            // 2로 나누어떨어지면, 더 적은 횟수인지 비교
            if (i % 2 == 0) {
                D[i] = Math.min(D[i], D[i / 2] + 1);
            }

            // 3으로 나누어떨어지면, 더 적은 횟수인지 비교
            if (i % 3 == 0) {
                D[i] = Math.min(D[i], D[i / 3] + 1);
            }
        }

        System.out.println(D[N]);
    }
}