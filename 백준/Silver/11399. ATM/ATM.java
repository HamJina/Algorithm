import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] S = new int[N];

        // 입력 받기
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        // 삽입 정렬 (오름차순)
        for (int i = 1; i < N; i++) {
            int insert_value = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > insert_value) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = insert_value;
        }

        // 누적합 배열 생성
        S[0] = A[0];
        for (int i = 1; i < N; i++) {
            S[i] = S[i - 1] + A[i];
        }

        // 누적합 전체 합 구하기
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += S[i];
        }

        System.out.println(sum);
    }
}
