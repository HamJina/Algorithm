import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : tangerine) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer> counts = new ArrayList<>(map.values());
        counts.sort(Comparator.reverseOrder());

        int result = 0;
        for (int c : counts) {
            k -= c;
            result++;
            if (k <= 0) break;
        }
        return result;
    }
}