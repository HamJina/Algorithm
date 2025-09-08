import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] visited;
    static Queue<Cabbage> queue = new LinkedList<>();
    static int T, M, N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로 길이 (열)
            N = Integer.parseInt(st.nextToken()); // 세로 길이 (행)
            K = Integer.parseInt(st.nextToken()); // 배추 위치 개수

            visited = new int[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); // 가로
                int y = Integer.parseInt(st.nextToken()); // 세로
                visited[y][x] = 1; // 좌표 저장
            }

            queue.clear();
            int count = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (visited[r][c] == 1) {
                        BFS(r, c);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void BFS(int r, int c) {
        visited[r][c] = 0;
        queue.add(new Cabbage(r, c));

        while (!queue.isEmpty()) {
            Cabbage cur = queue.poll();

            // 상
            if (cur.r - 1 >= 0 && visited[cur.r - 1][cur.c] == 1) {
                visited[cur.r - 1][cur.c] = 0;
                queue.add(new Cabbage(cur.r - 1, cur.c));
            }
            // 하
            if (cur.r + 1 < N && visited[cur.r + 1][cur.c] == 1) {
                visited[cur.r + 1][cur.c] = 0;
                queue.add(new Cabbage(cur.r + 1, cur.c));
            }
            // 좌
            if (cur.c - 1 >= 0 && visited[cur.r][cur.c - 1] == 1) {
                visited[cur.r][cur.c - 1] = 0;
                queue.add(new Cabbage(cur.r, cur.c - 1));
            }
            // 우
            if (cur.c + 1 < M && visited[cur.r][cur.c + 1] == 1) {
                visited[cur.r][cur.c + 1] = 0;
                queue.add(new Cabbage(cur.r, cur.c + 1));
            }
        }
    }

    static class Cabbage {
        int r, c;
        Cabbage(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
