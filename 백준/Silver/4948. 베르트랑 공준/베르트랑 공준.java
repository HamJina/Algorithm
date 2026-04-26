import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) break;

            int[] A = new int[2 * n + 1];

            // 초기화 하기
            for (int i = 0; i < 2 * n + 1; i++) {
                A[i] = i;
            }

            A[0] = 0;
            A[1] = 0;

            for (int i = 2; i <= Math.sqrt(2 * n); i++) {
                if (A[i] == 0) continue;

                for (int j = i + i; j < 2 * n + 1; j += i) {
                    A[j] = 0;
                }
            }


            int count = 0;
            for (int i = n + 1; i < 2 * n + 1; i++) {
                if (A[i] != 0) count++;
            }

            System.out.println(count);
        }
    }
}
