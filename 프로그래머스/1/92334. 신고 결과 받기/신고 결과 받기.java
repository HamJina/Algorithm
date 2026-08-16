import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] result = new int[id_list.length];
        HashMap<String, Integer> reportedCount = new HashMap<>(); // 각 유저별 신고 당한 횟수
        HashMap<String, HashSet> reportedList = new HashMap<>();
        HashSet<String> reporter = new HashSet<>(); // 신고 당한 사람

        for(String s : report) {
            String[] sl = s.split(" ");
            // sl[0]이 신고한 사람, sl[1] 신고 당한 사람
            if(!reportedList.containsKey(sl[0])) {
                // 아직 신고한 사람이 map에 없다면 초기화
                reportedList.put(sl[0], new HashSet<>(Arrays.asList(sl[1])));
                // 신고당한 횟수도 업데이트
                reportedCount.put(sl[1], reportedCount.getOrDefault(sl[1], 0) + 1);
            } else {
                // 이미 신고한 사람이 있는 신고 list에 신고 당항 사람 새롭게 넣을 때 중복되지 않도록
                if(reportedList.get(sl[0]).add(sl[1])) { // 성공적으로 들어감
                    reportedCount.put(sl[1], reportedCount.getOrDefault(sl[1], 0) + 1);
                }
            }

            if(reportedCount.getOrDefault(sl[1], 0) >= k) {
                reporter.add(sl[1]);
            }
        }

        if(reporter.isEmpty()) {
            // 신고 당한 사람이 없으면 모든 result는 0으로 반환
            return result;
        }

        // id_list 순서대로 이메일을 받는 횟수 구하기
        for(int i = 0; i < id_list.length; i++) {
            if(reportedList.containsKey(id_list[i])) {
                reportedList.get(id_list[i]).retainAll(reporter);
                result[i] = reportedList.get(id_list[i]).size();
            } else {
                result[i] = 0;
            }
        }

        return result;
    }
}