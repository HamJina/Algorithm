import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //과목 갯수
        double[] scores = new double[n];
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }

        //점수 중 최댓값 찾기
        double M = Arrays.stream(scores).max().getAsDouble();

        //점수 조작하기 (점수/M*100)
        double[] manipulatedScores = Arrays.stream(scores).map((score) -> score / M * 100).toArray();

        //조작된 점수들의 평균계산하기
        double result = Arrays.stream(manipulatedScores).average().getAsDouble();
        System.out.println(result);
    }
}