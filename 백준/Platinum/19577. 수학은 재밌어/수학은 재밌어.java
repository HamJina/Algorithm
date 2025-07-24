import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 자연수

        int result = -1;

        // 약수만 순회하도록 개선
        for (int x : getDivisors(n)) {
            if (x * phi(x) == n) {
                result = x;
                break;
            }
        }

        System.out.println(result);
    }

    // 약수 리스트를 반환하는 함수
    private static ArrayList<Integer> getDivisors(int num) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                list.add(i);
                if (i != num / i) list.add(num / i);
            }
        }
        list.sort(Integer::compareTo); // 작은 수부터 탐색하게 정렬
        return list;
    }

    // 오일러 피 함수
    private static int phi(int x) {
        int value = x;
        int temp = x;

        for (int i = 2; i * i <= temp; i++) {
            if (temp % i == 0) {
                value = value - value / i;
                while (temp % i == 0) temp /= i;
            }
        }
        if (temp > 1) {
            value = value - value / temp;
        }
        return value;
    }
}
