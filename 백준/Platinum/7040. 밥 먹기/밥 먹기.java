import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] distance; // 거리 배열
    static List<Edge> edge = new ArrayList<>(); // 에지 리스트
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int ML = Integer.parseInt(st.nextToken());
        int MD = Integer.parseInt(st.nextToken());

        distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        // ML 입력받기
        for (int i = 0; i < ML; i++) {
            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            edge.add(new Edge("ML", c1, c2, d));
        }

        // MD 입력받기
        for (int i = 0; i < MD; i++) {
            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            edge.add(new Edge("MD", c1, c2, d));
        }

         // 시작 노드의 거리 배열 값은 0이다.
        distance[1] = 0;
         // N-1번 벨만-포드를 반복한다.
        for (int i = 0; i < N - 1; i++) {
            for (Edge e : edge) {
                if(e.mode.equals("ML")) {
                    if(distance[e.c1] != Integer.MAX_VALUE && distance[e.c2] > distance[e.c1] + e.d) {
                        distance[e.c2] = distance[e.c1] + e.d;
                    }
                } else if(e.mode.equals("MD")) {
                    if(distance[e.c2] != Integer.MAX_VALUE && distance[e.c1] > distance[e.c2] - e.d) {
                        distance[e.c1] = distance[e.c2] - e.d;
                    }
                }
            }
        }

        boolean imPossible = false;
        for (Edge e : edge) {
            if(e.mode.equals("ML")) {
                if(distance[e.c1] != Integer.MAX_VALUE && distance[e.c2] > distance[e.c1] + e.d) {
                    imPossible = true;
                }
            } else if(e.mode.equals("MD")) {
                if(distance[e.c2] != Integer.MAX_VALUE && distance[e.c1] > distance[e.c2] - e.d) {
                    imPossible = true;
                }
            }
        }

        if(imPossible) System.out.println(-1);
        else if(distance[N] == Integer.MAX_VALUE) System.out.println(-2);
        else System.out.println(distance[N]);
    }

    static class Edge {
         String mode;
         int c1;
         int c2;
         int d;

         Edge(String mode, int c1, int c2, int d) {
             this.mode = mode;
             this.c1 = c1;
             this.c2 = c2;
             this.d = d;
         }
    }

}
