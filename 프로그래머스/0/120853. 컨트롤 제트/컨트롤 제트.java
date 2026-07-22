import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Integer> st = new Stack<>();
        String[] str = s.split(" ");
        int answer = 0;
        int n = 0;

        for(String c : str) {
            if(Objects.equals(c, "Z")) {
                if(!st.isEmpty()) {
                    n = Integer.valueOf(st.pop());
                    answer -= n;
                }
            } else {
                n = Integer.parseInt(c);
                st.push(n);
                answer += n;
            }
        }
        return answer;
    }
}