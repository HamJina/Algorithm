class Solution {
    // 백트래킹으로 풀기
    private static int answer = 0;
    private static int[] N;
    private static int T;

    public int solution(int[] numbers, int target) {
        N = numbers;
        T = target;
        backtrack(0, 0);
        return answer;
    }
    
    private static void backtrack(int sum, int level) {
        if(level == N.length) {
            if(sum == T) answer++;
            return;
        }
        
        backtrack(sum + N[level], level + 1);
        backtrack(sum - N[level], level + 1);
    }

}