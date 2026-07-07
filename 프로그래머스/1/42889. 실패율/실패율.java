import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        // N개의 스테이지에 대한 실패율을 저장하는 배열
        ArrayList<Node> failure = new ArrayList<>();
        
        // N번 스테이지에 도전한 사람 + 클리어하지 못한 사람 계산하여 별도의 배열에 저장
        int[] A = new int[N + 2]; // 분자 (배열에서 N과 값이 같은 요소 몇 개?)
        int[] B = new int[N + 2]; // 분모 (배열에서 N 이상인 요소 몇 개?)
        
        // A
        for(int i = 0; i < stages.length; i++) {
            int element = stages[i];
            if(element <= N) A[element]++;
        }
        
        // B
        int total = stages.length;
        for (int i = 1; i <= N; i++) {
            B[i] = total;
            total -= A[i];
        }
        
        // 실패율 계산
for(int i = 1; i <= N; i++) {
    double failRatio = (B[i] == 0) ? 0 : (double) A[i] / B[i];
    failure.add(new Node(i, failRatio));
}
            
        
        Collections.sort(failure);
        
        
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = failure.get(i).index;
        }

        return answer;
    }
    
    class Node implements Comparable<Node>{
        int index;
        double failRatio;
        
        Node(int index, double failRatio) {
            this.index = index;
            this.failRatio = failRatio;
        }
        
        @Override
        public int compareTo(Node o) {
            if (this.failRatio != o.failRatio) {
                return Double.compare(o.failRatio, this.failRatio); // 실패율 내림차순
            }
            return Integer.compare(this.index, o.index); // 동률이면 index 오름차순
        }
    }
}