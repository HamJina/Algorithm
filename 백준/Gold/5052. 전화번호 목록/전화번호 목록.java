import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            tNode root = new tNode();
            boolean isConsistent = true;

            String[] numbers = new String[n];
            for (int j = 0; j < n; j++) {
                numbers[j] = sc.next();
            }

            Arrays.sort(numbers); // 짧은 번호 먼저 넣는 것이 안정적임

            for (String str : numbers) {
                tNode now = root;
                for (int k = 0; k < str.length(); k++) {
                    char c = str.charAt(k);
                    if (now.next[c - '0'] == null) {
                        now.next[c - '0'] = new tNode();
                    }
                    now = now.next[c - '0'];
                    if (now.isEnd) {
                        isConsistent = false;
                        break;
                    }
                }

                if (!isConsistent) break;
                if (now.hasChild()) { // 새로 추가된 번호가 기존 번호의 prefix라면
                    isConsistent = false;
                    break;
                }
                now.isEnd = true;
            }

            System.out.println(isConsistent ? "YES" : "NO");
        }
    }
}

class tNode {
    tNode[] next = new tNode[10];
    boolean isEnd;

    boolean hasChild() {
        for (tNode child : next) {
            if (child != null) return true;
        }
        return false;
    }
}
