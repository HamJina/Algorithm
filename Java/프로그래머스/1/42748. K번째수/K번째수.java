import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> arr = new ArrayList<>();

        for(int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];

            int[] range = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(range);
            arr.add(range[k - 1]);
        }

        return arr.stream().mapToInt(Integer::intValue).toArray();
    }
}