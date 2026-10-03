import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        HashMap<Integer, Double> map = new HashMap<>();
        int total = stages.length;

        for (int i = 1; i <= N; i++) {
            int stage = i;
            int count = (int) Arrays.stream(stages).filter(o -> o == stage).count();
            map.put(i, total == 0 ? 0.0 : (double) count / total);
            total -= count;
        }

        return map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Double>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey()))
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}