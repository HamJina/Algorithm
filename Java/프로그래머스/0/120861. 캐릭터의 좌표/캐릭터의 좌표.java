import java.util.*;

class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] result = new int[2];
        HashMap<String, Integer> hx = new HashMap<>();
        hx.put("left", -1);
        hx.put("right", 1);
        hx.put("up", 0);
        hx.put("down", 0);
        HashMap<String, Integer> hy = new HashMap<>();
        hy.put("left", 0);
        hy.put("right", 0);
        hy.put("up", 1);
        hy.put("down", -1);
        
        for(String dir : keyinput) {
            int rx = result[0] + hx.get(dir);
            int ry = result[1] + hy.get(dir);
            
            if(rx > board[0] / 2 || ry > board[1] / 2 || rx < -board[0] / 2 || ry < -board[1] / 2) {
                continue;
            }
            result[0] = rx;
            result[1] = ry;
        }
        
        return result;
    }
}