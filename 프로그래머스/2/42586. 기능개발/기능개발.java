import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = 0; i < progresses.length; i++) {
            int element = ((100 - progresses[i]) % speeds[i] == 0) ? (100 - progresses[i]) / speeds[i] : (100 - progresses[i]) / speeds[i] + 1;
            dq.addLast(element);
        }

        while(!dq.isEmpty()) {
            int count = 0;
            int current = dq.pollFirst();
            count++;

            while(!dq.isEmpty() && current >= dq.getFirst()) {
                count++;
                dq.pollFirst();   
            }
            arr.add(count);
        }
        
        return arr.stream().mapToInt(Integer::intValue).toArray();
    }
}