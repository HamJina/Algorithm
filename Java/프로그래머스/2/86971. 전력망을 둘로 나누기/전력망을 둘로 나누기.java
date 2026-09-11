import java.util.*;

class Solution {
    private static ArrayList<Integer>[] adj;
    private static boolean[] visited;
    private static ArrayList<Integer> answer = new ArrayList<>();
    private static int count = 0;

    public int solution(int n, int[][] wires) {
        adj = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for(int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] w : wires) {
            adj[w[0]].add(w[1]);
            adj[w[1]].add(w[0]);
        }

        for(int[] w : wires) {
            Arrays.fill(visited, false);
            visited[w[1]] = true;
            count = 0;

            int a = dfs(w[0]);
            int b = n - a;

            answer.add(Math.abs(a - b));
        }

        return answer.stream().min((o1, o2) -> o1-o2).get();
    }

    private static int dfs(int n) {
        visited[n] = true;
        count++;

        for(Integer i : adj[n]) {
            if(!visited[i]) {
                dfs(i);
            }
        }

        return count;
    }
}