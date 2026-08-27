import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i : ingredient) {
            stack.push(i);
            if (stack.size() >= 4) {
                int a = stack.pop();
                int b = stack.pop();
                int c = stack.pop();
                int d = stack.pop();
                if (d == 1 && c == 2 && b == 3 && a == 1) {
                    answer++;
                } else {
                    stack.push(d);
                    stack.push(c);
                    stack.push(b);
                    stack.push(a);
                }
            }
        }
        return answer;
    }
}