import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String equation = br.readLine();

        String[] split = equation.split("-");
        int result = 0;

        // 첫 번째 덩어리는 무조건 더함
        String[] first = split[0].split("\\+");
        for (String num : first) {
            result += Integer.parseInt(num);
        }

        // 나머지는 괄호로 묶인 것처럼 모두 빼기
        for (int i = 1; i < split.length; i++) {
            String[] part = split[i].split("\\+");
            int sum = 0;
            for (String num : part) {
                sum += Integer.parseInt(num);
            }
            result -= sum;
        }
        System.out.println(result);

    }
}
