import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> st = new Stack<>();
        
        for(int n : arr) {
            if(!st.isEmpty()) {
                if(st.peek() != n) st.push(n);
            } else {
                st.push(n);
            }
        }
        
        int[] answer = new int[st.size()];
        
        for(int i = answer.length - 1; i >= 0; i--) {
            answer[i] = st.pop();
        }
        
        return answer;
    }
}