import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        boolean[] visited = new boolean[N + 1]; // 방문 여부 저장
        ArrayList<Node>[] adjList = new ArrayList[N + 1]; // 그래프 정보 저장
        int[] dist = new int[N + 1]; // 1번 마을에서 각 마을까지의 최단 거리 저장 배열

        for(int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 그래프 채우기 
        for(int[] r : road) {
            int x = r[0];
            int y = r[1];
            adjList[x].add(new Node(y, r[2]));
            adjList[y].add(new Node(x, r[2]));
        }
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 우선순위 큐 
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w); // 가중치에 대해 오름차순 정렬

        // 시작 노드에 대해 초기화 
        dist[1] = 0;
        pq.add(new Node(1, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.v]) continue;
            visited[now.v] = true;

            for(Node next : adjList[now.v]) {
                if(dist[next.v] > now.w + next.w) {
                    dist[next.v] = now.w + next.w;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }

        System.out.println(Arrays.toString(dist));




        return (int) Arrays.stream(dist).filter(o -> o <= K).count();
    }

    private static class Node {
        int v;
        int w;

        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}