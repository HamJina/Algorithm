import java.io.*;
import java.util.*;

public class Main {
    static int min_value = Integer.MAX_VALUE;
    static int[][] A;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N+1][M+1];
        //배열 채우기
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                A[i][j] = Integer.parseInt(str.substring(j-1, j));
            }
        }

        int bfs = BFS(1, 1, 1);//너비우선 탐색 진행
        System.out.println(bfs);
    }

    static class Node{
        int s;
        int e;
        int depth;

        public Node(int s, int e, int depth) {
            this.s = s;
            this.e = e;
            this.depth = depth;
        }

        public int getS() {
            return s;
        }

        public int getE() {
            return e;
        }

        public int getDepth() {
            return depth;
        }
    }

    static int BFS(int i, int j, int currentDepth) {
        Deque<Node> queue = new ArrayDeque<>();
        //시작 노드는 i, j(1, 1)
        queue.offer(new Node(i, j, currentDepth));
        A[i][j] = 0;

        while(!queue.isEmpty()) {
            Node poll = queue.poll();

            int s = poll.getS();
            int e = poll.getE();
            int depth = poll.getDepth();
            if(s == N && e == M) {
                return depth;
            }
            //큐에서 나온 노드의 이웃 노드들에 대해 BFS를 실행한다.
            if(s + 1 <= N && A[s+1][e] == 1) {
                queue.offer(new Node(s+1, e, depth+1));
                A[s+1][e] = 0;
            }
            if(s - 1 >= 1 && A[s-1][e] == 1) {
                queue.offer(new Node(s-1, e, depth+1));
                A[s-1][e] = 0;
            }
            if(e + 1 <= M && A[s][e+1] == 1) {
                queue.offer(new Node(s, e+1, depth+1));
                A[s][e+1] = 0;
            }
            if(e - 1 >= 1 && A[s][e-1] == 1) {
                queue.offer(new Node(s, e-1, depth+1));
                A[s][e-1] = 0;
            }
        }
        return -1;
    }



}