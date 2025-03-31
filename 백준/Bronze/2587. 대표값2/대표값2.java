import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] A = new int[5];

        for (int i = 0; i < 5; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        double average = Arrays.stream(A).average().getAsDouble();
        Arrays.sort(A);

        System.out.println((int) average); //평균 출력하기
        System.out.println(A[2]); //중앙값 출력하기
    }
}
