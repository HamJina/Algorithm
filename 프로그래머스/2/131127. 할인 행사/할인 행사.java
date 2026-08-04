import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> buy = new HashMap<>();

        for(int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        } // 총 사야하는 것의 갯수는 10개  -> 10일동안의 할인만 고려!

        for(int i = 0; i <= discount.length - 10; i++) {
            for(int j = i; j < i + 10; j++) {
                String s = discount[j]; // 해당일에 할일하는 제품
                buy.put(s, buy.getOrDefault(s, 0) + 1);
            }

            // 실제 buy와 map이 같은지 확인 같으면 answer++
            Set<String> set = map.keySet(); // map이 실제로 구매해야 하는 것
            
            boolean correct = true;
            for (String s : set) {
                if(!buy.containsKey(s)) { // 원하는 것이 구매 목록에 없으면 break
                    correct = false;
                    break;
                } else if(!buy.get(s).equals(map.get(s))) { // 원하는 것의 수량과 구매한 것의 수량이 다르면 brea
                    correct = false;
                    break;
                }
            }
            
            if(correct) {
                answer++;
            }

            buy.clear();
        }

        return answer;
    }
}