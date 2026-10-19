class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int d = 0; // 남은 배달량 (음수면 여유 용량)
        int p = 0; // 남은 수거량 (음수면 여유 용량)

        for(int i = n - 1; i >= 0; i--) {
            d += deliveries[i];
            p += pickups[i];

            // 이 집에 일이 남아 있으면 여기까지 트립을 돈다
            while(d > 0 || p > 0) {
                d -= cap;
                p -= cap;
                answer += 2L * (i + 1);
            }
        }
        return answer;
    }
}