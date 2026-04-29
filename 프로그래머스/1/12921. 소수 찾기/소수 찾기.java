class Solution {
    public int solution(int n) {
        // 1. 배열 생성 (0부터 n까지 담아야 하므로 크기는 n + 1)
        int[] A = new int[n + 1];

        // 2. 배열 초기화
        for (int i = 2; i <= n; i++) {
            A[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = i + i; j < n + 1; j = j + i) {
                if(A[j] == 0) continue;

                A[j] = 0;
            }
        }

        // 4. 소수의 개수 세기
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (A[i] != 0) {
                answer++;
            }
        }

        return answer;
    }
}