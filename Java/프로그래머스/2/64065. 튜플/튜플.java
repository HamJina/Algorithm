import java.util.*;

class Solution {
    private static ArrayList<String[]> list = new ArrayList<>();
    private static ArrayList<Integer> result = new ArrayList<>();
    private static HashSet<String> set = new HashSet<>();
    public int[] solution(String s) {
        String[] strs = s.substring(0, s.length() - 2).replace("{", "").split("},");
        for(String ss : strs) {
            String[] n = ss.split(",");
            list.add(n);
        }
        Collections.sort(list, (s1, s2) -> Integer.compare(s1.length, s2.length));
        
        for(int i = 0; i < list.size(); i++) {
            String[] n = list.get(i);
            for(String e : n) {
                if(!set.contains(e)) {
                    set.add(e);
                    result.add(Integer.parseInt(e));
                    break;
                }
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
        
    }
}