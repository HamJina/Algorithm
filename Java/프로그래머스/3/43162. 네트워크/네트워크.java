import java.util.*;

class Solution {
    private static int[] parent;
    private static int answer = 0;
    
    public int solution(int n, int[][] computers) {
        parent = new int[n];
        
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for(int i = 0; i < computers.length; i++) {
            for(int j = 0; j < computers[i].length; j++) {
                if(i > j && computers[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(parent[i] == i) answer++;
        }
        
        return answer;
    }
    
    private static int find(int x) {
        if(parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        parent[y] = x;
    }
}