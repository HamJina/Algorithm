import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 약관 이름 -> 키, 약관 달수 -> 값
        HashMap<String, Integer> term = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();
        
        // terms를 순회하면서 term 맵에 저장하기 
        for(String s : terms) {
            String key = s.substring(0, 1);
            Integer value = Integer.valueOf(s.substring(2, s.length()));
            term.put(key, value);
        }
        
        // privacies 순회하면서 terms의 달 수 더하기 
        String[] endDate = new String[privacies.length];
        for(int i = 0; i < endDate.length; i++) {
            String s = privacies[i];
            String year = s.substring(0, 4);
            String month = s.substring(5, 7);
            String date = s.substring(8, 10);
            String t = s.substring(11, 12);
            
            Integer plusMonth = Integer.valueOf(month) + Integer.valueOf(term.get(t));
            month = String.valueOf(plusMonth);
            if(plusMonth > 12) {
                month = String.valueOf(plusMonth % 12);
                if(month.equals("0")) month = "12";
                year = String.valueOf(Integer.valueOf(year) + (plusMonth - 1) / 12);
}
            if(month.length() == 1) month = "0" + month;
            StringBuilder sb = new StringBuilder();
            sb.append(year).append(".").append(month).append(".").append(date);
            endDate[i] = sb.toString();
            
            // 유효 날짜들과 today를 비교하여 today보다 날짜가 빠르거나 같은 것은 정답 배열에 추가
            
        }
        
        System.out.println(Arrays.toString(endDate));
        for(int i = 0; i < endDate.length; i++) {
                String end = endDate[i];
                
                if(today.compareTo(end) >= 0) {
                    answer.add(i + 1);
                }
        }
        
     
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}