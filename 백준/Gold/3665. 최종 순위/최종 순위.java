import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] lastRank;
    static ArrayList<ArrayList<Integer>> arrayList; // 매 케이스마다 재생성
    static int[] D;                                 // 진입차수
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int tc = 0; tc < t; tc++) {
            n = Integer.parseInt(br.readLine()); // 팀의 개수

            // 작년 순위
            lastRank = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                lastRank[j] = Integer.parseInt(st.nextToken()); // (OK) j 인덱스에 저장
            }

            // 인접리스트/진입차수 초기화
            arrayList = new ArrayList<>(n + 1);
            for (int j = 0; j <= n; j++) arrayList.add(new ArrayList<>());
            D = new int[n + 1];

            // 작년 순위를 인접리스트에 저장 (앞팀 -> 뒷팀)
            for (int j = 1; j <= n; j++) {
                for (int k = j + 1; k <= n; k++) {
                    int u = lastRank[j]; // (버그 수정) j
                    int v = lastRank[k]; // (버그 수정) k
                    arrayList.get(u).add(v);
                    D[v]++;
                }
            }

            // 상대적인 등수가 바뀐 쌍의 수
            int m = Integer.parseInt(br.readLine());
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                changeRank(a, b); // 간선 반전 + 진입차수 동기화
            }

            // 최종 위상 정렬 적용하여 올해 순위 출력하기
            out.append(topologicalSort()).append('\n');
        }

        System.out.print(out.toString());
    }

    private static String topologicalSort() {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) if (D[i] == 0) queue.offer(i);

        List<Integer> order = new ArrayList<>(n);
        boolean ambiguous = false;

        for (int step = 0; step < n; step++) {
            if (queue.isEmpty()) return "IMPOSSIBLE";   // 사이클 존재

            if (queue.size() > 1) ambiguous = true;     // 같은 시점의 후보가 2개 이상 → 모호

            int now = queue.poll();
            order.add(now);

            for (int next : arrayList.get(now)) {
                D[next]--;
                if (D[next] == 0) queue.offer(next);
            }
        }

        if (ambiguous) return "?";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) sb.append(' ');
            sb.append(order.get(i));
        }
        return sb.toString();
    }

    // a와 b팀의 상대적 순위 바꾸기 (간선 반전 + 진입차수 갱신)
    private static void changeRank(int a, int b) {
        // a -> b 가 있으면 b -> a 로 뒤집기
        if (arrayList.get(a).contains(b)) {
            arrayList.get(a).remove((Integer) b); // remove(Object)로 정확히 삭제
            D[b]--;
            arrayList.get(b).add(a);
            D[a]++;
        }
        // 없으면 b -> a가 있다고 보고 a -> b로 뒤집기
        else if (arrayList.get(b).contains(a)) {
            arrayList.get(b).remove((Integer) a);
            D[a]--;
            arrayList.get(a).add(b);
            D[b]++;
        }
    }
}
