import java.util.*;

class Solution {
    private static HashMap<Character, int[]> map = new HashMap<>();;
    public int solution(String dirs) {
        map.put('U', new int[]{0, 1});
        map.put('D', new int[]{0, -1});
        map.put('R', new int[]{1, 0});
        map.put('L', new int[]{-1, 0});
        
        HashSet<String> set = new HashSet<>();
        
        int curX = 0;
        int curY = 0;
        for(int i = 0; i < dirs.length(); i++) {
            char ch = dirs.charAt(i);
            int rX = map.get(ch)[0];
            int rY = map.get(ch)[1];
            int nextX = curX + rX;
            int nextY = curY + rY;
            
            if(nextX > 5 || nextY > 5 || nextX < -5 || nextY < -5) {
                continue;
            }
            
            set.add(curX + "," + curY + "," + nextX + "," + nextY);
            set.add(nextX + "," + nextY + "," + curX + "," + curY);
            curX = nextX;
            curY = nextY;
        }
        
        return set.size() / 2;
    }
}