import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, String> map = new HashMap<>(); // 부모 - 자식 관계 표현
        HashMap<String, Integer> total = new HashMap<>();
        int[] answer = new int[enroll.length];

        // 초기화
        for(int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], referral[i]);
        } // O(N) 최대 10,000

        // O(M*logN)
        for(int i = 0; i < seller.length; i++) {
            String s = seller[i];
            int plusAmount = amount[i]*100;

            while(map.get(s) != "-" && plusAmount > 0) {
                total.put(s, total.getOrDefault(s, 0) + (plusAmount - (int) (plusAmount * 0.1)));
                s = map.get(s);
                plusAmount = (int) (plusAmount * 0.1);
            }
        }

        for(int i = 0; i < enroll.length; i++) {
            answer[i] = total.getOrDefault(enroll[i], 0);
        }



        return answer;
    }
}