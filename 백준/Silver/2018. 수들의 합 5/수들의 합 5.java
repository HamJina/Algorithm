import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        } // 1~n까지의 자연수 배열에 저장

        // 투포인터 지정하기
        int left = 0; // 첫번째 인덱스
        int right = 0; // 마지막 인덱스

        int result = 1;
        int sum = 1;

        while (right != n-1) {
            if (sum < n) {
                right++;
                sum += array[right];
            } else if (sum > n) {
                sum -= array[left];
                left++;
            } else {
                result++;
                right++;
                sum += array[right];

            }
        }
        System.out.println(result);
    }
}
