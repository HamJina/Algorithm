import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> nickname = new HashMap<>();
        List<String> result = new ArrayList<>();

        // O(N)
        for(String r : record) {
            String[] s = r.split(" ");
            if(!s[0].equals("Leave")) {
                nickname.put(s[1], s[2]);
            }
        }

        // O(N)
        for(int i = 0; i < record.length; i++) {
            String[] s = record[i].split(" ");
            if(s[0].equals("Enter")) {
                result.add(nickname.get(s[1]) + "님이 들어왔습니다.");
            } else if(s[0].equals("Leave")) {
                result.add(nickname.get(s[1]) + "님이 나갔습니다.");
            }
        }

        // 총 O(2N)
        return result.toArray(new String[0]);

    }
}