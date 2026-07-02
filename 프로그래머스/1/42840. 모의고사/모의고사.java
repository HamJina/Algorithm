import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] answers) {
        int[][] pattern = {
            {1, 2, 3, 4, 5}, // 5
            {2, 1, 2, 3, 2, 4, 2, 5}, // 8
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5} // 10
        }; // 수포자들의 정답 패턴

        int size = answers.length; // 수포자 1, 2, 3 이 적게 될 정답의 갯수

        // pattern 배열을 토대로 실제 수포자들의 정답과 answers 배열의 값을 비교하여 정답 갯수 count
        int[] result = new int[3];
        for (int i = 0; i < result.length; i++) {
            // i번 수포자의 실제 체크한 정답과 정답지를 비교하여 맞춘 문제의 갯수를 count 한다.
            for (int j = 0; j < answers.length; j++) {
                if(pattern[i][j % pattern[i].length] == answers[j]) result[i]++;
            }
        }

        // result에서 가장 큰 값을 갖는 인덱스 찾기
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            if(max == result[i]) list.add(i + 1);
            else if(max < result[i]) {
                max = result[i];
                list.clear();
                list.add(i + 1);
            }
        }

        return list.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
    
    
}