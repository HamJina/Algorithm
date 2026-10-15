import java.util.*;

class Solution {
    private static int[] parent;
    private static int answer = 0;
    private static int edge = 0;
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        
        // costs 배열을 비용 기반으로 오름차순 정렬
        Arrays.sort(costs, (o1, o2) -> {
            return Integer.compare(o1[2], o2[2]);
        });
        
        // parent 배열 초기화 
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        
        for(int i = 0; i < costs.length; i++) {
            int x = costs[i][0];
            int y = costs[i][1];
            int cost = costs[i][2];
            
            if(find(x) == find(y)) {
                // 이미 같은 집합이면 건너뜀
                continue;
            } else {
                union(x, y);
                answer += cost;
            }
        }
        
       
        
        return answer;
    }
    
    static int find(int x) {
        if(parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        parent[y] = x;
    }
}