import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 자연수
        int[] p = new int[n+1];
        List<Integer> prime = new ArrayList<>();

        // 1에서 N까지의 숫자 배열 생성
        for (int i = 2; i <= n; i++) {
            p[i] = i;
        }

        // 에라토스테네스의 체를 통해 소수만 골라내기 (2부터 n의 제곱근까지 배수 탐색하면서 지우기)
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (p[i] == 0) continue;
            for (int j = i + i; j <= n; j += i) {
                p[j] = 0; // 배수 지우기
            }
        }

        // 지워지지 않은 값들로 구간합 배열 생성하기
        for (int i = 2; i <= n; i++) {
            if(p[i] != 0) prime.add(i);
        }

        // 구간합
        int[] A = new int[prime.size() + 1];
        for (int i = 1; i <= prime.size(); i++) {
            A[i] = A[i-1] + prime.get(i-1);
        }

        int count = 0; // 연속된 소수의 합으로 나타낼 수 있는 경우의 수
        int start = 0, last = 1; // 투포인터

        while(start < last && last < A.length) {
            int sum = A[last] - A[start];
            if (sum < n) {
                last++;
            } else if (sum > n) {
                start++;
            } else {
                count++;
                start++;
                last++;
            }
        }

        System.out.println(count);
    }
}
