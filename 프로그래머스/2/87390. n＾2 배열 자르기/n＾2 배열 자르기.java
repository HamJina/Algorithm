import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        ArrayList<Long> list = new ArrayList<>();
        
        for(long i = left; i <= right; i+=1) {
            long index = i + 1;
            long ax = 0;
            long ay = 0;
            
            if(index % n == 0) {
                ax = index / n;
                ay = (index % n) + n;
            } else {
                ax = index / n + 1;
                ay = index % n;
            }
            
            if(ax >= ay) {
                list.add(ax);
            } else {
                list.add(ay);
            }
        }
        
        return list.stream().mapToInt(Long::intValue).toArray();
    }
}