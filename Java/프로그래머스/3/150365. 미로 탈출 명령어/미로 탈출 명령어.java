import java.util.*;

class Solution {
    private static final int[] dx = {1, 0, 0, -1};
    private static final int[] dy = {0, -1, 1, 0};
    private static char[] ch = {'d', 'l', 'r', 'u'};
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int dist = Math.abs(x - r) + Math.abs(y - c);
        if(dist > k || (k - dist) % 2 == 1) return "impossible";
        // 불가능한 경우는 사전에 없애기 

        int tr = r - 1, tc = c - 1; // 도착점도 0-index로 변환

        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(x - 1, y - 1, 0, ""));

        while(!dq.isEmpty()) {
            Node now = dq.poll();

            if(now.x == tr && now.y == tc && now.k == k) {
                return now.route;
            }

            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                // 남은 이동 횟수로 도착점에 갈 수 없으면 가지치기
                int remain = k - (now.k + 1);
                if(Math.abs(nx - tr) + Math.abs(ny - tc) > remain) continue;

                dq.add(new Node(nx, ny, now.k + 1, now.route + ch[i]));
                break; // 사전순으로 처음 가능한 방향이 정답
            }
        }

        return "impossible";
    }

    static class Node {
        int x, y; // 현재 노드의 좌표
        int k; // 현재까지 이동한 거리 
        String route; // 현재까지의 경로 

        Node(int x, int y, int k, String route) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.route = route;
        }
    }
}