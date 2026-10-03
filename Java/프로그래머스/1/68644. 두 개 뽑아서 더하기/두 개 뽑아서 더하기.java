import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        TreeSet<Integer> set = new TreeSet<>(); // 결과를 담는 배열, 중복을 제거하면서 기본 오름차순 정렬 사용하기 
        
        for(int i = 0; i < numbers.length - 1; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        int[] result = new int[set.size()];
        // TreeSet을 int[] 배열로 반복문 사용하여 변환하기 
        for(int i = 0; i < result.length; i++) {
            result[i] = set.pollFirst();
        }
        
        return result;
        
    }
}