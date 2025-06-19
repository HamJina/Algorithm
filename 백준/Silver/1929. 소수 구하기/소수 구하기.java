import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt(); // 시작 값
        int N = in.nextInt(); // 끝 값

        int[] A = new int[N + 1];

        // 배열 초기화
        for (int i = 2; i <= N; i++) {
            A[i] = i;
        }

        // 에라토스테네스의 체 알고리즘
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (A[i] == 0) continue; // 이미 지워졌으면 넘어감

            for (int j = i + i; j <= N; j = j + i) {
                A[j] = 0; // 배수 지우기
            }
        }

        // M부터 N까지 출력
        for (int i = M; i <= N; i++) {
            if (A[i] != 0) {
                System.out.println(A[i]);
            }
        }
    }
}