import java.util.*;

class Solution {
    private static int[][] correct = {
        {1, 2, 3, 4, 5},
        {2, 1, 2, 3, 2, 4, 2, 5},
        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };
    public int[] solution(int[] answers) {
        // map -> key: 수포자, value: 맞힌 갯수 
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>(); // 결과 수포자 번호를 담을 배열 
        
        // 수포자별 맞힌 갯수 count하기 
        for(int i = 0; i < correct.length; i++) {
            int correct_count = 0;
            for(int j = 0; j < answers.length; j++) {
                if(answers[j] == correct[i][j % correct[i].length])
                    correct_count++;
            }
            map.put(i + 1, correct_count);
        }
        // 가장 큰 value값 고르기 -> 해당 key 값 오름차순 정렬
        
        int max = Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            if(max == e.getValue()) {
                list.add(e.getKey());
            } else if(max < e.getValue()) {
                list.clear();
                max = e.getValue();
                list.add(e.getKey());
            }
        }
        
        return list.stream().sorted().mapToInt(Integer::intValue).toArray();
    
    }
    
    
}