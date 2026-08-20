import java.util.*;
import java.util.stream.*;

// 이진 탐색 트리 
class Solution {
    private static int root_key;
    private static ArrayList<Integer>[] answer = new ArrayList[2];

    private static int[][] tree;

    public int[][] solution(int[][] nodeinfo) {
        answer[0] = new ArrayList<>();
        answer[1] = new ArrayList<>();

        HashMap<Integer, int[]> map = new HashMap<>();
        tree = new int[nodeinfo.length + 1][2];


        for(int i = 0; i < nodeinfo.length; i++) {
            map.put(i+1, nodeinfo[i]);
        }

        List<Map.Entry<Integer, int[]>> list = map.entrySet().stream()
                .sorted(
                        Comparator.<Map.Entry<Integer, int[]>>comparingInt(e -> e.getValue()[1]).reversed()
                                .thenComparingInt(e -> e.getValue()[0])
                )
                .toList();

        root_key = list.get(0).getKey(); // 7번

        for(int i = 1; i < list.size(); i++) {
            // i = 2, key: 2, value: (11, 5)
            int cur_key = list.get(i).getKey();

            // cur_key가 들어갈 위치 찾기 
            int parent = root_key; // 7에서 시작
            while(true) {
                if(map.get(parent)[0] > map.get(cur_key)[0]) { // x값 보다 작으면 왼쪽 자식 노드로 
                    if(tree[parent][0] != 0) {
                        // 이미 차있음
                        parent = tree[parent][0];
                        continue;
                    } else {
                        // 비어있음 끝!!
                        tree[parent][0] = cur_key;
                        break;
                    }
                } else { // 부모보다 x값이 크면 오른쪽 자식 노드로
                    if(tree[parent][1] != 0) {
                        // 이미 차있음
                        parent = tree[parent][1];
                        continue;
                    } else {
                        tree[parent][1] = cur_key;
                        break;
                    }

                }
            }
        }

        preOrder(root_key);
        postOrder(root_key);

        // ArrayList<Integer>[] -> int[][]
        return Arrays.stream(answer)
                .map(a -> a.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }

    public static void preOrder(int root_key) {
        if(root_key == 0) return;

        answer[0].add(root_key);
        preOrder(tree[root_key][0]);
        preOrder(tree[root_key][1]);
    }

    public static void postOrder(int root_key) {
        if(root_key == 0) return;

        postOrder(tree[root_key][0]);
        postOrder(tree[root_key][1]);
        answer[1].add(root_key);
    }
}