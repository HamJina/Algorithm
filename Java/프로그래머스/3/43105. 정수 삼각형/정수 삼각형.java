import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][];
        dp[0] = new int[]{triangle[0][0]};

        for(int i = 1; i < triangle.length; i++) {
            dp[i] = new int[triangle[i].length];
            for(int j = 0; j < triangle[i].length; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if(j == triangle[i].length - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    // 부모가 2개인 경우 (둘 중 합이 최대인 것 고르기)
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }
        }
        return Arrays.stream(dp[triangle.length - 1]).max().getAsInt();
    }
}