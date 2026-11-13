import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<>();
        for(String[] c : clothes) {
            ArrayList<String> list = map.getOrDefault(c[1], new ArrayList<>());
            list.add(c[0]);
            map.put(c[1], list);
        }
        
        for(String key : map.keySet()) {
            answer *= map.get(key).size() + 1;
        }
        
        return answer - 1;
    }
    
   
}