import java.util.*;

class Solution {
    private static int[] rx = new int[]{1, -1, 0, 0};
    private static int[] ry = new int[]{0, 0, 1, -1};
    private static boolean[][] visited;

    public int solution(int[][] land, int height) {
        int answer = 0;
        visited = new boolean[land.length][land.length];

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(0, 0, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            
            if(visited[now.x][now.y]) continue;
            visited[now.x][now.y] = true;
            
            answer += now.cost;

            for (int k = 0; k < 4; k++) {
                int cx = now.x + rx[k];
                int cy = now.y + ry[k];

                if (cx < 0 || cy < 0 || cx >= land.length || cy >= land.length)
                    continue;
                
                int tempCost = Math.abs(land[now.x][now.y] - land[cx][cy]);
                int newCost = tempCost > height ? tempCost : 0;
                pq.add(new Node(cx, cy, newCost));
            }

        }

        // 각 영역 사이 높이 최솟값 구하기 
    


        return answer;
    }

    private static class Node {
        int x, y, cost;

        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}