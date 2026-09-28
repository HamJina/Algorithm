import java.util.*;

class Solution {
    int solution(int[][] land) {
        int[] dp = land[0].clone(); // 열 별로 합의 최대값 저장 (첫 행으로 초기화)

        for (int j = 1; j < land.length; j++) {
            int[] cur_array = land[j];
            int[] next = new int[cur_array.length];

            for (int i = 0; i < cur_array.length; i++) { // 이번 행에서 밟을 열
                int max = 0;
                for (int k = 0; k < cur_array.length; k++) { // 이전 행의 열
                    if (k != i) {
                        if (max < dp[k]) {
                            max = dp[k];
                        }
                    }
                }
                next[i] = max + cur_array[i];
            }
            dp = next;
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}