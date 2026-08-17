import java.util.*;

class Solution {
    private static HashMap<String, Integer> menuCount = new HashMap<>(); // 메뉴 조합별 주문 횟수 count

    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> result = new ArrayList<>();

        for(int n : course) {
            // n은 메뉴 갯수 
            for(String menu : orders) {
                // 해당 메뉴로 나올 수 있는 조합 뽑아서 menuCount 키 값으로 저장
                combinations(0, menu.toCharArray(), "", n);
            }

            // menuCount에서 value가 가장 큰 key를 result에 담기
            ArrayList<String> pool = new ArrayList<>();
            int max_value = -1;
            for (Map.Entry<String, Integer> entry : menuCount.entrySet()) {
                if(entry.getValue() > max_value) {
                    pool.clear();
                    max_value = entry.getValue();
                    if(max_value >= 2) pool.add(entry.getKey());
                } else if(entry.getValue() == max_value) {
                    if(max_value >= 2) pool.add(entry.getKey());
                }
            }
            result.addAll(pool);

            menuCount.clear();
            pool.clear();
        }


        // 최종 답안 제출시 
        Collections.sort(result, Comparator.naturalOrder());
        return result.toArray(new String[0]);
    }

    public static void combinations(int idx, char[] order, String result, int n) {
        if(result.length() == n) {
            char[] ch = result.toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);
            menuCount.put(s, menuCount.getOrDefault(s, 0) + 1); // 문자열을 오름차순으로 정렬한 후 put하기 
        }

        for(int i = idx; i < order.length; i++) {
            combinations(i + 1, order, result + order[i], n);
        }
    }
}