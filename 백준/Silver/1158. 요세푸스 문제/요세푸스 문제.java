import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt(); // k번째 사람 제거
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        Deque<Integer> queue = new ArrayDeque<>();

        // 큐 채우기
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        // 요세푸스 순열 구현
        while (!queue.isEmpty()) {
            for (int i = 1; i < k; i++) {
                queue.offer(queue.poll()); // k-1번째까지 맨 뒤로 이동
            }
            sb.append(queue.poll()); // k번째 요소 제거
            if (!queue.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append(">");
        System.out.println(sb.toString());
    }
}
