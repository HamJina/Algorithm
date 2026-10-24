import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int[] Q = new int[queue1.length + queue2.length];
        
        for(int i = 0; i < queue1.length; i++) {
            Q[i] = queue1[i];
        }
        for(int j = 0; j < queue2.length; j++) {
            Q[queue1.length + j] = queue2[j];
        }
        
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();
        if((sum1 + sum2) % 2 == 1) return -1;
        
        int q1 = 0;
        int q2 = queue1.length;
        
        int limit = queue1.length * 4;
        int count = 0;
        while(sum1 != sum2) {
            if(count > limit) return -1;
            if(sum1 < sum2) {
                sum2 -= Q[q2];
                sum1 += Q[q2];
                q2++;
                count++;
                if(q2 == Q.length) q2 = 0;
            } else {
                sum1 -= Q[q1];
                sum2 += Q[q1];
                q1++;
                count++;
                if(q1 == Q.length) q1 = 0;
            }
            // 끝에 도달한 경우 
            if(q1 == q2) return -1;
        }
        return count;
    }
}