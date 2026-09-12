class Solution {
    private static int[][] chess;
    private static int N;
    private static int answer = 0;

    // col은 현재 행
    private static boolean isValid(int col, int row) {
        return !inRow(col, row) && !inCol(col, row) && !inCross(col, row);
    }

    private static boolean inRow(int col, int row) {
        // 같은 열에 있는지 
        for (int i = 0; i < N; i++) {
            if (chess[i][row] == 1) return true;
        }
        return false;
    }

    private static boolean inCol(int col, int row) {
        // 같은 열에 있는지 
        for (int i = 0; i < N; i++) {
            if (chess[col][i] == 1) return true;
        }
        return false;
    }

    private static boolean inCross(int col, int row) {
        // 같은 대각선에 있는지
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (chess[i][j] == 0) continue;              // 퀸이 없는 칸은 건너뜀
                if (i + j == col + row) return true;         // ↙ 방향 (합이 같음)
                if (i - j == col - row) return true;         // ↘ 방향 (차가 같음)
            }
        }
        return false;
    }


    private static void backtrack(int n, int count) { // 0행에 대해 가능한 경우 탐색
        // 새로 체스를 추가하려는 순간, 같은 행, 같은 열, 대각선에 또 다른 chess가 있다면 추가 불가
        if (count == N) {
            answer++; // 여기 수정 (만약 4개의 체스를 채우면 count++)
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (isValid(n, i)) {
                // 0행 i열에 추가 
                chess[n][i] = 1;
                backtrack(n + 1, count + 1);

                chess[n][i] = 0;
            }

        }

    }

    public int solution(int n) {
        chess = new int[n][n];
        N = n;

        backtrack(0, 0);

        return answer;
    }
}