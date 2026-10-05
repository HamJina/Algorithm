import java.util.*;

class Solution {
    private static int[] rx = new int[]{1, -1, 0, 0};
    private static int[] ry = new int[]{0, 0, 1, -1};
    private static int N;
    private static ArrayList<Integer> list = new ArrayList<>();
    private static boolean[][] visited;
    private static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
    
    public int solution(int[][] land, int height) {
        int result = 0;
        N = land.length;
        visited = new boolean[N][N];
        
        pq.offer(new Node(0, 0, 0));
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if(!visited[now.col][now.row]) {
                visited[now.col][now.row] = true; 
            
            if(now.cost > height) {
                result += now.cost;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = now.col + rx[i];
                int ny = now.row + ry[i];
                
                
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }
                
                if(!visited[nx][ny]) {
                    pq.offer(new Node(nx, ny, Math.abs(land[now.col][now.row] - land[nx][ny])));   
                }
            }
            
            }
        }
        return result;
    }
    
     class Node {
        int col, row, cost;
        
        Node(int col, int row, int cost) {
            this.col = col;
            this.row = row;
            this.cost = cost;
        }
    }
}