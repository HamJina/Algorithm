import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        ArrayDeque<String> dq1 = new ArrayDeque<>();
        ArrayDeque<String> dq2 = new ArrayDeque<>();
        
        for(String str : cards1) {
            dq1.addLast(str); // 시간 복잡도 cards1.length
        }
        
        for(String str: cards2) {
            dq2.addLast(str);  // 시간 복잡도 cards2.length
        }

        for(String word : goal) {
            if(!dq1.isEmpty() && Objects.equals(word, dq1.getFirst())) {
                dq1.pollFirst();
            } else if(!dq2.isEmpty() && Objects.equals(word, dq2.getFirst())) {
                dq2.pollFirst();
            } else {
                answer = "No";
            }
        }
                      
        return answer;
    }
}