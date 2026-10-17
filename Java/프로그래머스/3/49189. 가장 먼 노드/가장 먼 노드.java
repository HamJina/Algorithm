import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int[] distance = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        for(int[] v : edge) {
            list.get(v[0]).add(v[1]);
            list.get(v[1]).add(v[0]);
        }
        
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        distance[1] = 0;
        visited[1] = true;
        dq.add(1);
        
        while(!dq.isEmpty()) {
            int now = dq.poll();
            
            for(int next : list.get(now)) {
                if(!visited[next]) {
                    if(distance[next] > distance[now] + 1) {
                        distance[next] = distance[now] + 1;
                        visited[next] = true;
                        dq.add(next);
                    }
                }
            }
        }
        
        int max_value = 0;
        int max_count = 0;
        for(int i = 1; i < distance.length; i++) {
            if(max_value < distance[i]) {
                max_value = distance[i];
                max_count = 1;
            } else if(max_value == distance[i]) {
                max_count++;
            }
        }
        
        return max_count;
    }
}