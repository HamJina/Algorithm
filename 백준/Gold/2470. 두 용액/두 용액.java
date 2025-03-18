import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        //산성 -> 양수, 알칼리성 -> 음성
        //두수의 합이 0에 가까운 경우 찾기
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A); //정렬하기
        //-2 4 -99 -1 98
        //-99 -2 -1 4 98
        int minLeft = 0, minRight = 0;
        int sum = 0;
        int left = 0, right = n-1;
        int min = Integer.MAX_VALUE;

        while(left < right) {
            //두수의 합이 0이라 가장 가까운 두수의 조합 찾기 여기서 절딧값 사용 abs()함수
            sum = A[left] + A[right];
            if(Math.abs(sum) < min) { //0과 값이 더 가까우면 최솟값 갱신하기
                min = Math.abs(sum);
                minLeft = left;
                minRight = right;

            } else if(sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(A[minLeft] + " " + A[minRight]);

    }
}
