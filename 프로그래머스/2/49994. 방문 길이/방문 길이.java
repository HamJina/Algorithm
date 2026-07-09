import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<NodeSet> set = new HashSet<>();
        Node cur = new Node(0, 0);
        for (int i = 0; i < dirs.length(); i++) {
            char d = dirs.charAt(i);
            if (cur.moveable(d)) {
                Node next = cur.move(d);   // 새 객체 반환, cur은 안 바뀜
                set.add(new NodeSet(cur, next));
                cur = next;
            }
        }
        return set.size();
    }

    static class Node {
        final int x, y;
        Node(int x, int y) { this.x = x; this.y = y; }

        boolean moveable(char d) {
            switch (d) {
                case 'U': return y + 1 <= 5;
                case 'D': return y - 1 >= -5;
                case 'R': return x + 1 <= 5;
                case 'L': return x - 1 >= -5;
            }
            return true;
        }

        Node move(char d) {
            switch (d) {
                case 'U': return new Node(x, y + 1);
                case 'D': return new Node(x, y - 1);
                case 'R': return new Node(x + 1, y);
                case 'L': return new Node(x - 1, y);
            }
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node n = (Node) o;
            return x == n.x && y == n.y;
        }

        @Override
        public int hashCode() { return Objects.hash(x, y); }
    }

    static class NodeSet {
        final Node prev, next;
        NodeSet(Node a, Node b) {
            boolean aFirst = a.x != b.x ? a.x < b.x : a.y <= b.y;
            if (aFirst) { prev = a; next = b; }
            else        { prev = b; next = a; }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof NodeSet)) return false;
            NodeSet n = (NodeSet) o;
            return prev.equals(n.prev) && next.equals(n.next);
        }

        @Override
        public int hashCode() { return Objects.hash(prev, next); }
    }
}