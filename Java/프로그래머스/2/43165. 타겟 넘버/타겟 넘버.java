import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        ArrayList<Integer>[] list = new ArrayList[numbers.length + 1];
        for(int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        
        // 0 인덱스에 0 넣기 
        list[0].add(0);
        
        for(int i = 0; i < numbers.length; i++) {
            ArrayList<Integer> cur = list[i];
            
            for(int now : cur) {{
                list[i + 1].add(now + numbers[i]);
                list[i + 1].add(now - numbers[i]);
            }}
        }
        
        ArrayList<Integer> last = list[list.length - 1];
        
        return (int) last.stream().filter(o -> o == target).mapToInt(Integer::intValue).count();
    }
}