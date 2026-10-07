import java.util.*;

class Solution {
    private static ArrayDeque<Info> dq = new ArrayDeque<>();
    private static int[][] tree; // 0번이 왼쪽 자식, 1번이 오른쪽 자식
    private static int maxCount = 0;
    public int solution(int[] info, int[][] edges) {
        tree = new int[info.length][2];
        // edges를 순회하면서 트리 구축하기 
        for(int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            
            // 왼쪽 자식 노드가 비었는지 먼저 확인
            if(tree[parent][0] == 0) {
                tree[parent][0] = child;
            } else if(tree[parent][1] == 0) {
                tree[parent][1] = child;
            }
        }
        
        dq.addFirst(new Info(0, 0, 0, new HashSet<>())); 
        
        while(!dq.isEmpty()) {
            Info cur = dq.pollFirst();
            
            if(cur.visited.contains(cur.now)) continue;
            
            if(info[cur.now] == 1 && tree[cur.now][0] == 0 && tree[cur.now][1] == 0) continue;
            
            if(info[cur.now] == 1 && cur.sheep <= cur.wolf + 1) continue;
            
            // cur에 대해 방문
            HashSet<Integer> updatedVisited = new HashSet<>(cur.visited);
            updatedVisited.add(cur.now);
            
            // 현재 노드에 대한 양과 늑대 수 업데이트 
            int sheep = cur.sheep;
            int wolf = cur.wolf;
            if(info[cur.now] == 0) {
                sheep += 1;
                maxCount = Math.max(maxCount, sheep);
            } else {
                wolf += 1;
            }
            
            // 현재 노드의 자식 노드 방문하기 
            for(int v : updatedVisited) {
    for(int i = 0; i < 2; i++) {
        int next = tree[v][i];
        if(next != 0 && !updatedVisited.contains(next)) {
            if(info[next] == 0) {
                dq.addFirst(new Info(sheep, wolf, next, updatedVisited));
            } else {
                dq.addLast(new Info(sheep, wolf, next, updatedVisited));
            }
        }
    }
}
            
            
        }
        
        return maxCount;

    }
    
    static class Info {
            int sheep, wolf, now;
            HashSet<Integer> visited = new HashSet<>();
            
            Info(int sheep, int wolf, int now, HashSet<Integer> visited) {
                this.sheep = sheep;
                this.wolf = wolf;
                this.now = now;
                this.visited = visited;
            }
        }
}