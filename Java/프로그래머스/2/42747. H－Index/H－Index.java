import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int result = 0;

        for (int i = 1; i <= citations.length; i++) {
            final int h = i;
            long count = Arrays.stream(citations).filter(o -> o >= h).count();

            if (count >= h) result = h;
        }

        return result;
    }
}