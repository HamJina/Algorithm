import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int B = budget;
        Arrays.sort(d);
        
        int count = 0;
        for(int cost : d) {
            if(B >= cost) {
                B -= cost;
                count++; 
            } else {
                break;
            }
        }
        return count;
    }
}