import java.util.*;

class Solution {
    private static ArrayList<Integer>[] list;
    private static boolean[] visited;
    private static int answer;
    
    public int solution(int n, int[][] computers) {
        // computers 정보를 토대로 그래프 표현
        list = new ArrayList[n];
        visited = new boolean[n];
        
        for(int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < computers.length; i++) {
            for(int j = 0; j < computers[i].length; j++) {
                if(i < j && computers[i][j] == 1) {
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
    
    public static void dfs(int node) {
        visited[node] = true; // 방문함을 표시 
        
        for(int adj : list[node]) {
            if(!visited[adj]) {
                dfs(adj);
            }
        }
    }
}