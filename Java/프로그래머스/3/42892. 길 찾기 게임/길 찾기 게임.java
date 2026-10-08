import java.util.*;
import java.util.stream.*;

// 이진 탐색 트리 
class Solution {
    static class Node{
        int x, y, index;
        Node left, right;
        
        Node(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }   
    }
    
    private static ArrayList<Integer>[] result = new ArrayList[2];
    private static Node[] node;
   
    public int[][] solution(int[][] nodeinfo) {
        
        for(int i = 0; i < 2; i++) {
            result[i] = new ArrayList<>();
        }
        
        node = new Node[nodeinfo.length];
        for(int i = 0; i < nodeinfo.length; i++) {
            int[] info = nodeinfo[i]; // [5. 3]
            node[i] = new Node(info[0], info[1], i+1);
        }
        
        Node[] sorted = Arrays.stream(node).sorted((o1, o2) -> {
           if(o1.y == o2.y) {
               return o1.x - o2.x;
           } 
            return o2.y - o1.y;
        }).toArray(Node[]::new);
        
        // 트리 구성
        Node root = sorted[0];
        for (int i = 1; i < sorted.length; i++) {
            Node now = sorted[i];
            Node parent = root;              // 매번 루트부터 시작
            while (true) {
                if (now.x < parent.x) {
                    if (parent.left == null) { parent.left = now; break; }
                    parent = parent.left;    // 왼쪽 자식으로 내려감
                } else {
                    if (parent.right == null) { parent.right = now; break; }
                    parent = parent.right;
                }
            }
        }
        
        preOrder(sorted[0]);
        postOrder(sorted[0]);
            
        int[] pre = result[0].stream().mapToInt(Integer::intValue).toArray();
        int[] post = result[1].stream().mapToInt(Integer::intValue).toArray();
        int[][] answer = new int[2][pre.length];
        answer[0] = pre;
        answer[1] = post;
        
        return answer;
   
    }
    
    static void preOrder(Node now) {
        // 종료 조건
        if (now == null) return;
        
        result[0].add(now.index);
        preOrder(now.left);
        preOrder(now.right);
    }
    
    static void postOrder(Node now) {
        if (now == null) return;
    
        postOrder(now.left);
        postOrder(now.right);
        result[1].add(now.index);
    }

}