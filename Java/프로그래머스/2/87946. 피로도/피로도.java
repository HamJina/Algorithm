import java.util.*;

class Solution {
    private static int max = 0;
    private static int K;
    private static int[][] D;
    private static int size;

    public int solution(int k, int[][] dungeons) {
        D = dungeons;
        size = dungeons.length;

        for (int i = 0; i < dungeons.length; i++) {
            K = k;
            // K: 현재 피로도, 현재까지 탐색한 순서, dungeons, 현재 탐험한 던전 수
            venture(K, new LinkedList<>(Arrays.asList(i)), 1);
        }
        return max;
    }

    private static void venture(int K, LinkedList<Integer> list, int count) {
        // list의 마지막 요소
        int last = list.get(list.size() - 1);
        if (K < D[last][0]) return;

        if (max < count) max = count;

        LinkedList<Integer> next = new LinkedList<>();
        for (int j = 0; j < size; j++) {
            if (!list.contains(j)) next.add(j);
        }
        next.removeAll(list);

        for (Integer i : next) {
            LinkedList<Integer> added = new LinkedList<>(list);
            added.add(i);
            venture(K - D[last][1], added, count + 1);
        }
    }
}