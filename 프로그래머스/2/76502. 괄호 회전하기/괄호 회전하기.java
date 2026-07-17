import java.util.*;

class Solution {
    public int solution(String s) {
        int result = 0;
        Stack<Character> st = new Stack<>();

        for(int x = 0; x < s.length(); x++) {
            boolean valid = true;

            // x칸만큼 회전한 새로운 문자열 구하기 
            String prior = s.substring(0, x);
            String post = s.substring(x, s.length());

            String str = post + prior;

            for(int y = 0; y < str.length(); y++) {
                char c = str.charAt(y);

                if(c == '[' || c == '(' || c == '{') {
                    st.push(c);
                } else if(c == ']') {
                    if(st.isEmpty()) {
                        valid = false;
                        break;
                    } 
                    if(st.pop() != '[') {
                        valid = false;
                        break;
                    } 
                } else if(c == ')') {
                    if(st.isEmpty()) {
                        valid = false;
                        break;
                    } 
                    if(st.pop() != '(')  {
                        valid = false;
                        break;
                    } 
                } else if(c == '}') {
                    if(st.isEmpty()) {
                        valid = false;
                        break;
                    } 
                    if(st.pop() != '{')  {
                        valid = false;
                        break;
                    } 
                }
            }
            if(st.isEmpty() && valid) result++;
            st.clear();
        }
        return result;
    }
}