import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            int n = sc.nextInt();
            if(n == 0) stack.pop();
            else stack.push(n);
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        System.out.println(sum);
    }
}
