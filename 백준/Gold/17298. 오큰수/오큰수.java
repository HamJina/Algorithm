import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[n];
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> stack = new ArrayDeque<>(); // 오큰수 후보를 저장하는 스택

        for (int i = n - 1; i >= 0; i--) {
            // 스택에서 현재 원소보다 작거나 같은 값 제거 (오큰수가 될 수 없음)
            while (!stack.isEmpty() && stack.peek() <= array[i]) {
                stack.pop();
            }

            // 오큰수 설정
            result[i] = stack.isEmpty() ? -1 : stack.peek();

            // 현재 원소를 스택에 추가
            stack.push(array[i]);
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
}
