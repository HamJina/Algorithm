import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M, N, sum;
    static List<Integer> snacks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 조카 수
        N = Integer.parseInt(st.nextToken()); // 과자 수

        snacks = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        // 과자 리스트 채우기
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            sum += value;
            snacks.add(value);
        }

        Collections.sort(snacks, Collections.reverseOrder()); // 내림차순 정렬
        System.out.println(findMaxSnackLength());
    }

    static int findMaxSnackLength() {
        if (sum < M) return 0;

        int left = 1, right = snacks.get(0), max = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int count = countDivisions(mid);

            if (count >= M) { 
                max = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return max;
    }

    static int countDivisions(int length) {
        int count = 0;
        for (int snack : snacks) {
            count += snack / length;
        }
        return count;
    }
}