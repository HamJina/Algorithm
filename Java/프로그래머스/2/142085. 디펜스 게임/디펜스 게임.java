import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 스킬로 막은 라운드의 적 수 (최소 힙)

        for(int i = 0; i < enemy.length; i++) {
            pq.offer(enemy[i]);         // 일단 스킬로 막았다고 가정

            if(pq.size() > k) {
                n -= pq.poll();         // 스킬 대상 중 가장 작은 적은 병사로 막기
            }
            if(n < 0) return i;         // 병사가 부족하면 i라운드는 못 막음
        }
        return enemy.length;
    }
}