import java.util.*;

class Solution {
    public long solution(long n) {
        String[] split = String.valueOf(n).split("");
        
        Arrays.sort(split, Comparator.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            sb.append(s);
        }
        
        return Long.parseLong(sb.toString());
    }
}