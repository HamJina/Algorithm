import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] S = new int[n+1]; //배열합 계산
        for (int i = 1; i <= n; i++) {
            S[i] = S[i - 1] + Integer.parseInt(st.nextToken());
        }

        int left = 1, right = 1;
        int len = Integer.MAX_VALUE, minLen = Integer.MAX_VALUE;
        int sum = 0;
        while(left <= right && right <= n) {
            sum = S[right] - S[left-1];
            if(sum >= s) {
                len = right - left + 1;
                if(len < minLen) {
                    minLen = len;
                }
                left++;
            } else {
                right++;
            }
        }
        if(minLen == Integer.MAX_VALUE) System.out.println("0");
        else System.out.println(minLen);
    }
}
