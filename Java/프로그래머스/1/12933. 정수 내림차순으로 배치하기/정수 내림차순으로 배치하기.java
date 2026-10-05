import java.util.*;

class Solution {
    public long solution(long n) {
        String[] strs = String.valueOf(n).split("");
        Arrays.sort(strs, Collections.reverseOrder()); // [8, 7, 3, 2, 1, 1];
        
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            sb.append(str);
        }
        
        return Long.parseLong(sb.toString());
    }
}