import java.util.*;

class Solution {
    private static int[] rx = new int[]{1, -1, 0, 0};
    private static int[] ry = new int[]{0, 0, 1, -1};
    private static int N;
    private static int M;
    
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(0, 0, 1));
        maps[0][0] = 0;
        
        while(!dq.isEmpty()) {
            Node now = dq.poll();
            
            if(now.x == N - 1 && now.y == M - 1) return now.dis;
            
            for(int i = 0; i < 4; i++) {
                int nx = now.x + rx[i];
                int ny = now.y + ry[i];
                
                if(nx >= N || ny >= M || nx < 0 || ny < 0) continue;
                if(maps[nx][ny] == 0) continue; // 벽이어서 갈 수 없는 곳
                
                dq.add(new Node(nx, ny, now.dis + 1));
                maps[nx][ny] = 0; // 방문 처리 
            }
        }
        return -1;
    }
    
    static class Node {
        int x, y, dis;
        
        Node(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
}