import java.util.*;

class Solution {
    private static ArrayList<Integer>[] winList;
    private static ArrayList<Integer>[] loseList;
    private static HashSet<Integer> winSet = new HashSet<>();
    private static HashSet<Integer> loseSet = new HashSet<>();
    private static int answer = 0;
    
    public int solution(int n, int[][] results) {
        winList = new ArrayList[n + 1];
        loseList = new ArrayList[n + 1];
        
        for(int i = 0; i < n + 1; i++) {
            winList[i] = new ArrayList<>();
            loseList[i] = new ArrayList<>();
        }
        
        for(int[] result : results) {
            winList[result[0]].add(result[1]);
            loseList[result[1]].add(result[0]);
        }
        
        for(int i = 1; i <= n; i++) {
            winSearch(i);
            loseSearch(i);
            
            if(winSet.size() + loseSet.size() == n - 1) answer++;
            
            winSet.clear();
            loseSet.clear();
        }
        
        return answer;
    }
    
    private static void winSearch(int now) {
        for (int next : winList[now]) {
            if (loseSet.add(next)) {   // 처음 방문한 경우에만 재귀
                winSearch(next);
        }
    }
        
    }
    
    private static void loseSearch(int now) {
        for(int next : loseList[now]) {
            if(winSet.add(next)) {
                loseSearch(next);   
            }
        }
    }
}