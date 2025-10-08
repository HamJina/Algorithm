import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : completion) {
            if(map.containsKey(s)) {
                Integer value = map.get(s);
                map.put(s, value+1);
            }else {
                map.put(s, 1);
            }
        }

        String answer = "";
        for (String s : participant) {
            if(map.containsKey(s)) {
                Integer value = map.get(s);
                if(value.equals(1)) map.remove(s);
                else map.put(s, value-1);
            } else {
                answer = s;
                break;
            }
        }

        return answer;
    }
}