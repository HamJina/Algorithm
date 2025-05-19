import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parent = new int[N];
        for (int i = 0; i < N; i++) parent[i] = i;

        int totalLength = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        // 입력 처리
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = line.charAt(j);
                if (c == '0') continue;
                int length = getLength(c);
                totalLength += length;
                if (i != j) pq.offer(new Edge(i, j, length)); // 자기 자신은 제외
            }
        }

        int mstLen = 0;
        int usedEdges = 0;

        while (!pq.isEmpty() && usedEdges < N - 1) {
            Edge e = pq.poll();
            if (find(e.u) != find(e.v)) {
                union(e.u, e.v);
                mstLen += e.len;
                usedEdges++;
            }
        }

        if (usedEdges == N - 1) {
            System.out.println(totalLength - mstLen);
        } else {
            System.out.println(-1);
        }
    }

    static int getLength(char c) {
        if ('a' <= c && c <= 'z') return c - 'a' + 1;
        else return c - 'A' + 27;
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }

    static class Edge implements Comparable<Edge> {
        int u, v, len;
        Edge(int u, int v, int len) {
            this.u = u;
            this.v = v;
            this.len = len;
        }
        public int compareTo(Edge o) {
            return this.len - o.len;
        }
    }
}
