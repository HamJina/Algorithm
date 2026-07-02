import java.util.ArrayList;

class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                list.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = list.stream()
                           .distinct()
                           .mapToInt(Integer::intValue)
                           .sorted()
                           .toArray();
        return answer;
    }
}