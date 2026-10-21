import java.util.*;

class Solution {
    private static int[][] dp;
    public int solution(int[][] triangle) {
        int n = triangle.length;
        dp = new int[n][triangle[n-1].length]; // 가변 배열 설정
        dp[0][0] = triangle[0][0];
        
        for(int i = 1; i < triangle.length; i++) {
            for(int j = 0; j < triangle[i].length; j++) {
                if(j == 0) dp[i][j] = dp[i-1][j] + triangle[i][j];
                else if(j == triangle[i].length - 1) dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                else dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
        }
        
        int[] last = dp[n - 1];
        return Arrays.stream(last).max().getAsInt();
    }
}