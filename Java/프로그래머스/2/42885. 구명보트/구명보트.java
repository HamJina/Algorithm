import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        boolean[] removed = new boolean[people.length];
        
        int count = 0;
        int start = 0;
        int end = people.length - 1;
        while(start < end) {
            if(people[start] + people[end] <= limit) {
                count++;
                removed[start] = true;
                removed[end] = true;
                start++;
                end--;
            } else {
                end--;
            } 
        }
        
        for(boolean b : removed) {
            if(!b) count++;
        }
        
        return count;
    }
}