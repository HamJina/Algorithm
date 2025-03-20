import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Deque<Integer> queue = new ArrayDeque<>();
        //큐 초기화하기 (0을 w개 채워넣기)
        for (int i = 0; i < w; i++) {
            queue.offer(0);
        }

        st = new StringTokenizer(br.readLine());
        int sum = 0; //현재 다리에 올라와있는 트럭 무게의 합
        int count = 0;
        for (int i = 0; i < n; i++) {
            int next = Integer.parseInt(st.nextToken());
            while(queue.size() == w) {
                int total = sum + next - queue.peek();
                //next가 다리에 올라와도 될 때
                if(total <= l) {
                    queue.poll();
                    queue.offer(next);
                    sum = total;
                    count++;
                    break;
                }else{ //next가 무게 초과로 올라올 수 없을때
                    sum -= queue.poll();
                    queue.offer(0);
                    count++;
                }
            }
        }

        while(!queue.isEmpty()) {
            queue.poll();
            count++;
        }

        System.out.println(count);
    }
}
