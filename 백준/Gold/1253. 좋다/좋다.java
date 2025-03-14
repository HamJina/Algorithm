import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 주어질 숫자 개수

        st = new StringTokenizer(br.readLine());

        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 오름차순 정렬
        Arrays.sort(A);
        int count = 0; // 좋은 수 개수

        // 각 숫자 A[i]가 좋은 수인지 확인
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1; // 투 포인터 초기화

            while (left < right) {
                int sum = A[left] + A[right];

                if (sum == A[i]) {
                   if(left != i && right != i) { //left와 right모두 자기자신이면 안됨
                       count++;
                       break;
                   } else if(left == i) {
                       left++;
                   } else if(right == i){
                       right--;
                   }
                }else if (sum < A[i]) {
                    left++; // 합이 작으면 left 증가
                } else {
                    right--; // 합이 크면 right 감소
                }
            }
        }

        System.out.println(count);
    }
}
