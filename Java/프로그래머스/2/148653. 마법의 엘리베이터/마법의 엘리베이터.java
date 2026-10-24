class Solution {
    private int min;

    public int solution(int storey) {
        min = Integer.MAX_VALUE;
        dfs(storey, 0);
        return min;
    }

    void dfs(int cur, int total) {
        if (total >= min) return;          // 가지치기
        if (cur == 0) {
            min = Math.min(min, total);
            return;
        }

        int n = cur % 10;      // 현재 일의 자리
        int next = cur / 10;   // 다음 자리로 이동

        dfs(next, total + n);                       // 내려가기: n번 사용
        if (n != 0) dfs(next + 1, total + (10 - n)); // 올라가기: 10-n번 사용, 윗자리 +1
    }
}