import java.util.*;

class Solution {
    private static ArrayList<Integer>[] list;
    private static int answer = 0;
    private static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        list = new ArrayList[n];
        visited = new boolean[n];
        
        for(int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < computers.length; i++) {
            for(int j = 0; j < computers[i].length; j++) {
                if(i > j && computers[i][j] == 1) {
                    list[i].add(j);
                    list[j].add(i);
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
    
    private static void dfs(int now) {
        if(!visited[now]) {
            visited[now] = true;
            
            for(int next : list[now]) {
                if(!visited[next]) {
                    dfs(next);
                }
            }
        }
    }
}