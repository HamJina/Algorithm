import java.util.*;

class Solution {
    private static int map_size = 0;
    private static int answer = 0;
    private static ArrayList<String> kind;
    private static LinkedHashMap<String, ArrayList<String>> map;
    public int solution(String[][] clothes) {
        map = new LinkedHashMap<>();
        for(String[] c : clothes) {
            ArrayList<String> list = map.getOrDefault(c[1], new ArrayList<>());
            list.add(c[0]);
            map.put(c[1], list);
        }
        
        map_size = map.size();
        
        Set<String> keySet =  map.keySet();
        kind = new ArrayList<>(keySet);
        
        backtrack(0, 1);
        // 현재 순서 1이고, 즉 첫 번째 의상을 입을지 말지. 0은 현재 의상 순서까지의 조합의 갯수  

        return answer - 1;
    }
    
    static void backtrack(int size, int sum) {
        if(size == map_size) {
            answer += sum;
            return;
        }
        
        // 현재 size 순서 의상을 입는 경우 
        backtrack(size + 1, sum * map.get(kind.get(size)).size());
        
        // 현재 size 순서 의상을 입지 않는 경우 
        backtrack(size + 1, sum);
    }
}