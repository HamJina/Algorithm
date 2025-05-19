import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static PriorityQueue<Edge> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        queue = new PriorityQueue<>();
        parent = new int[N+1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            queue.add(new Edge(S, E, V));
        }

        int useEdge = 0;
        int result = 0;
        while (useEdge < N-1) {
            Edge poll = queue.poll();
            if(find(poll.s) != find(poll.e)) {
                union(poll.s, poll.e);
                result += poll.v;
                useEdge++;
            }
        }

        System.out.println(result);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a!=b) parent[b] = a;
    }

    static int find(int a) {
        if(a == parent[a]) return a;
        else return parent[a] = find(parent[a]);
    }
}

class Edge implements Comparable<Edge>{
    int s, e, v;

    public Edge(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }


    @Override
    public int compareTo(Edge o) {
        return this.v-o.v;
    }
}
