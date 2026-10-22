class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        
        for(int[] p : puddles) {
            int col = p[0] - 1;
            int row = p[1] - 1;
            dp[row][col] = Integer.MAX_VALUE; // 물인 부분은 최댓값으로 설정
        }
        
        // 행 초기화
        for(int i = 1; i < dp[0].length; i++) {
            if(dp[0][i] == Integer.MAX_VALUE) continue;
            else {
                if(dp[0][i-1] == Integer.MAX_VALUE || dp[0][i-1] == 0) {
                    dp[0][i] = 0;
                } else {
                    dp[0][i] = 1;
                }
            }
        }
    
        
        // 열 초기화
        for(int i = 1; i < dp.length; i++) {
            if(dp[i][0] == Integer.MAX_VALUE) continue;
            else {
                if(dp[i - 1][0] == Integer.MAX_VALUE || dp[i - 1][0] == 0) {
                    dp[i][0] = 0;
                } else {
                    dp[i][0] = 1;
                }
            }
        }
    
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length; j++) {
                if(dp[i][j] == Integer.MAX_VALUE) continue;
                
                int a = dp[i-1][j];
                int b = dp[i][j-1];
                
                if(a == Integer.MAX_VALUE && b == Integer.MAX_VALUE) {
                    dp[i][j] = 0;
                } else if(a == Integer.MAX_VALUE || b == Integer.MAX_VALUE) {
                    if(a == Integer.MAX_VALUE) dp[i][j] = b % 1000000007;
                    else dp[i][j] = a % 1000000007;
                } else {
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
                }
            }
        }
        
        return dp[n-1][m-1];
    }
}