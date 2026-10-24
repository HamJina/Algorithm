import java.util.*;

class Solution {
    private static int[] rx = {1, -1, 0, 0};
    private static int[] ry = {0, 0, 1, -1};
    private static HashMap<Integer, Integer> map;
    private static int N;
    private static int M;
    private static int total;
    private static HashSet<Integer> set;
    private static int[][] Land;

    public int solution(int[][] land) {
        Land = land;
        N = land.length; // 행
        M = land[0].length; // 열
        map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(land[i][j] == 1) {
                    total = 0;
                    set = new HashSet<>();
                    bfs(i, j);

                    for(int s : set) { // s가 열
                        map.put(s, map.getOrDefault(s, 0) + total);
                    }
                }
            }
        }

        // map에서 가장 value가 큰 것 찾기
        int max = 0;
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            if(e.getValue() > max) max = e.getValue();
        }
        return max;
    }

    static void bfs(int sx, int sy) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy});
        Land[sx][sy] = 0; // 큐에 넣을 때 방문 처리
        total++;
        set.add(sy);

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur[0] + rx[i];
                int ny = cur[1] + ry[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(Land[nx][ny] == 0) continue;

                Land[nx][ny] = 0;
                total++;
                set.add(ny);
                q.offer(new int[]{nx, ny});
            }
        }
    }
}