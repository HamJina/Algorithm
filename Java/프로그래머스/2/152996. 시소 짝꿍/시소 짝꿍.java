import java.util.*;
import java.util.stream.*;

class Solution {
    double[][] D = new double[][]{{1, 1}, {2, 3}, {1, 2}, {3, 4}, {3, 2}, {2, 1}, {4, 3}};
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        HashMap<Double, Integer> map = new HashMap<>();
        for(int i = 0; i < weights.length; i++) {
            map.put((double) weights[i], map.getOrDefault((double) weights[i], 0) + 1);
        }
        
        for(int i = 0; i < weights.length; i++) {
            double cur = (double) weights[i]; 
            // 제거 
            if(map.get(cur) > 1) {
                // 1감소
                map.put(cur, map.get(cur) - 1);
            } else {
                // 아예 제거 
                map.remove(cur);
            }
            
            
            for(int j = 0; j < D.length; j++) {
                double target = (cur * D[j][1]) / D[j][0];
                if(map.containsKey(target)) {
                    answer += map.get(target);
                }
            }
        
        }
    
        return answer;
    }
}