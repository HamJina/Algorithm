import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] priorities, int location) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        for(int i = 0; i < priorities.length; i++) {
            dq.addLast(i); // 큐에는 인덱스 넣기
        }

        int count = 0;
        while(!dq.isEmpty()) {
            int max_value = Arrays.stream(priorities).max().getAsInt();

            // 가장 높은 우선순위 보다 낮으면 뽑아서 다시 큐에 넣기 반복
            while(max_value > priorities[dq.peekFirst()]) {
                dq.addLast(dq.pollFirst());
            }

            int poll = dq.pollFirst();
            priorities[poll] = -1;  // 우선순위가 가장 높은 인덱스 제거
            count++;
            if(poll == location) {
                break;
            }
        }

        return count;
    }
}