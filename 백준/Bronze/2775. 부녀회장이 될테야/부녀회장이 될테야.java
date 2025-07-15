import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 최대 층수와 호수 설정 (1 ≤ k, n ≤ 14)
        int[][] apt = new int[15][15];

        // 0층 초기화: 0층 i호에는 i명이 산다
        for (int i = 1; i <= 14; i++) {
            apt[0][i] = i;
        }

        // 1층부터 14층까지 계산
        for (int k = 1; k <= 14; k++) {
            for (int n = 1; n <= 14; n++) {
                apt[k][n] = apt[k][n - 1] + apt[k - 1][n];
            }
        }

        int T = sc.nextInt(); // 테스트 케이스 수

        for (int t = 0; t < T; t++) {
            int k = sc.nextInt(); // 층 수
            int n = sc.nextInt(); // 호 수
            System.out.println(apt[k][n]);
        }

        sc.close();
    }
}
