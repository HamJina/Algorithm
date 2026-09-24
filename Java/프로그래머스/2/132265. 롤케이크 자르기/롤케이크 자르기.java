import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int count = 0;
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        
        map1.put(topping[0], 1);
        for(int i = 1; i < topping.length; i++) {
            map2.put(topping[i], map2.getOrDefault(topping[i], 0) + 1);
        }


        for(int i = 1; i < topping.length; i++) {
            if(map1.size() == map2.size()) count++;

            int e = topping[i];
            map1.put(e, map1.getOrDefault(topping[i], 0) + 1);
            if(map2.get(topping[i]) - 1 == 0){
                map2.remove(topping[i]);
            } else {
                map2.put(e, map2.getOrDefault(topping[i], 0) - 1);
            }
        }
        
        return count;
    }
}