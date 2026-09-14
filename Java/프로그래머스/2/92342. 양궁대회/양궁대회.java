import java.util.*;

class Solution {
    // 여기서 핵심은 라이언이 맞힌 화살 개수는 어피치보다 1만큼 더 크거나 0이면 된다.
    private static int N;
    private static ArrayList<int[]> result = new ArrayList<>();
    private static int max_score = Integer.MIN_VALUE;
    private static int[] Info;
    public int[] solution(int n, int[] info) {
        N = n;
        Info = info;
        int[] lion = new int[11];
        backtrack(0, 0, lion);

        return result.stream().min((a, b) -> {
            for (int i = a.length - 1; i >= 0; i--) {
                if (a[i] != b[i]) return Integer.compare(b[i], a[i]);
            }
            return 0;
        }).orElse(new int[]{-1});
    }

    // backtrack 종료 조건은 라이언이 맞힌 화살 개수가 n이 될 때 이다.
    // 종료 되는 순간의 라이언과 어피치의 점수를 계산해서 가장 높은 점수를 갱신하고 result에도 갱신해준다.
    private static void backtrack(int start, int count, int[] lion) {
        if(count > N) return;
        
        if(count <= N) { // count는 현재까지 라이언이 맞힌 화살 갯수로 N에 도달하면 종료 더 탐색할 필요가 없다.
            // 어피치와 라이언의 점수 차이 계산
            lion[10] = N - count;
            
            int apeach_score = 0;
            int lion_score = 0;
            for(int i = 0; i < 11; i++) {
                if(Info[i] == 0 && lion[i] == 0) continue; // 둘다 0점인 경우는 모두 점수 획득 못함 
                if(Info[i] >= lion[i]) {
                    // 어피치 점수 획득
                    apeach_score += 10 - i;
                } else {
                    lion_score += 10 - i;
                }
            }

            if(lion_score > apeach_score) {
                // 라이언이 우승 하는 경우
                int minus_score = lion_score - apeach_score;
                if(minus_score > max_score) {
                    result.clear();
                    result.add(lion.clone());
                    max_score = minus_score;
                } else if(minus_score == max_score) {
                    result.add(lion.clone());
                }
            }
        }

        for(int i = start; i < 10; i++) {
            int[] plus = lion.clone();
            plus[i] = Info[i] + 1;

            backtrack(i + 1, count + Info[i] + 1, plus);
        }
        // 종료 시점(count <= N)에 남은 화살을 index 10에 채워서 채점

    }
}