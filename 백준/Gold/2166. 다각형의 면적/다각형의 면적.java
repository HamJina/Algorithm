import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Coordinates[] p = new Coordinates[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            p[i] = new Coordinates(a, b);
        }

        double result = 0;
        for (int i = 0; i < N; i++) {
            int j = (i + 1) % N; // 다음 점, 마지막 → 첫 점으로 순환
            result += (long)p[i].x * p[j].y - (long)p[j].x * p[i].y;
        }

        System.out.printf("%.1f\n", Math.abs(result) / 2.0);
    }

    public static class Coordinates {
        int x, y;
        Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
