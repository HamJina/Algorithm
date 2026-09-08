import java.util.*;

class Solution {
    private static int[][] node_info;
    private static int answer;
    private static int n;
    private static int m;
    private static int[][] dist;

    private static int[] rx = {1, -1, 0, 0};
    private static int[] ry = {0, 0, 1, -1};
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        node_info = new int[3][];

        // 출발점, 레버, 도착점 위치 파악 (maps를 순회해야 하는데 O(N) -> 최대 100)
        for(int i = 0; i < maps.length; i++) {
            String s = maps[i];
            if(s.contains("S")) {
                node_info[0] = new int[]{i, s.indexOf("S")};
            }
            if(s.contains("L")) {
                node_info[1] = new int[]{i, s.indexOf("L")};
            }
            if(s.contains("E")) {
                node_info[2] = new int[]{i, s.indexOf("E")};
            }
        }
        System.out.println(Arrays.deepToString(node_info));

        // start -> 레버까지의 최단 거리
        dist = new int[maps.length][maps[0].length()]; // 출발 지점에서 각 지점까지의 최단 거리
        bfs(new Node(node_info[0][0], node_info[0][1]), maps);
        if(dist[node_info[1][0]][node_info[1][1]] != 0) {
            answer += dist[node_info[1][0]][node_info[1][1]];
            System.out.println("answer (1): " + answer);
        } else {
            System.out.println("빠짐");
            return -1;
        }



        // 레버 -> 출구까지의 최단 거리 (최단거리 초기화) 
        for(int[] d : dist) {
            Arrays.fill(d, 0);
        }
        bfs(new Node(node_info[1][0], node_info[1][1]), maps);
        if(answer != 0 && dist[node_info[2][0]][node_info[2][1]] != 0) {
            return answer += dist[node_info[2][0]][node_info[2][1]];
        }

        return -1;
    }

    private static void bfs(Node node, String[] maps) {
        ArrayDeque<Node> dq = new ArrayDeque<>();

        // 시작 노드 넣어주기 
        dq.offer(node); // 너비 우선 탐색에서 큐에 있는 노드들은 방문한 노드이다.

        while(!dq.isEmpty()) {
            Node now = dq.poll(); // 현재 꺼낸 노드 

            // 꺼낸 노드의 인접 노드들에 대해 방문하지 않은 것들을 탐색 
            for(int i = 0; i < rx.length; i++) {
                int dx = now.x + rx[i];
                int dy = now.y + ry[i];

                if(dx < 0 || dy < 0 || dx >= n || dy >= m) {
                    continue;
                } // 범위를 벗어나면

                if(maps[dx].charAt(dy) == 'X' || dist[dx][dy] != 0) {
                    continue;
                } // 방문할 수 없다면 (벽)

                // 해당 dx, dy 위치로 이동 가능하다는 것
                dist[dx][dy] = dist[now.x][now.y] + 1;
                dq.offer(new Node(dx, dy));
            }
        }



    }

    private static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}