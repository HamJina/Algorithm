import java.util.*;

class Solution {
    private static int n;
    private static int m;
    private static Node cur_node;

    public int solution(int[][] maps) {
        n = maps.length - 1;
        m = maps[0].length - 1;
        cur_node = new Node(0, 0, 1);

        return bfs(cur_node, maps);

    }

    private static int bfs(Node node, int[][] maps) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.offer(node);
        maps[node.x][node.y] = 0; // 시작 노드도 offer 시점에 방문 표시

        while (!dq.isEmpty()) {
            cur_node = dq.poll();

            if (cur_node.x == n && cur_node.y == m) {
                return cur_node.dis;
            }

            if (cur_node.x + 1 <= n && maps[cur_node.x + 1][cur_node.y] == 1) {
                maps[cur_node.x + 1][cur_node.y] = 0; // offer 전에 표시
                dq.offer(new Node(cur_node.x + 1, cur_node.y, cur_node.dis + 1));
            }
            if (cur_node.x - 1 >= 0 && maps[cur_node.x - 1][cur_node.y] == 1) {
                maps[cur_node.x - 1][cur_node.y] = 0;
                dq.offer(new Node(cur_node.x - 1, cur_node.y, cur_node.dis + 1));
            }
            if (cur_node.y + 1 <= m && maps[cur_node.x][cur_node.y + 1] == 1) {
                maps[cur_node.x][cur_node.y + 1] = 0;
                dq.offer(new Node(cur_node.x, cur_node.y + 1, cur_node.dis + 1));
            }
            if (cur_node.y - 1 >= 0 && maps[cur_node.x][cur_node.y - 1] == 1) {
                maps[cur_node.x][cur_node.y - 1] = 0;
                dq.offer(new Node(cur_node.x, cur_node.y - 1, cur_node.dis + 1));
            }
        }
        return -1;
    }

    private static class Node {
        int x;
        int y;
        int dis;

        Node(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
}