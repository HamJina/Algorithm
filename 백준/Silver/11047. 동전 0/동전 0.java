import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // 동전의 종류
        int K = sc.nextInt(); // 만들어야 할 금액
        
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt(); // 동전의 가치 입력
        }

        int count = 0;

        // 가치가 큰 동전부터 사용
        for (int i = N - 1; i >= 0; i--) {
            if (A[i] <= K) {
                count += (K / A[i]);
                K = K % A[i];  // 남은 금액 갱신
            }
        }

        System.out.println(count);
    }
}