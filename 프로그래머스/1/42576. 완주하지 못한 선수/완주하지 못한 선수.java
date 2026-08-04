import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
         // Hash에서 키 값은 고유한 값이어야 하므로 동명이인으로 인해 키값만으로 동명이인을 구분할 수 없다
        // 키: 이름, 값: 몇명 을 활용한다. 
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String c : completion) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                // 아직 포함되어 있지 않으면 초기화 
                map.put(c, 1);
            }
        }
        
        for(String p : participant) {
            if(map.containsKey(p)) {
                Integer value = map.get(p);
                
                if(value == 1) {
                    map.remove(p);
                } else {
                    map.put(p, value - 1);
                }
            } else {
                answer = p; 
                break;
            }
        }
        
        return answer;
        
    }
}
