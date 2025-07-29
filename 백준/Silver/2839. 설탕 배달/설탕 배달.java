import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(minNum(N, 0));
    }

    public static int minNum(int N, int count) {
        if (N < 0) return -1;              // 음수면 불가능
        if (N % 5 == 0) return count + N / 5;  // 5로 나눠지면 봉지 수 계산
        return minNum(N - 3, count + 1);   // 3을 빼고 계속 시도
    }
}
