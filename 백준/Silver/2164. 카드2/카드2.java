import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

//1644
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Deque<Integer> queue = new ArrayDeque<>();

        //큐 채우기
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        //카드가 한개가 남는 순간 끝내기
        while(queue.size() != 1) {
            //제일 위에 있는 카드 버리기
            if(!queue.isEmpty()) queue.poll();

            //제일 위에 있는 카드를 밑으로 보내기
            if(!queue.isEmpty()) {
                queue.offer(queue.peek());
                queue.poll();
            }
        }

        System.out.println(queue.peek());
    }
}
